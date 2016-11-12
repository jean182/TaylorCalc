/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taylorcalculator;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jeanaguilar
 */
public class Actions {

    public void sinRules() {
        JOptionPane.showMessageDialog(null, "Introduzca el valor del ángulo. "
                + "\nEl valor tiene que ser en grados.", "Instrucciones:", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/images/help.png")));

    }

    public void aboutDeveloper() {

        JOptionPane.showMessageDialog(null, "Calculadora de seno v1.0 \nEste programa fue desarollado por: \nJean Aguilar ", "Acerca de: ", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/images/info.png")));

    }

    public void exitProgram() {
        int confirmDialog = JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "Salida", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/images/exit.png")));
        if (confirmDialog == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }

}
