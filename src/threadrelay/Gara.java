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

    /**
     * attributi
     * testimone = monitor
     * c1,c2... = i vari thread
     */
    
    private Testimone testimone;
    private Corridore c1, c2, c3, c4;

    /**
     * costruttore di gare
     * @param velocita velocità dei vari corridori
     */
    public Gara(int velocita) {
        testimone = new Testimone();
        c1 = new Corridore(1, testimone, velocita);
        c2 = new Corridore(2, testimone, velocita);
        c3 = new Corridore(3, testimone, velocita);
        c4 = new Corridore(4, testimone, velocita);
    }

    /**
     * metodo per avviare la gara
     */
    public void avvia() {
        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
        new Thread(c4).start();
    }

    /**
     * metodo per sospendere la gara
     */
    public void sospendi() {
        testimone.sospendi();
    }

    /**
     * metodo per riprendere la gara
     */
    public void riprendi() {
        testimone.riprendi();
    }

    /**
     * metodo per fermare la gara
     */
    public void ferma() {
        testimone.ferma();
    }

    /**
     * getter del corridore 1
     * @return corridore 1
     */
    public Corridore getC1() {
        return c1;
    }

    /**
     * getter del corridore 2
     * @return corridore 2
     */
    public Corridore getC2() {
        return c2;
    }

    /**
     * getter del corridore 3
     * @return corridore 3
     */
    public Corridore getC3() {
        return c3;
    }

    /**
     * getter del corridore 4
     * @return corridore 4
     */
    public Corridore getC4() {
        return c4;
    }
    
    
}
