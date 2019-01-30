package fr.nathanael2611.mypaint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Pixel extends JComponent implements  MouseListener, MouseMotionListener {

    private Color color;

    public Pixel(Color color){
        this.color = color;
        addMouseListener(this);
        addMouseMotionListener(this);

    }

    @Override
    public void paintComponent(Graphics g){

        g.clearRect(0, 0, getWidth(), getHeight());


            MyPaint.fillColoredRect(g, this, color);


    }



    @Override
    public void mouseClicked(MouseEvent e) {
        paintPixel();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        paintPixel();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void paintPixel(){

            color = MyPaint.actualColor;
            repaint();
            System.out.println(MyPaint.actualColor);

    }
}
