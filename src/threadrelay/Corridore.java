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

    /**
     * attributi:
     * numero = numero del corridore
     * stato = percentuale di avanzamento
     * t = Testimone (classe monitor)
     * velocita = velocità del corridore
     */
    private int numero;
    private int stato = 0;
    private Testimone t;
    private int velocita;

    /**
     * costruttore di corridori
     * @param numero numero del corridore
     * @param testimone monitor 
     * @param velocita velocità
     */
    public Corridore(int numero, Testimone testimone, int velocita) {
        this.numero = numero;
        t = testimone;
        this.velocita = velocita;
    }

    /**
     * override del metodo run del thread
     */
    @Override
    public void run() {
        t.parti(numero); 

        while (stato < 100 && !t.isFermato()) {
            
            t.aspettaSeSospeso();
            stato++;

            // fa partire il corridore successivo quando arriva a 90
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

    /**
     * getter dello stato
     * @return lo stato
     */
    public int getStato() {
        return stato;
    }

    /**
     * getter della velocità
     * @return velocita
     */
    public int getVelocita() {
        return velocita;
    }
    
    

}
