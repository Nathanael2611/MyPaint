package fr.nathanael2611.mypaint;

import javax.swing.*;
import java.awt.*;

public class ColoredRect extends JComponent {

    private Color color = Color.WHITE;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    public ColoredRect(Color color){
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g){
        MyPaint.fillColoredRect(g, this, color);
    }

}
