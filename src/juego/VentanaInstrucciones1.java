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
public class VentanaInstrucciones1 extends JFrame {

    JPanel panelP, panelP1, cubo;
    JButton instrucciones;
    JLabel texto1,texto2,texto3,texto4,texto5;

    public JButton getInstrucciones() {
        return instrucciones;
    }

    public VentanaInstrucciones1() {
        this.setLayout(null);
        this.setTitle("Nivel 1");
        this.setSize(1100, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciar();

    }

    public void iniciar() {
        Control control = new Control();

        panelP = new JPanel();
        panelP.setLayout(null);
        panelP.setBackground(Color.blue);
        panelP.setBounds(50, 50, 1000, 700);
        this.add(panelP);
        texto1 = new JLabel("Instrucciones");
        texto1.setBounds(0,0,300,30);
        texto1.setFont(new Font("Arial",Font.BOLD, 30));
        panelP.add(texto1);
                
        texto2 = new JLabel("Tienes que esquivar los pilares");
        texto2.setBounds(0,30,600,30);
        texto2.setFont(new Font("Arial",Font.BOLD, 30));
        panelP.add(texto2);
        
        texto3 = new JLabel("Evita quedarte atras ya que si sales de la pantalla por el lado izquierdo perderas");
        texto3.setBounds(0,60,1500,30);
        texto3.setFont(new Font("Arial",Font.BOLD, 30));
        panelP.add(texto3);
        
        texto4 = new JLabel("Tienes que esquivar los pilares");
        texto4.setBounds(0,90,600,30);
        texto4.setFont(new Font("Arial",Font.BOLD, 30));
        panelP.add(texto4);
        
        texto5 = new JLabel("Muevete con las flechas de tu teclado");
        texto5.setBounds(0,120,600,30);
        texto5.setFont(new Font("Arial",Font.BOLD, 30));
        panelP.add(texto5);
        
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
