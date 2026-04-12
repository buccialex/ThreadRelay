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
    private Testimone t = new Testimone();
    
    public Corridore() {
        
    }
    
    @Override
    public void run() {
        
        while (stato < 100) {
            
            t.parti(numero);
            while (stato < 99) {
                stato++;
                
                if (stato == 90 && numero < 4) {
                    t.passaTestimone(numero++);
                }
            }
            
        }
    }
    
}
