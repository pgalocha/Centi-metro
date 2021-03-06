/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufp.inf.lp2.FiggeoDraw;

import edu.ufp.inf.lp2.Figgeo.Circulo;
import edu.ufp.inf.lp2.Figgeo.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author joaoalves
 */
public class DrawJPanel extends javax.swing.JPanel {
    private BagFigGeo bag = new BagFigGeo();
    
    
    /**
     * Creates new form DrawJPanel
     */
    public DrawJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 51, 51));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
               // TODO add your handling code here:
               java.awt.Point p = evt.getPoint();
               edu.ufp.inf.lp2.Figgeo.Point pointUp = new Point(p.x,p.y);
               //edu.ufp.inf.lp2.Figgeo.Point pointDown = new Point(p.x+30,p.y+10);
               System.out.println("px" + p.x + "| py "+p.y);
               //edu.ufp.inf.lp2.Figgeo.Rectangle rect = new Rectangle(pointUp, pointDown,Color.YELLOW);
               edu.ufp.inf.lp2.Figgeo.Circulo cir = new Circulo(pointUp, 10,Color.YELLOW);
               //this.bag.add((FigGeoDrawI)rect);
               this.bag.add((FigGeoDrawI)cir);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        int w=super.getWidth();
        int h= super.getHeight();
        
        
        Image offscreenImage = super.createImage(w,h);
        Graphics offscreenGraphics = offscreenImage.getGraphics();
        offscreenGraphics.setColor(super.getBackground());
        offscreenGraphics.fillRect(0, 0, w, h);
        
      
         bag.draw(offscreenGraphics);

        g.drawImage(offscreenImage, 0, 0, null);
                
        this.repaint();
   
    }
}
