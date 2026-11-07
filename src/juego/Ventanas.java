/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Ismael Muciño
 */
public class Ventanas extends JFrame {

    JPanel panelP;
    JButton nivel1, nivel2, nivel3;
    JLabel titulo1;

    public Ventanas() {
        this.setLayout(null);
        this.setTitle("ventana de Inicio");
        this.setSize(1500, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciar();

    }

    public void iniciar() {

        panelP = new JPanel();
        panelP.setLayout(null);
        panelP.setBackground(Color.blue);
        panelP.setBounds(50, 50, 1400, 700);
        this.add(panelP);

        titulo1 = new JLabel("Nombre del Juego");
        titulo1.setBounds(440, 0, 600, 100);
        titulo1.setFont(new Font("Arial", Font.BOLD, 60));
        panelP.add(titulo1);

        nivel1 = new JButton("Nivel 1");
        nivel1.setBounds(400, 200, 600, 100);
        nivel1.setFont(new Font("Arial", Font.BOLD, 60));
        panelP.add(nivel1);
        
        nivel2 = new JButton("Nivel 2");
        nivel2.setBounds(350, 350, 700, 100);
        nivel2.setFont(new Font("Arial", Font.BOLD, 60));
        panelP.add(nivel2);
        
        nivel3 = new JButton("Nivel 3");
        nivel3.setBounds(300, 500, 800, 100);
        nivel3.setFont(new Font("Arial", Font.BOLD, 60));
        panelP.add(nivel3);

    }
}
