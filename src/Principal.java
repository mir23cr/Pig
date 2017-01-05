/**
* Clase donde se encuentra la interfaz grafica
* @author Vladimir Aguilar Corrales
* Carne: B50120
* Curso: Programacion I
* Profesora: Josefina Pujol
*/


//Bibliotecas importadas
import javax.swing.*;
import java.awt.Color;
import java.io.File;
import java.io.IOException;


public class Principal{
    private String _ruta;
    private Juego _juego= new Juego();
    
    public Principal() throws IOException{
     _ruta= rutaImagenes();
     initComponents();
    }
    
    /*Método devuelve la ruta donde se encuentran las imágenes
     *para no tener que estar cambiando la ubicación, probado en
     * Windows 7 y en Ubuntu 14.04, deja en consola la ubicación
     * de donde deberían de estar las imágenes en caso de que no
     * se encuentren automaticamente copiarlas en la dirección
     * solicitada
     */
    private String rutaImagenes(){
        try {
         File miDir = new File (".");
         String sSistemaOperativo = System.getProperty("os.name");
         String ruta="";
         if (sSistemaOperativo.equals("Linux")){
          ruta=miDir.getCanonicalPath()+"/imagenes/";
         }
         else{
          ruta= miDir.getCanonicalPath()+"\\imagenes\\";
         }
         System.out.println (sSistemaOperativo+" "+ruta);
         return ruta;
        }
        catch(Exception e) {
          e.printStackTrace();
          return "0";
        }
    }//fin rutaImagenes
    
    /*Método que inicializa todos los componentes de la interfaz
     * para que estén listos para aparecer en pantalla
     */
    private void initComponents() throws IOException {
        int altoVentana=520;
        int anchoVentana=750;
        
        //Creacion de la ventana
        ventana = new JFrame("Pig - Juego");
        ventana.setSize(anchoVentana,altoVentana);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false); 
        ventana.setLocationRelativeTo(null);
        //Fin de creacion de la ventana
        
        String tipoLetra="Tahoma";

        //Coordenadas sirven para colocar botones y otros elementos de interfaz
        int x1=anchoVentana/2-52;
        int base=110;
        int y1=10;
        int altura=38;
        
        //Label donde indica de quien es el turno
        turnoLabel= new JLabel();
        turnoLabel.setText("Tu turno");
        turnoLabel.setBounds(x1, y1, base, altura);
        turnoLabel.setFont(new java.awt.Font(tipoLetra, 1, 20));
        
        //TextField y Label del puntaje del jugador
        x1=53;
        y1=y1+10;
        base=80;
        puntaje1TextField= new JTextField();
        puntaje1TextField.setText("0");
        puntaje1TextField.setBounds(x1, y1, base, altura);
        puntaje1TextField.setFont(new java.awt.Font(tipoLetra, 1, 16)); 
        puntaje1TextField.setEnabled(false);
        puntaje1TextField.setDisabledTextColor(Color.black);
        puntaje1TextField.setHorizontalAlignment(JTextField.CENTER);
        
        y1=y1+40;
        puntaje1Label= new JLabel();
        puntaje1Label.setText("<html><p align="+"Center"+">Tus</p><p align="+"Center"+">Puntos</p></html>");//Se utiliza código HTML para centrar texto
        puntaje1Label.setBounds(x1+10, y1, base, altura);
        puntaje1Label.setFont(new java.awt.Font(tipoLetra, 1, 16));

        //TextField y Label del puntaje de la PC
        x1=anchoVentana-140;
        y1=y1-40;
        puntaje2TextField= new JTextField();
        puntaje2TextField.setText("0");
        puntaje2TextField.setBounds(x1, y1, base, altura);
        puntaje2TextField.setFont(new java.awt.Font(tipoLetra, 1, 16)); 
        puntaje2TextField.setEnabled(false);
        puntaje2TextField.setDisabledTextColor(Color.black);
        puntaje2TextField.setHorizontalAlignment(JTextField.CENTER);
        
        y1=y1+40;
        puntaje2Label= new JLabel();
        puntaje2Label.setText("<html><p align="+"Center"+">Puntos</p><p align="+"Center"+">CPU</p></html>");//Se utiliza código HTML para centrar texto
        puntaje2Label.setBounds(x1+10, y1, base, altura);
        puntaje2Label.setFont(new java.awt.Font(tipoLetra, 1, 16));

