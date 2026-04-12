/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author Bux
 */
public class Testimone {

    private int corrente = 1;

    public Testimone() {

    }

    public synchronized void parti(int numero) {
        while (corrente != numero) {
            try {
                wait();

            } catch (InterruptedException ex) {

            }
        }

    }

    public synchronized void passaTestimone(int successivo) {
        corrente = successivo;
        notifyAll();
    }

}
