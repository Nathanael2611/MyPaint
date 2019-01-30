package fr.nathanael2611.mypaint;

import com.sun.webkit.ColorChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyPaint  {

    public static JFrame frame = new JFrame();
    public static JPanel panel = new JPanel();
    public static Color actualColor = Color.WHITE;

    public static String tool = "crayon";

    public static boolean isMouseClicked;

    public static void main(String[] args){
        new MyPaint();
    }

    public MyPaint(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1500, 1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setContentPane(panel);
        panel.setLayout(null);
        JColorChooser cc = new JColorChooser();
        cc.setBounds(1050, 0, 450, 400);
        panel.add(cc);
        panel.repaint();
        cc.setVisible(false);

        JScrollBar redBar = new JScrollBar(1);
        redBar.setBounds(1120, 10, 50, 255);
        redBar.setMaximum(255);
        redBar.setMinimum(0);
        redBar.setBackground(Color.RED);
        panel.add(redBar);
        JScrollBar greenBar = new JScrollBar(1);
        greenBar.setBounds(1170, 10, 50, 255);
        greenBar.setMaximum(255);
        greenBar.setMinimum(0);
        greenBar.setBackground(Color.GREEN);
        panel.add(greenBar);
        JScrollBar blueBar = new JScrollBar(1);
        blueBar.setBounds(1220, 10, 50, 255);
        blueBar.setMaximum(255);
        blueBar.setMinimum(0);
        blueBar.setBackground(Color.BLUE);
        panel.add(blueBar);

        ColoredRect colorRefleter = new ColoredRect(new Color(redBar.getValue(), greenBar.getValue(), blueBar.getValue()));
        colorRefleter.setBounds(1300, 10, 100, 255);
        panel.add(colorRefleter);


        redBar.repaint();
        panel.repaint();



        new Thread(){
            public void run(){
                for(int y = 0; y < frame.getHeight(); y+=50){
                    for(int x = 0; x < frame.getWidth()-500; x += 50){
                        Pixel pixel = new Pixel(Color.BLACK);
                        pixel.setBounds(x, y, 100, 100);
                        panel.add(pixel);

                        panel.repaint();
                    }
                }
            }
        }.start();
        new Thread(){
            public void run(){
                while(1==1){
                    actualColor = colorRefleter.getColor();
                    colorRefleter.setColor(new Color(redBar.getValue(), greenBar.getValue(), blueBar.getValue()));
                    System.out.println("blue : "+blueBar.getValue());

                } }

        }.start();
    }

    public static void fillColoredRect(Graphics g, JComponent component, Color color)
    {
        g.setColor(color);
        g.fillRect(0, 0, component.getWidth(), component.getHeight());
    }
    public static void fillColoredRect(Graphics g, JComponent component,int x, int y, int width, int height, Color color)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

}
