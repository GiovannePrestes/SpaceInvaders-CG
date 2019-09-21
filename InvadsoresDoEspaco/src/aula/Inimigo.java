package aula;

import java.awt.Color;
import java.awt.Graphics;
/*
 * Bola.java
 *
 * Created on 25 de Mar�o de 2008, 21:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author glauco
 */
public class Inimigo extends Elemento {
    
     public Inimigo(Color color)
     {
        setColor(color);
     }
         
     @Override
     public void desenhar(Graphics g)
     {
         g.setColor(getColor());
         g.fillOval(getX(),getY(),getLargura(),getAltura());
    }
   
}
