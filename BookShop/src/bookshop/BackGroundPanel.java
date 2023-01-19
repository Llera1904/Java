/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.Dimension;

/**
 *
 * @author Macario
 */
public class BackGroundPanel extends JPanel
{
    
    ImageIcon fondo;
    
    public BackGroundPanel(ImageIcon fondo)
    {
        super();
        this.fondo = fondo;
        repaint();
    }
    
    public void paintComponent(Graphics g)
    {
        Dimension dim = this.getSize();
        int ancho = (int) dim.getWidth();
        int alto  = (int) dim.getHeight();
        g.drawImage(fondo.getImage(), 0, 0, ancho, alto, null);
        setOpaque(false);
        super.paintComponent(g);
    }
    
}
