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
    private boolean sospeso = false;
    private boolean fermato = false;

    public Testimone() {

    }

    public synchronized void parti(int numero) {
        while (corrente != numero || sospeso || fermato) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }

    public synchronized void passaTestimone(int successivo) {
        corrente = successivo;
        notifyAll();
    }

    public synchronized void aspettaSeSospeso() {
        while (sospeso) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void sospendi() {
        sospeso = true;
    }

    public synchronized void riprendi() {
        sospeso = false;
        notifyAll();
    }

    public synchronized void ferma() {
        fermato = true;
        sospeso = false;
        notifyAll(); 
    }

    public boolean isFermato() {
        return fermato;
    }

}
