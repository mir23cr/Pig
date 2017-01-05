/**
* @author Vladimir Aguilar Corrales
* Carne: B50120
* Curso: Programacion I
* Profesora: Josefina Pujol
* Nota: Todas las variables de clase tienen un guion bajo para identificarlas con facilidad
* Esta clase maneja los puntajes del juego y los turnos
*/
import java.util.Random;

public class Juego {
 private final int PUNTAJELIMITE=100;
 private int _jug1;
 private int _jug2;
 private int _puntajeTmp;
 private int _valorDado;
 private int _turno;
 private int _cantJugadas;
 
 public Juego(){
  reiniciarJuego();
 }//Fin constructor Juego
 
 //Inicializa todas las variables
 public void reiniciarJuego(){
  _jug1=0;
  _jug2=0;
  _turno=1;
  _puntajeTmp=0;
  _valorDado=0;
  _cantJugadas=0;
 }
 
 //Retorna un valor de 1 a 6
 public int tirarDado(){
  Random rnd= new Random();
  return (rnd.nextInt(6) + 1);
 }//Fin tirarDado
 
 /*Es en el que se juega y se va acumulando el puntaje temporal
  * o se pierde el turno y por ende los puntos temporales
  */
 public int jugar(){
  _valorDado= tirarDado();
  ++_cantJugadas;
  if(_valorDado==1){
   reiniciarTmp();
  } else{
   _puntajeTmp= _puntajeTmp + _valorDado;
  }
  return _valorDado;
 }//Fin jugar
 
 //Reinicia el puntaje temporal
 public void reiniciarTmp(){
  _puntajeTmp=0;
 }//Fin reiniciar Tmp
 
 /*Analiza quien es el jugador en turno
  * y lo cambia, reiniciando de nuevo el
  * puntaje temporal
  * */
 public void cambiarTurno(){
  _cantJugadas=0;
  if(_turno==1){
   _jug1= _jug1+_puntajeTmp;
   _turno=2;
  } else
  {
   _jug2= _jug2+_puntajeTmp;
   _turno=1;
  } reiniciarTmp();
 }//Fin cambiarTurno
 
 /*Verifica que el usuario o la maquina hayan alcanzado el puntaje maximo
  */ 
 public boolean verificarVictoria(int pPuntaje){
  if(pPuntaje>=PUNTAJELIMITE){
   return true;
  } else
  {
   return false;
  }
 }//Fin verificarVictoria
 
 //Devuelve el valor del dado
 public int getValorDado(){
  return _valorDado;
 }//Fin getValorDado

 /*Devuelve quien esta jugando
  *1: Jugador humano
  *2: PC
  */
 public int getTurno(){
  return _turno;
 }//Fin getTurno
 
 //Devuelve puntaje de jugador humano
 public int getPuntaje1(){
  return _jug1;
 }//Fin getPuntaje1
 
 //Devuelve el puntaje de la PC
 public int getPuntaje2(){
  return _jug2;
 }//Fin getPuntaje2
 
 //Devuelve el puntaje temporal
 public int getPuntajeTmp(){
  return _puntajeTmp;
 }//Fin getPuntajeTmp
 
 /*Clase que decide si la maquina continua o cambia de turno
  * la decisión se basa en que si la maquina le lleva una ventaja
  * de 7 puntos al usuario o ya ha jugado mas de cuatro veces seguidas
  * o su puntaje alcanzo el maximo permitido, entonces deja de jugar
  * en caso contrario continua su turno
  */ 
 public boolean decidirJuego(){
  int diferencia= _jug2+_puntajeTmp-_jug1;
  if(diferencia<=7 && _cantJugadas<4 && _puntajeTmp+_jug2<PUNTAJELIMITE){
   return true;
  } else
  {
   return false;
  }
 }//Fin decidir juego
 
}//Fin clase Juego
