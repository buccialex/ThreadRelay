/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

import java.awt.*;

/**
 *
 * @author Bux
 */
public class CorridoreProgressBar extends javax.swing.JProgressBar{

    /**
     * attributi
     * emoji: stringa da utilizzare nella progressbar (in questo caso l'emoji del corridore)
     */
    private String emoji;

    /**
     * costruttore della progressbar
     * @param emoji stringa da utilizzare
     */
    public CorridoreProgressBar(String emoji) {
        this.emoji = emoji;
        setMaximum(100);
        setMinimum(0);
    }

    /**
     * override del metodo paintcomponent per modificare il modo in cui viene disegnata la progressbar
     * @param g componente grafico
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));

        // calcolo posizione X proporzionale al valore
        int x = (int) ((double) (getWidth() - 20) * getValue() / getMaximum());
        int y = getHeight() / 2 + 6;

        g2.drawString(emoji, x, y);
    }

    /**
     * getter della stringa
     * @return stringa
     */
    public String getEmoji() {
        return emoji;
    }

    /**
     * setter della stringa
     * @param emoji stringa da visualizzare
     */
    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
