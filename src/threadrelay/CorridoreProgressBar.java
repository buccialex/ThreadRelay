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

    private String emoji;

    public CorridoreProgressBar(String emoji) {
        this.emoji = emoji;
        setMaximum(100);
        setMinimum(0);
    }

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

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
