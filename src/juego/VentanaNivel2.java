package juego;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class VentanaNivel2 extends JFrame {

    public JPanel panelP, panelP1, cubo, obstaculo1, obstaculo2, obstaculo3, obstaculo4, obstaculo5, obstaculo6, obstaculo7, obstaculo8;
    // Paneles que representan las monedas de oro coleccionables
    public JPanel moneda1, moneda2, moneda3, moneda4;
    public JButton iniciar;
    public JLabel etiquetaScore;

    public VentanaNivel2() {
        this.setLayout(null);
        this.setTitle("Nivel 2");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciar();
    }

    public void iniciar() {
        Control control = new Control();//crep el objeto control patra modificar valores de x,y
        control.setX(200);//asignamos valores a X
        control.setY(350);//y a Y

        etiquetaScore = new JLabel("Puntos: 0");
        etiquetaScore.setBounds(50, 10, 300, 35);
        etiquetaScore.setFont(new Font("Arial", Font.BOLD, 26));
        etiquetaScore.setForeground(Color.BLACK);
        this.add(etiquetaScore);//Agregamos el lugar donde mostraremos el progreso

        cubo = new JPanel();
        cubo.setLayout(null);
        cubo.setBackground(Color.GREEN);
        cubo.setBounds(control.getX(), control.getY(), 50, 50);
        this.add(cubo);

        iniciar = new JButton("Iniciar Nivel");
        iniciar.setBounds(300, 300, 400, 80);
        iniciar.setFont(new Font("Arial", Font.BOLD, 40));
        this.add(iniciar);//boton para iniciar el nivel

        panelP = new JPanel();
        panelP.setLayout(null);
        panelP.setBackground(Color.orange);
        panelP.setBounds(0, 50, 1000, 700);
        this.add(panelP);

        panelP1 = new JPanel();
        panelP1.setLayout(null);
        panelP1.setBackground(Color.ORANGE);
        panelP1.setBounds(1000, 50, 1000, 700);
        this.add(panelP1);

        obstaculo1 = new JPanel();
        obstaculo1.setBackground(Color.RED);
        obstaculo1.setBounds(200, 0, 100, 220);
        panelP.add(obstaculo1);

        obstaculo2 = new JPanel();
        obstaculo2.setBackground(Color.RED);
        obstaculo2.setBounds(200, 400, 100, 300);
        panelP.add(obstaculo2);

        // Moneda 1: Centrada en el hueco entre obstaculo1 y obstaculo2 (Y: 220 a 400)
        moneda1 = new JPanel();
        moneda1.setBackground(Color.YELLOW);
        moneda1.setBounds(100, 595, 30, 30);
        panelP.add(moneda1);

        obstaculo3 = new JPanel();
        obstaculo3.setBackground(Color.RED);
        obstaculo3.setBounds(700, 0, 100, 300);
        panelP.add(obstaculo3);

        obstaculo4 = new JPanel();
        obstaculo4.setBackground(Color.RED);
        obstaculo4.setBounds(700, 480, 100, 220);
        panelP.add(obstaculo4);

        // Moneda 2: Centrada en el hueco entre obstaculo3 y obstaculo4 (Y: 300 a 480)
        moneda2 = new JPanel();
        moneda2.setBackground(Color.YELLOW);
        moneda2.setBounds(535, 175, 30, 30);
        panelP.add(moneda2);

        obstaculo5 = new JPanel();
        obstaculo5.setBackground(Color.MAGENTA);
        obstaculo5.setBounds(200, 0, 100, 180);
        panelP1.add(obstaculo5);

        obstaculo6 = new JPanel();
        obstaculo6.setBackground(Color.MAGENTA);
        obstaculo6.setBounds(200, 360, 100, 340);
        panelP1.add(obstaculo6);

        // Moneda 3: Centrada en el hueco entre obstaculo5 y obstaculo6 (Y: 180 a 360)
        moneda3 = new JPanel();
        moneda3.setBackground(Color.YELLOW);
        moneda3.setBounds(135, 595, 30, 30);
        panelP1.add(moneda3);

        obstaculo7 = new JPanel();
        obstaculo7.setBackground(Color.MAGENTA);
        obstaculo7.setBounds(700, 0, 100, 260);
        panelP1.add(obstaculo7);

        obstaculo8 = new JPanel();
        obstaculo8.setBackground(Color.MAGENTA);
        obstaculo8.setBounds(700, 440, 100, 260);
        panelP1.add(obstaculo8);

        // Moneda 4: Centrada en el hueco entre obstaculo7 y obstaculo8 (Y: 260 a 440)
        moneda4 = new JPanel();
        moneda4.setBackground(Color.YELLOW);
        moneda4.setBounds(605, 135, 30, 30);
        panelP1.add(moneda4);

        EventoBucle2 oyente = new EventoBucle2(this, control);
        iniciar.addMouseListener(oyente);//vamos a hacer un evento con el boton

        this.addKeyListener(new EventosTeclado(cubo, control));
        this.setFocusable(true);// evento con las teclas
    }
}