package juego;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class EventoBucle2 implements MouseListener, ActionListener {

    private int velocidad = -3;//la velocidadcon la que se mueve el fondo
    private Control control;//posision del jugador
    private VentanaNivel2 ventana;//referencia grafica
    
    private int xPanelP = 0;//valor que va a tener en el eje x
    private int xPanelP1 = 1000;//valor en eje x del panelP1
    private Timer timer;//cada cuanto se actualisa el juego

    private int score = 0;//contador en 0
    private boolean pasadoPar1 = false;//Evitan sumar de mas 
    private boolean pasadoPar2 = false;
    private boolean pasadoPar3 = false;
    private boolean pasadoPar4 = false;

    public EventoBucle2(VentanaNivel2 ventana, Control control) {
        this.ventana = ventana;
        this.control = control;
        this.timer = new Timer(25, this);
    }//Inicialisa las instansias de la ventana y el contador
    //configura a 25milisegundos cada cuando se activa el metodo

    @Override
    public void mouseClicked(MouseEvent e) {
        ventana.iniciar.setVisible(false);
        ventana.requestFocusInWindow();//reactiva el foco del teclado para que funcione sin retrasos
        timer.start();//inicia el bucle
    }//quita el boton de inicio

    private boolean colision(JPanel obstaculo, int xPanel) {
        Rectangle rCubo = new Rectangle(control.getX(), control.getY(), ventana.cubo.getWidth(), ventana.cubo.getHeight());//Rectangle Aplica deteccionde colisiones AABB(Axis-Aligned Bounding Box)
        Rectangle rObstaculo = new Rectangle(xPanel + obstaculo.getX(), obstaculo.getY() + 50, obstaculo.getWidth(), obstaculo.getHeight());//genera un area alrededor del cubo que posterior mente se calcule cuando susede la colision
        //calcula la posision del obstaculo
        return rCubo.intersects(rObstaculo);//evalua si las dos figuras se tocan
    }
    // Metodo para revisar si el cubo agarra una moneda
    private void verificarMoneda(JPanel moneda, int xPanel) {
        if (moneda.isVisible()) {
            Rectangle rCubo = new Rectangle(control.getX(), control.getY(), ventana.cubo.getWidth(), ventana.cubo.getHeight());
            Rectangle rMoneda = new Rectangle(xPanel + moneda.getX(), moneda.getY() + 50, moneda.getWidth(), moneda.getHeight());

            if (rCubo.intersects(rMoneda)) {
                moneda.setVisible(false); // Desaparece la moneda al tocarla
                score += 5; // Otorga 5 puntos extra por moneda
                ventana.etiquetaScore.setText("Puntos: " + score);
            }
        }
    }
    

    private void perder(String motivo) {
        timer.stop();//detiene todo lo que esta en la ventana
        
        // Arreglo con las opciones que tendra el cuadro de dialogo
        Object[] opciones = {"Repetir nivel", "Menú principal", "Salir"};

        // Cuadro de dialogo personalizado con los 3 botones (devuelve 0, 1 o 2)
        int seleccion = JOptionPane.showOptionDialog(
                ventana,
                motivo + "\nPuntaje final: " + score + "\n¿Qué deseas hacer?",
                "Fin del juego",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        ventana.dispose();//cierra la ventana

        if (seleccion == 0) {
            VentanaNivel2 nuevoNivel = new VentanaNivel2();
            nuevoNivel.setLocationRelativeTo(null);
            nuevoNivel.setVisible(true);
        }//repite y abre de nuevo el nivel 2
        else if (seleccion == 1) {
            VentanaInicio menu = new VentanaInicio();
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);
        }//regresa y abre la ventana del menu inicial
        else {
            System.exit(0);
        }//cierra el juego por completo
    }

    private void verificarPuntos() {
        int centroCubo = control.getX() + (ventana.cubo.getWidth() / 2);//el centro del cubo para comparar cordenadas y saber cuando ya paso por la columna

        int posColumna1 = xPanelP + ventana.obstaculo1.getX() + ventana.obstaculo1.getWidth();//se dice donde estael extremo derecho de la columna, es la posision
        if (!pasadoPar1 && centroCubo > posColumna1 && posColumna1 > 0) {//revisa que este pasando el cubo y sisi agrega un punto al score
            score++;
            pasadoPar1 = true;
            ventana.etiquetaScore.setText("Puntos: " + score);
        }

        int posColumna2 = xPanelP + ventana.obstaculo3.getX() + ventana.obstaculo3.getWidth();//se dice donde estael extremo derecho de la columna, es la posision
        if (!pasadoPar2 && centroCubo > posColumna2 && posColumna2 > 0) {
            score++;
            pasadoPar2 = true;
            ventana.etiquetaScore.setText("Puntos: " + score);
        }

        int posColumna3 = xPanelP1 + ventana.obstaculo5.getX() + ventana.obstaculo5.getWidth();//se dice donde estael extremo derecho de la columna, es la posision
        if (!pasadoPar3 && centroCubo > posColumna3 && posColumna3 > 0) {
            score++;
            pasadoPar3 = true;
            ventana.etiquetaScore.setText("Puntos: " + score);
        }

        int posColumna4 = xPanelP1 + ventana.obstaculo7.getX() + ventana.obstaculo7.getWidth();//se dice donde estael extremo derecho de la columna, es la posision
        if (!pasadoPar4 && centroCubo > posColumna4 && posColumna4 > 0) {
            score++;
            pasadoPar4 = true;
            ventana.etiquetaScore.setText("Puntos: " + score);
        }
    }

    @Override
   
    public void actionPerformed(ActionEvent e) {
        xPanelP = xPanelP + velocidad;
        xPanelP1 = xPanelP1 + velocidad;

        
        if (xPanelP <= -1000) {
            xPanelP = xPanelP1 + 1000;
            pasadoPar1 = false;
            pasadoPar2 = false;
            ventana.moneda1.setVisible(true); // Hace visible la moneda 1 de nuevo
            ventana.moneda2.setVisible(true); // Hace visible la moneda 2 de nuevo
        }

        if (xPanelP1 <= -1000) {
            xPanelP1 = xPanelP + 1000;
            pasadoPar3 = false;
            pasadoPar4 = false;
            ventana.moneda3.setVisible(true); // Hace visible la moneda 3 de nuevo
            ventana.moneda4.setVisible(true); // Hace visible la moneda 4 de nuevo
        }


        ventana.panelP.setBounds(xPanelP, 50, 1000, 700);
        ventana.panelP1.setBounds(xPanelP1, 50, 1000, 700);

        control.setX(control.getX() + velocidad);
        ventana.cubo.setLocation(control.getX(), control.getY());

        boolean choco = colision(ventana.obstaculo1, xPanelP)
                || colision(ventana.obstaculo2, xPanelP)
                || colision(ventana.obstaculo3, xPanelP)
                || colision(ventana.obstaculo4, xPanelP)
                || colision(ventana.obstaculo5, xPanelP1)
                || colision(ventana.obstaculo6, xPanelP1)
                || colision(ventana.obstaculo7, xPanelP1)
                || colision(ventana.obstaculo8, xPanelP1);

        if (choco) {
            perder("¡Has perdido! Chocaste con un obstáculo.");
            return;
        }

        if (control.getX() + ventana.cubo.getWidth() <= 0) {
            perder("¡Has perdido! Te saliste de la pantalla.");
            return;
        }

        // Llamadas de recolección de monedas
        verificarMoneda(ventana.moneda1, xPanelP);
        verificarMoneda(ventana.moneda2, xPanelP);
        verificarMoneda(ventana.moneda3, xPanelP1);
        verificarMoneda(ventana.moneda4, xPanelP1);

        verificarPuntos();
        ventana.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}