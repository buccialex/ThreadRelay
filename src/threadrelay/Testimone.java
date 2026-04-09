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
    
    private boolean preso = true;
    
    
    public Testimone(){
        
    }
    
    public synchronized void corsa(Corridore c){
        while(preso){
            try {
                c.wait();
                
            } catch (InterruptedException ex) {
                
            }
        }
        preso = false;
        c.notify();
        
    }

    public boolean isPreso() {
        return preso;
    }

    public void setPreso(boolean preso) {
        this.preso = preso;
    }
    
    
    
}
