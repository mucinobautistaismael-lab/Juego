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
public class VentanaInicio extends JFrame {

    JPanel panelP;//Se declara el panel donde mostraremos las opsiones
    JButton nivel1, nivel2, nivel3;//Cramos los botones que nos dirijiran a los niveles
    JLabel titulo1;// El titulo que tendra como encabezado la pantalla

    public JButton getNivel1() {
        return nivel1;
    }

    public void setNivel1(JButton nivel1) {
        this.nivel1 = nivel1;
    }

    public JButton getNivel2() {
        return nivel2;
    }

    public void setNivel2(JButton nivel2) {
        this.nivel2 = nivel2;
    }

    public JButton getNivel3() {
        return nivel3;
    }

    public void setNivel3(JButton nivel3) {
        this.nivel3 = nivel3;
    }

    //Metodos que se usan para ejetucar los botones de manera mas sensilla en otras clases y saber si han sido pulsados

    public VentanaInicio() {
        this.setLayout(null);
        this.setTitle("ventana de Inicio");
        this.setSize(1500, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciar();
        //Crea la ventana donde estaran los paneles

    }

    public void iniciar() {

        panelP = new JPanel();
        panelP.setLayout(null);
        panelP.setBackground(Color.blue);
        panelP.setBounds(50, 50, 1400, 700);
        this.add(panelP);//Panel donde se muestras las obciones

        titulo1 = new JLabel("Nombre del Juego");
        titulo1.setBounds(440, 0, 600, 100);
        titulo1.setFont(new Font("Arial", Font.BOLD, 60));
        panelP.add(titulo1);//Encabesado

        nivel1 = new JButton("Nivel 1");
        nivel1.setBounds(400, 200, 600, 100);
        nivel1.setFont(new Font("Arial", Font.BOLD, 60));
        panelP.add(nivel1);// Boton para dirigirse al nivel 1 

        nivel2 = new JButton("Nivel 2");
        nivel2.setBounds(350, 350, 700, 100);
        nivel2.setFont(new Font("Arial", Font.BOLD, 60));
        panelP.add(nivel2);//Boton para dirigirse al nivel 2

        nivel3 = new JButton("Nivel 3");
        nivel3.setBounds(300, 500, 800, 100);
        nivel3.setFont(new Font("Arial", Font.BOLD, 60));
        panelP.add(nivel3);//Boton para dirijirse al nivel 3
        
       EventosMouse oyente = new EventosMouse(this);

        nivel1.addMouseListener(oyente);
        nivel2.addMouseListener(oyente);
        nivel3.addMouseListener(oyente);
        // es para avisar al objeto oyente que se esta pulsando o activando un evento de tipo mouse

    }
}
