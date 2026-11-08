/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Ismael Muciño
 */
public class VentanaInstrucciones3 extends JFrame {

    JPanel panelP, panelP1, cubo;
    JButton instrucciones;

    public JButton getInstrucciones() {
        return instrucciones;
    }

    public VentanaInstrucciones3() {
        this.setLayout(null);
        this.setTitle("Nivel 1");
        this.setSize(1500, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciar();

    }

    public void iniciar() {
        Control control = new Control();

        panelP = new JPanel();
        panelP.setLayout(null);
        panelP.setBackground(Color.RED);
        panelP.setBounds(50, 50, 1500, 700);
        this.add(panelP);
        // panelP1 = new JPanel();
        //panelP1.setLayout(null);
        //panelP1.setBackground(Color.blue);
        //panelP1.setBounds(50, 50, 1400, 700);
        //panelP.add(panelP1);

        instrucciones = new JButton("Continuar");
        instrucciones.setBounds(650, 640, 200, 70);
        instrucciones.setFont(new Font("Arial", Font.BOLD, 30));
        panelP.add(instrucciones);

        cubo = new JPanel();
        cubo.setLayout(null);
        cubo.setBackground(Color.GREEN);
        cubo.setBounds(control.getX(), control.getY(), 50, 50);
        panelP.add(cubo);
        
        EventosMouse oyente = new EventosMouse(this);
        instrucciones.addMouseListener(oyente);
        this.addKeyListener(new EventosTeclado(cubo, control));
        this.setFocusable(true);

    }

}
