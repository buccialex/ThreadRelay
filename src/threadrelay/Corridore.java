/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author Bux
 */
public class Corridore implements Runnable {

    private int numero;
    private int stato = 0;
    private Testimone t;
    private int velocita;

    public Corridore(int numero, Testimone testimone, int velocita) {
        this.numero = numero;
        t = testimone;
        this.velocita = velocita;
    }

    @Override
    public void run() {
        t.parti(numero); 

        while (stato < 100 && !t.isFermato()) {
            
            t.aspettaSeSospeso();
            stato++;

            if (stato == 90 && numero < 4) {
                t.passaTestimone(numero + 1); 
            }

            try {
                Thread.sleep(velocita);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            
        }

    }

    public int getStato() {
        return stato;
    }

    public int getVelocita() {
        return velocita;
    }
    
    

}
