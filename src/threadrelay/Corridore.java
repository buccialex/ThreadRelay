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

    private int stato = 0;
    private Testimone t;

    public Corridore() {
        t = new Testimone();
    }

    @Override
    public void run() {
        t.setPreso(true);
        while (stato < 100) {
            if (stato == 90) {
                t.setPreso(false);
            }
        }
    }

    public int getStato() {
        return stato;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    public Testimone getT() {
        return t;
    }

    public void setT(Testimone t) {
        this.t = t;
    }
    
    

}
