/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Ismael Muciño
 */
public class EventosTeclado implements KeyListener {

    private JPanel cubo;
    private Control control;

    public EventosTeclado(JPanel cubo, Control control) {
        this.cubo = cubo;
        this.control = control;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) {//Verifica que la tecla correspondiente alla sido tocada
            if (control.getX() > 0) {//comprueva que el cubo este dentro del limite para podermoverlo
                control.setX(control.getX() - 10);//Aumenta las cordenas o las disminulle dependiendo lo que quieras que haga 
            }
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            if (control.getX() < 950) {
                control.setX(control.getX() + 10);
            }
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            if (control.getY() < 650) {
                control.setY(control.getY() + 10);

            }
        }
        if (keyCode == KeyEvent.VK_UP) {
            if (control.getY() > 0) {
                control.setY(control.getY() - 10);

            }
          
        }
          cubo.setBounds(control.getX(), control.getY(), 50, 50);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
