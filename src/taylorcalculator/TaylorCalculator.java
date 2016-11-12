/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taylorcalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 *
 * @author jeanaguilar
 */
public class TaylorCalculator extends JFrame implements ActionListener {

    Image window = new Image();
    private JMenuBar menu;
    JMenu sinMenu, help;
    JMenuItem about, instructions;// Menu items variables for help
    JMenuItem exit;// Menu items variables for game
    JTextField sinText;
    JButton inputSin, inputCos;
    JLabel text;
    JLabel title;
    Calculate calculate = new Calculate();
    Actions action = new Actions();

    public static void main(String[] args) {
        // TODO code application logic here
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TaylorCalculator frame = new TaylorCalculator();
                    frame.setVisible(true);
                    frame.setTitle("Calculadora de Taylor");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TaylorCalculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        window.setBorder(new EmptyBorder(5, 5, 5, 5));
        window.setLayout(new BorderLayout(0, 0));
        window.setLayout(null);
        setContentPane(window);
        setResizable(false);
        window.add(menuGUI());
        window.add(sinTextField());
        window.add(getSin());
        window.add(getCos());
        window.add(textInfo());
        window.add(titleMain());
    }

    private JMenuBar menuGUI() {
        menu = new JMenuBar();
        menu.setBounds(0, 0, 800, 25);
        window.add(menu);
        sinMenu = new JMenu("Calculadora Seno");
        sinMenu.setFont(new Font("Roboto Condensed", Font.BOLD, 16));
        menu.add(sinMenu);
        help = new JMenu("Ayuda");
        help.setFont(new Font("Roboto Condensed", Font.BOLD, 16));
        menu.add(help);

        //Add help values
        about = new JMenuItem("Acerca de");
        about.setFont(new Font("Roboto", Font.PLAIN, 16));
        about.addActionListener(this);
        help.add(about);

        instructions = new JMenuItem("Instrucciones");
        instructions.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
        instructions.addActionListener(this);
        help.add(instructions);

        //Add sin values
        exit = new JMenuItem("Salir");
        exit.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
        exit.addActionListener(this);
        sinMenu.add(exit);

        return menu;

    }

    public JLabel titleMain() {
        //Add title
        title = new JLabel("Cálculo de Seno");
        title.setFont(new Font("Roboto Condensed", Font.BOLD, 50));
        title.setForeground(Color.white);
        title.setBounds(250, 5, 400, 200);
        title.setBorder(new EmptyBorder(5, 5, 5, 5));
        title.setLayout(new BorderLayout(0, 0));
        return title;
    }

    private JTextField sinTextField() {
        sinText = new JTextField();
        sinText.setBounds(275, 200, 280, 40);
        sinText.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));

        return sinText;
    }

    private JButton getSin() {
        inputSin = new JButton("Calcular seno");
        inputSin.setFont(new Font("Roboto Condensed", Font.BOLD, 16));
        inputSin.setBounds(275, 250, 120, 45);
        inputSin.addActionListener(this);

        return inputSin;
    }

    private JButton getCos() {
        inputCos = new JButton("Calcular coseno");
        inputCos.setFont(new Font("Roboto Condensed", Font.BOLD, 16));
        inputCos.setBounds(435, 250, 120, 45);
        inputCos.addActionListener(this);

        return inputCos;
    }

    private JLabel textInfo() {
        text = new JLabel("Ingrese el ángulo que desea calcular: ");
        text.setBounds(300, 150, 280, 40);
        text.setFont(new Font("Roboto Condensed", Font.ITALIC, 16));
        text.setForeground(Color.white);
        return text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(exit)) {
            action.exitProgram();

        }

        if (e.getSource().equals(about)) {
            action.aboutDeveloper();
        }

        if (e.getSource().equals(instructions)) {
            action.sinRules();
        }

        if (e.getSource() == inputSin) {

            try {
                double sinNumber = Double.parseDouble(sinText.getText());
                 
                JOptionPane.showMessageDialog(null, calculate.printSin(sinNumber), "Resultado", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/images/input.png")));

            } catch (NumberFormatException ex) {
                if (sinText.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número.", "ERROR", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/images/error.png")));
                } else {
                    JOptionPane.showMessageDialog(null, "El valor ingresado no es un número.", "ERROR", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/images/error.png")));
                }
            }

        }

        if (e.getSource().equals(inputCos)) {
            try {
                double cosNumber = Double.parseDouble(sinText.getText());
                JOptionPane.showMessageDialog(null, calculate.printCos(cosNumber), "Resultado", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/images/input.png")));

            } catch (NumberFormatException ex) {
                if (sinText.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número.", "ERROR", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/images/error.png")));
                } else {
                    JOptionPane.showMessageDialog(null, "El valor ingresado no es un número.", "ERROR", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/images/error.png")));
                }
            }
        }
    }

}
