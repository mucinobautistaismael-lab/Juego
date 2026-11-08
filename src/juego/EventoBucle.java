package juego;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class EventoBucle implements MouseListener, ActionListener {

    private int velocidad = -3;//la velocidadcon la que se mueve el fondo
    private Control control;//posision del jugador
    private VentanaNivel1 ventana;//referencia grafica
    
    private int xPanelP = 0;//valor que va a tener en el eje x
    private int xPanelP1 = 1000;//valor en eje x del panelP1
    private Timer timer;//cada cuanto se actualisa el juego

    private int score = 0;//contador en 0
    private boolean pasadoPar1 = false;//Evitan sumar de mas 
    private boolean pasadoPar2 = false;
    private boolean pasadoPar3 = false;
    private boolean pasadoPar4 = false;

    public EventoBucle(VentanaNivel1 ventana, Control control) {
        this.ventana = ventana;
        this.control = control;
        this.timer = new Timer(30, this);
    }//Inicialisa las instansias de la ventana y el contador
    //configura a 30milisegundos cada cuando se activa el metodo

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
            VentanaNivel1 nuevoNivel = new VentanaNivel1();
            nuevoNivel.setLocationRelativeTo(null);
            nuevoNivel.setVisible(true);
        }//repite y abre de nuevo el nivel 1
        else if (seleccion == 1) {
            VentanaInicio ventana = new VentanaInicio();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
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

        if (xPanelP <= -1000) {//cuando el panel sale por completo lo mandada despues del otro panel
            xPanelP = xPanelP1 + 1000;
            pasadoPar1 = false;
            pasadoPar2 = false;
        }

        if (xPanelP1 <= -1000) {
            xPanelP1 = xPanelP + 1000;
            pasadoPar3 = false;
            pasadoPar4 = false;
        }

        ventana.panelP.setBounds(xPanelP, 50, 1000, 700);
        ventana.panelP1.setBounds(xPanelP1, 50, 1000, 700);//panel en movimiento

        control.setX(control.getX() + velocidad); //mueve al cubo de forma horizontal
        ventana.cubo.setLocation(control.getX(), control.getY());//actualiza su posision

        boolean choco = colision(ventana.obstaculo1, xPanelP)
                || colision(ventana.obstaculo2, xPanelP)
                || colision(ventana.obstaculo3, xPanelP)
                || colision(ventana.obstaculo4, xPanelP)
                || colision(ventana.obstaculo5, xPanelP1)
                || colision(ventana.obstaculo6, xPanelP1)
                || colision(ventana.obstaculo7, xPanelP1)
                || colision(ventana.obstaculo8, xPanelP1);//se evaluan las posibles colisiones

        if (choco) {
            perder("¡Has perdido! Chocaste con un obstáculo.");
            return;
        }

        if (control.getX() + ventana.cubo.getWidth() <= 0) {
            perder("¡Has perdido! Te saliste de la pantalla.");
            return;
        }

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