/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Glauco
 */
public class Bola {

    private Color cor = new Color(0, 255, 0);
    private int largura = 30;
    private int altura = 30;
    private int x = 0;
    private int y = 0;
    private int contX = 1;
    private int contY = 1;

    public Bola(Color cor, int x, int y) {
        setCor(cor);
        setX(x);
        setY(y);

    }

    /**
     * @return the cor
     */
    public Color getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(Color cor) {
        this.cor = cor;
    }

    /**
     * @return the largura
     */
    public int getLargura() {
        return largura;
    }

    /**
     * @param largura the largura to set
     */
    public void setLargura(int largura) {
        this.largura = largura;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the contX
     */
    public int getContX() {
        return contX;
    }

    /**
     * @param contX the contX to set
     */
    public void setContX(int contX) {
        this.contX = contX;
    }

    /**
     * @return the contY
     */
    public int getContY() {
        return contY;
    }

    /**
     * @param contY the contY to set
     */
    public void setContY(int contY) {
        this.contY = contY;
    }

    public void desenhar(Graphics bg) {

        bg.setColor(cor);
        bg.fillOval(x, y, largura, altura);
    }

    public void mover() {

        x = x + contX;
        y = y + contY;
    }

    public void trataColisaoForm(int width, int height) {

        if (y + altura> height) {
            contY = -1;
        }
        if (x + largura > width) {
            contX = -1;
        }

        if (y < 20) {
            contY = 1;
        }

        if (x < 0) {
            contX = 1;
        }

    }

}
