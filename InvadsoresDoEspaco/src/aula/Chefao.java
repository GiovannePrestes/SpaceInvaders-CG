/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;

import java.awt.Graphics;

/**
 *
 * @author Giovanne Prestes
 */
public class Chefao extends Elemento {

    private int vida = 10;
    @Override
    public void desenhar(Graphics g) {
         g.setColor(getColor());
         g.fillOval(getX(),getY(),getLargura(),getAltura());
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    
}
