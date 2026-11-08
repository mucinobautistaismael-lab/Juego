/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Ismael Muciño
 */
public class EventosMouse implements MouseListener {

    private VentanaInicio ventana;
    private VentanaInstrucciones1 ventanaI1;
    private VentanaInstrucciones2 ventanaI2;
    private VentanaInstrucciones3 ventanaI3;
    //secrean los objetos ventanas para poder extraer infromacion de ellos 

    public EventosMouse(VentanaInicio ventana) {
        this.ventana = ventana;

    }

    public EventosMouse(VentanaInstrucciones1 ventanaI1) {
        this.ventanaI1 = ventanaI1;
    }

    public EventosMouse(VentanaInstrucciones2 ventanaI2) {
        this.ventanaI2 = ventanaI2;
    }

    public EventosMouse(VentanaInstrucciones3 ventanaI3) {
        this.ventanaI3 = ventanaI3;

    }

    @Override
    public void mouseClicked(MouseEvent e) {//es el metodo que detecta cuando se realizo un clik con el raton
        if (ventana != null) {//asegura que la ventana este relacionada que si se halla pulsado el boton 
            if ((e.getSource() == ventana.getNivel1())) {//comprueva que boton fue precionado
                VentanaInstrucciones1 ventanaIns = new VentanaInstrucciones1();
                ventanaIns.setVisible(true);
                ventanaIns.setLocationRelativeTo(null);//se crea el objeto ventapara que se muestre en pantalla
                ventana.dispose();//Cierra la ventana anterior bueno a la que se esta haciendo incambie "ventana"
            }

            if ((e.getSource() == ventana.getNivel2())) {//comprueva que boton fue precionado
                VentanaInstrucciones2 ventanaIns = new VentanaInstrucciones2();
                ventanaIns.setVisible(true);
                ventanaIns.setLocationRelativeTo(null);//se crea el objeto ventapara que se muestre en pantalla
                ventana.dispose();//Cierra la ventana anterior bueno a la que se esta haciendo incambie "ventana"

            }
            if ((e.getSource() == ventana.getNivel3())) {//comprueva que boton fue precionado
                VentanaInstrucciones3 ventanaIns = new VentanaInstrucciones3();
                ventanaIns.setVisible(true);
                ventanaIns.setLocationRelativeTo(null);//se crea el objeto ventapara que se muestre en pantalla
                ventana.dispose();//Cierra la ventana anterior bueno a la que se esta haciendo incambie "ventana"

            }

        }
        if (ventanaI1 != null) {//se asegura que se haya precionado un boton
            if (e.getSource() == ventanaI1.getInstrucciones()) {

                VentanaNivel1 ventanaNv1 = new VentanaNivel1();
                ventanaNv1.setLocationRelativeTo(null);
                ventanaNv1.setVisible(true);
                ventanaI1.dispose(); // Cierra las instrucciones
            }
        }
        if (ventanaI2 != null) {//se asegura que se haya precionado un boton
            if (e.getSource() == ventanaI2.getInstrucciones()) {
                VentanaNivel2 ventanaNv2 = new VentanaNivel2();
                ventanaNv2.setVisible(true);
                ventanaNv2.setLocationRelativeTo(null);
                ventanaI2.dispose();
            }
        }
        if (ventanaI3 != null) {//se asegura que se haya precionado un boton
            if (e.getSource() == ventanaI3.getInstrucciones()) {

                VentanaNivel3 ventanaNv3 = new VentanaNivel3();
                ventanaNv3.setVisible(true);
                ventanaNv3.setLocationRelativeTo(null);
                ventanaI3.dispose();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
