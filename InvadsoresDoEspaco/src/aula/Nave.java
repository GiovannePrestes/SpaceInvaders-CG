package aula;


import java.awt.Graphics;

public class Nave extends Elemento
{

    @Override
    public void desenhar(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getLargura(), getAltura());
    }

}  
   