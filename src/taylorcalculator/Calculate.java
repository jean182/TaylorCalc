/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taylorcalculator;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author jeanaguilar
 */
public class Calculate {

    DecimalFormat df = new DecimalFormat("0.0000000");

    public double getAngle() {

        double userRadian = Long.parseLong(JOptionPane.showInputDialog("Ingrese un ángulo en grados: "));

        return userRadian;

    }

    //Este método calcula el factorial del número ingresado 
    public double calculateFactorial(double userRadian) {
        /*
        El factorial se calcula utilizando un ciclo while. Lo que hace es que el valor de la variable es 1
        Esta se multiplica por el valor de los grados introducidos y estos se van restando hasta llegar a 1
        Ejemplo: si tenemos que la variable factorialNumber = 1 y que userRadian es = 4 el método hace lo siguiente
        (1*4*3*2*1) llegando a la conclusión que factorial de 4! =24
         */
        double factorialNumber = 1;

        while (userRadian != 0) {

            factorialNumber *= userRadian;
            userRadian--;

        }

        return factorialNumber;

    }

    public String printSin(double userRadian) {
        //Variable que concatena las operaciones que suceden en el ciclo
        String sinSeries = "sin(" + (int) userRadian + ")= " + "\n" + (int) userRadian + "";
        double sin = 0;
        //Variable que convierte grados a radianes.
        double rad = userRadian * 1. / 180. * Math.PI;
        /*
            El for realiza la formula para calcular el seno segun la serie de Taylor.
            En este caso se le pone un termino final a la serie ya que el ciclo debe terminar, no puede ser infinito
            Se hace un condicional el cual hace el cambio de signos acorde al termino si el termino i es par entonces:
             -Se hace una suma
            Si es impar
             -Se hace una resta   
         */
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                sin += Math.pow(rad, 2 * i + 1) / calculateFactorial(2 * i + 1);
                if (i == 0) {
                    sinSeries += " ";
                } else {
                    sinSeries += "+ (" + (int) userRadian + "^" + (2 * i + 1) + "/" + (2 * i + 1) + "!)" + "\n";
                }
            } else {
                sin -= Math.pow(rad, 2 * i + 1) / calculateFactorial(2 * i + 1);
                sinSeries += "- (" + (int) userRadian + "^" + (2 * i + 1) + "/" + (2 * i + 1) + "!)" + "\n";
            }

        }

        return sinSeries + "\nEl seno utilizando la serie de Taylor es: " + df.format(sin);
    }

    public String printCos(double userRadian) {
        String cosSeries = "cos(" + (int) userRadian + ")= " + "\n" + 1 + "";
        double cos = 0;
        double rad = userRadian * 1. / 180. * Math.PI;

        /*
        El for realiza la formula para calcular el cos donde (-1) se eleva a i el cual determinara el simbolo de
        la operación ya sea una suma (pares) o resta (impares)
         */
        for (int i = 0; i < 11; i++) {

            cos = cos + Math.pow(-1, i) * Math.pow(rad, 2 * i) / calculateFactorial(2 * i);
            if (i % 2 == 0) {
                if (i == 0) {
                    cosSeries += " ";
                } else {
                    cosSeries += "+ (" + (int) userRadian + "^" + 2 * i + "/" + 2 * i + "!)" + "\n";
                }

            } else {
                cosSeries += "- (" + (int) userRadian + "^" + 2 * i + "/" + 2 * i + "!)" + "\n";
            }

        }

        return cosSeries + "\nEl coseno utilizando la serie de Taylor es: " + df.format(cos);
    }
}
