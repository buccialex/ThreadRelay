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
    
    private boolean preso = false;
    private Corridore c;
    
    public Testimone(){
        c = new Corridore();
    }
    
    public synchronized void corsa(){
        while(!preso){
            try {
                c.wait();
            } catch (InterruptedException ex) {
                
            }
        }
        c.notify();
    }

    public boolean isPreso() {
        return preso;
    }

    public void setPreso(boolean preso) {
        this.preso = preso;
    }
    
    
    
}
