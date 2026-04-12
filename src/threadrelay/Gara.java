/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author Bux
 */
public class Gara {

    private Testimone testimone;
    private Corridore c1, c2, c3, c4;

    public Gara(int velocita) {
        testimone = new Testimone();
        c1 = new Corridore(1, testimone, velocita);
        c2 = new Corridore(2, testimone, velocita);
        c3 = new Corridore(3, testimone, velocita);
        c4 = new Corridore(4, testimone, velocita);
    }

    public void avvia() {
        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
        new Thread(c4).start();
    }

    public void sospendi() {
        testimone.sospendi();
    }

    public void riprendi() {
        testimone.riprendi();
    }

    public void ferma() {
        testimone.ferma();
    }

    public Corridore getC1() {
        return c1;
    }

    public Corridore getC2() {
        return c2;
    }

    public Corridore getC3() {
        return c3;
    }

    public Corridore getC4() {
        return c4;
    }
    
    
}
