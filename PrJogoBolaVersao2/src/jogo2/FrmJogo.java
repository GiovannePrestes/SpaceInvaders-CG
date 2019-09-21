/*
 * FrmJogo.java
 *
 * Created on 7 de Agosto de 2008, 09:51
 */
package jogo2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author  Jackson
 */
public class FrmJogo extends javax.swing.JFrame implements Runnable {

    /** Creates new form FrmJogo */
    public FrmJogo() {
        initComponents();

        createBufferStrategy(2);

        Thread t = new Thread(this);
        t.start();


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmJogo().setVisible(true);
            }
        });
    }

    public void run() {

        BufferStrategy buffer = getBufferStrategy();
        Graphics bg;
        
        ArrayList <Bola> bolas = new ArrayList<Bola>();

        int x,y;
        for(int i=0; i< 100; i++)
        {
          x = (int)(Math.random()*getWidth());
          y = (int)(Math.random()*getHeight());
          
          bolas.add(new Bola(Color.BLACK,x,y));
        }
        
        
        while (true) {
            
                bg = buffer.getDrawGraphics();

                bg.setColor(Color.GREEN);
                bg.fillRect(0, 0, getWidth(), getHeight());

                for(Bola b: bolas)
                {
                    b.mover();
                }
                
                for(Bola b: bolas)
                {
                    b.desenhar(bg);
                }
                
                for(Bola b: bolas)
                {
                    b.trataColisaoForm(getWidth(), getHeight());
                }
                
                bg.dispose();
                buffer.show();

                
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                
                }
            

        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
