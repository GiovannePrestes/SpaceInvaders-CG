package aula;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
/*
 * FrmJogo.java
 *
 * Created on 7 de Mar�o de 2007, 19:52
 */

/**
 *
 * @author  Glauco
 */
public class FrmJogo extends javax.swing.JFrame implements Runnable {
    
    
    
    /** Controle do teclado */
    private boolean esquerdaPressed    = false;
    private boolean direitaPressed     = false;
    private boolean tiro               = false;
    
    
    private ArrayList <Elemento> elementos = new ArrayList <Elemento>();
    private ArrayList<Inimigo> inimigo = new ArrayList<Inimigo>();
    private Chefao chefao = new Chefao();
    private Nave nave;
    
    
    /** Creates new form FrmJogo */
    public FrmJogo() {
        
        initComponents();
        this.setSize(800,600);
        createBufferStrategy(2);
        
              
        for(int i = 0; i<4; i++){
            for(int j = 0; j<5; j++){
            inimigo.add(new Inimigo(Color.BLACK));
            inimigo.get(i*4+j).setX((getWidth()/5)*j + 50);
            inimigo.get(i*4+j).setY(-10-i*100);
            }
        }
        
        
        nave = new Nave();
        nave.setColor(Color.MAGENTA);
        nave.setLargura(120);
        nave.setAltura(40);
        nave.setX(200);
        nave.setY(getHeight()-nave.getAltura());
        nave.setIncX(0);
        nave.setIncY(0);
        
        elementos.addAll(inimigo);
        elementos.add(nave);
        
        
        
        
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
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            tiro             = false;
        } 
        
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            esquerdaPressed = false;
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            direitaPressed = false;
        }
        
        
        
    }//GEN-LAST:event_formKeyReleased
        
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            esquerdaPressed = true;
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            direitaPressed = true;
        }
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            tiro             = true;
        } 
    }//GEN-LAST:event_formKeyPressed
        
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
        
        long ultimoTiro  = System.currentTimeMillis();
        long tiroCorrente= 0;
   
        while(true) {
            
            Graphics g = getBufferStrategy().getDrawGraphics();
            
            //Limpa a Tela
            g.setColor(Color.YELLOW);
            g.fillRect(0,0,this.getWidth(),this.getHeight());

            if(tiro)
            {
               tiroCorrente = System.currentTimeMillis(); 
               if(tiroCorrente > ultimoTiro+300) 
               {
                    ultimoTiro  = System.currentTimeMillis();
                    Tiro t = new Tiro(10,5);
                    t.setX(nave.getX()+nave.getLargura()/2);
                    t.setY(nave.getY()-t.getAltura() - 1);
                    t.setIncY(-1);
                    t.setIncX(0);
                    elementos.add(t);
               }
            }
            
            for(Elemento e: elementos) {
                e.desenhar(g);
            }
           
            for(Elemento e: elementos) {
                e.mover();
            }
        
            if(esquerdaPressed)
                nave.setIncX(-1);
            else
              if(direitaPressed)
                  nave.setIncX(1);
              else
                  nave.setIncX(0);
              
            for(Inimigo ini: inimigo){
                if(nave.colisao(ini))
                {
                  JOptionPane.showMessageDialog(this,
                          "GAME OVER!"
                          );
                    inimigo.clear();
                    for(int i = 0; i<4; i++){
                        for(int j = 0; j<5; j++){
                        inimigo.add(new Inimigo(Color.BLACK));
                        inimigo.get(i).setX((getWidth()/5)*j + 20);
                        inimigo.get(i).setY(-10-i*50);
                        }
                    }
                }
            }
            
//            for(Inimigo ini: inimigo){
//             
//                if(ini.getY() > getHeight())
//                {
//                      JOptionPane.showMessageDialog(this,
//                              "GAME OVER!"
//                              );
//                       inimigo.clear();
//                    for(int i = 0; i<4; i++){
//                        for(int j = 0; j<5; j++){
//                        inimigo.add(new Inimigo(Color.BLACK));
//                        inimigo.get(i).setX((getWidth()/5)*j + 20);
//                        inimigo.get(i).setY(-10-i*50);
//                        }
//                    }
//
//                }   
//            }
            
            
            
                //Verifica Colisao Bola com Campo
            for(Inimigo ini: inimigo){
                
                if(ini.getX() > this.getWidth()-ini.getLargura()) {
                        ini.setIncX(-1);
                }

                if(ini.getX() < 0) {
                        ini.setIncX(1);
                }

                if(ini.getY() < 0) {
                        ini.setIncY(1);
                }
            }

            g.dispose();
            getBufferStrategy().show();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            
        }
        
        
        
        
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    
    
}






















