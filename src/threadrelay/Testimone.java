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

    /**
     * attributi:
     * corrente = numero del corridore che sta correndo (istanziato a 1 perché parte il primo)
     * sospeso = variabile che tiene conto se la gara è sospesa
     * fermato = variabile che tiene conto se la gara è stata fermata
     */
    private int corrente = 1;
    private boolean sospeso = false;
    private boolean fermato = false;

    /**
     * costruttore di testimone
     */
    public Testimone() {

    }

    /**
     * metodo che fa partire la corsa
     * @param numero numero del corridore che deve correre
     */
    public synchronized void parti(int numero) {
        // fa aspettare se non è il suo turno di correre
        while (corrente != numero || sospeso || fermato) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }

    /**
     * metodo che fa partire il corridore successivo
     * @param successivo numero del corridore successivo
     */
    public synchronized void passaTestimone(int successivo) {
        corrente = successivo;
        notifyAll();
    }

    /**
     * metodo che fa attentendere i thread se la gara è sospesa
     */
    public synchronized void aspettaSeSospeso() {
        while (sospeso) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * metodo per sospendere la gara
     */
    public synchronized void sospendi() {
        sospeso = true;
    }

    /**
     * metodo per riprendere la gara
     */
    public synchronized void riprendi() {
        sospeso = false;
        notifyAll();
    }

    /**
     * metodo per fermare la gara
     */
    public synchronized void ferma() {
        fermato = true;
        sospeso = false;
        notifyAll(); 
    }

    /**
     * getter dello stato della gara (se è ferma o no)
     * @return la variabile che controlla se è fermato
     */
    public boolean isFermato() {
        return fermato;
    }

}