        //TextField para el puntaje temporal
        
        //TextField del puntaje temporal
        x1=anchoVentana/2-40;
        y1=y1+10;
        puntajeTemporalTextField= new JTextField();
        puntajeTemporalTextField.setText("0");
        puntajeTemporalTextField.setBounds(x1, y1, base, altura);
        puntajeTemporalTextField.setFont(new java.awt.Font(tipoLetra, 1, 16)); 
        puntajeTemporalTextField.setEnabled(false);
        puntajeTemporalTextField.setDisabledTextColor(Color.black);
        puntajeTemporalTextField.setHorizontalAlignment(JTextField.CENTER);
  
        
        //Boton para Jugar
        x1=38;
        y1=altoVentana/2 -20;
        base=110;
        jugarButton = new JButton();    
        jugarButton.setText("Jugar");
        jugarButton.setBounds(x1, y1, base, altura);
        jugarButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarButtonActionPerformed(evt);
            }
        });
        
        //Boton para cambiar de Turno
        y1=y1+40;
        cambiarTurnoButton = new JButton();    
        cambiarTurnoButton.setText("<html><p>Cambiar</p><p align="+"Center"+">Turno</p></html>");
        cambiarTurnoButton.setBounds(x1, y1, base, altura);
        cambiarTurnoButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarTurnoButtonActionPerformed(evt);
            }
        });
        
        //Boton para reiniciar el Juego
        x1=anchoVentana/2-base/2;
        y1=altoVentana-altura*5/2;

        reiniciarButton = new JButton();    
        reiniciarButton.setText("Reiniciar");
        reiniciarButton.setBounds(x1, y1, base, altura);
        reiniciarButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarButtonActionPerformed(evt);
            }
        });
        
        x1=anchoVentana-base*3/2;
        y1=y1-altura*8/6;
        continuarButton = new JButton();    
        continuarButton.setText("Continuar");
        continuarButton.setBounds(x1, y1, base, altura);
        continuarButton.setEnabled(false);
        continuarButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarButtonActionPerformed(evt);
            }
        });
        
        //Imagen del dado inicial
        x1=anchoVentana/2-40;
        y1=altoVentana/2-20;
        dadoLabel = new JLabel();
        dadoLabel.setIcon(new ImageIcon(_ruta+"dado6.png"));
        dadoLabel.setBounds(x1,y1,81,81);
        
        //Imagen del cerdo
        cerdoLabel = new JLabel();
        cerdoLabel.setIcon(new ImageIcon(_ruta+"pig.png"));
        cerdoLabel.setBounds(anchoVentana-168,y1-21,128,131);

        //Imagen de la nube
        nubeLabel = new JLabel();
        nubeLabel.setIcon(new ImageIcon(_ruta+"nubeinicio.png"));
        nubeLabel.setBounds(anchoVentana-248,y1-131,128,131);

        
        //Creacion del Panel donde se almacenan todos los elementos de la interfaz
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(turnoLabel);
        panel.add(dadoLabel);
        panel.add(cerdoLabel);
        panel.add(nubeLabel);
        panel.add(jugarButton);
        panel.add(cambiarTurnoButton);
        panel.add(reiniciarButton);
        panel.add(continuarButton);
        panel.add(puntaje1TextField);
        panel.add(puntaje1Label);
        panel.add(puntaje2TextField);
        panel.add(puntaje2Label);
        panel.add(puntajeTemporalTextField);
        //fin de creacion del Panel con los botones
        
        //Se agrega panel a la ventana
        ventana.add(panel);
        
    }//Fin initComponents

    //Metodo que despliega la pantalla
    public void mostrarPantalla(){
        ventana.setVisible(true);
    }//fin mostrarPantalla

    
    
    /*Metodo que hace toda la logica de la PC para la acumulacion de puntos
     * y su manejo en la GUI cuando es el turno de la maquina
     */ 
    private void juegaPC(){
      boolean seguir=true;
      boolean victoria;
      int resultado=0;
  
      resultado= _juego.jugar();
      dadoLabel.setIcon(new ImageIcon(_ruta+"dado"+resultado+".png"));
      if(resultado!=1){
        puntajeTemporalTextField.setText(Integer.toString(_juego.getPuntajeTmp()));
        //Hay que decidir si sigue jugando
        seguir= _juego.decidirJuego();
      }
      else{
        seguir=false;
      }  
 
      if(!seguir){
        _juego.cambiarTurno();
        puntaje2TextField.setText(Integer.toString(_juego.getPuntaje2()));
        puntajeTemporalTextField.setText("0");
        victoria= _juego.verificarVictoria(_juego.getPuntaje2());
        if(victoria){
          nubeLabel.setIcon(new ImageIcon(_ruta+"nubeperder.png"));
          continuarButton.setEnabled(false);
        }
        else{
          jugarButton.setEnabled(true);
          cambiarTurnoButton.setEnabled(true);
          turnoLabel.setText("Tu turno");
          continuarButton.setEnabled(false);
          nubeLabel.setIcon(new ImageIcon(_ruta+"nubeturnojug.png"));
        }
      }
    }
    
    /*En esta sección se encuentran todos los métodos donde se activan los botones, cada uno tiene al inicio el nombre de cada botón para poder
     * identificarlo.
     */ 
    
    //Hace que el jugador humano tire el dado
    private void jugarButtonActionPerformed(java.awt.event.ActionEvent evt) {
      try{
        int resultado= _juego.jugar();
        dadoLabel.setIcon(new ImageIcon(_ruta+"dado"+resultado+".png"));
        if(resultado!=1){
          puntajeTemporalTextField.setText(Integer.toString(_juego.getPuntajeTmp()));
        }
        else{
          puntajeTemporalTextField.setText("0");
          nubeLabel.setIcon(new ImageIcon(_ruta+"nubeturnopc.png"));
          _juego.cambiarTurno();
          jugarButton.setEnabled(false);
          cambiarTurnoButton.setEnabled(false);
          continuarButton.setEnabled(true);
          turnoLabel.setText("Turno PC");
        }
      }
      catch(Exception e){
      }
    }//Fin jugarButtonActionPerformed

    //Cambia el turno del jugador humano a la PC
    private void cambiarTurnoButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
      try{
       boolean victoria;
       _juego.cambiarTurno();
       puntaje1TextField.setText(Integer.toString(_juego.getPuntaje1()));
       victoria= _juego.verificarVictoria(_juego.getPuntaje1());
       if(victoria){
        nubeLabel.setIcon(new ImageIcon(_ruta+"nubeganar.png"));
        jugarButton.setEnabled(false);
        cambiarTurnoButton.setEnabled(false);
        continuarButton.setEnabled(false);
       }
       else{
        nubeLabel.setIcon(new ImageIcon(_ruta+"nubeturnopc.png"));
        jugarButton.setEnabled(false);
        cambiarTurnoButton.setEnabled(false);
        continuarButton.setEnabled(true);
        turnoLabel.setText("Turno PC");
       } 
       puntajeTemporalTextField.setText("0");
      }
      catch(Exception e){
      }
    } 

    //Provoca que vuelva a empezar el juego
    private void reiniciarButtonActionPerformed(java.awt.event.ActionEvent evt) {
      try{
        jugarButton.setEnabled(true);
        cambiarTurnoButton.setEnabled(true);
        continuarButton.setEnabled(false);
        _juego.reiniciarJuego();
        puntaje1TextField.setText("0");
        puntaje2TextField.setText("0");
        puntajeTemporalTextField.setText("0");
        nubeLabel.setIcon(new ImageIcon(_ruta+"nubeinicio.png"));
      }
      catch(Exception e){
      }
    } 

    private void continuarButtonActionPerformed(java.awt.event.ActionEvent evt) {
      try{
        juegaPC();
      }
      catch(Exception e){
      }
      
    } 
    /*Fin de seccion de los metodos de los botones
     */ 
    
    //Main del programa
    public static void main(String args[]) {
      try {
        Principal pantalla;
        pantalla = new Principal();
        pantalla.mostrarPantalla();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }//Fin main
    
    
    // Declaracien de variables de GUI                    
    private JFrame ventana;
    private JLabel turnoLabel;
    private JLabel dadoLabel;
    private JLabel cerdoLabel;
    private JLabel nubeLabel;
    private JLabel puntaje1Label;
    private JLabel puntaje2Label;
    private JButton jugarButton;
    private JButton cambiarTurnoButton;
    private JButton reiniciarButton;
    private JButton continuarButton;
    private JTextField puntaje1TextField;
    private JTextField puntaje2TextField;
    private JTextField puntajeTemporalTextField;
    // Fin variables de GUI             
}//Fin Clase Principal