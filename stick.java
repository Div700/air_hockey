/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.air_hockey;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class stick extends JPanel implements MouseListener,Runnable,KeyListener
{
    int x,y,counter=0;
    int bx=0,by=0;
    int x2=200,y2=100;
    int speedx=1,speedy=1;
    int max_x,max_y;
    stick(int x,int y)
    {
        this.x=x;
        this.y=y;
        max_x=480;
        max_y=480;
        addMouseListener((MouseListener) this);
        addKeyListener((KeyListener) this);
    }
    @Override
    public void paintComponent(Graphics g) throws UnsupportedOperationException
    {
        super.paintComponent(g);
        String s="C:\\Users\\user\\Desktop\\download.jpg";
        String s2="C:\\Users\\user\\Downloads\\demo.png";
        Image i=new ImageIcon(s).getImage();
        g.drawImage(i, 0, 0, 500, 500, null);
        Image i2=new ImageIcon(s2).getImage();
        g.drawImage(i2, bx, by, 50, 50, null);
        g.setColor(Color.green);
        g.fillRect(x, y, 200, 10);
        g.setColor(Color.red);
        g.fillRect(x2, y2, 200, 10);
        //g.setColor(Color.red);
        //g.fillOval(bx, by, 25, 25);
        if(bx<=(x+200)&&(bx+50>=x)&&(by==y-20))
        {
            speedy=-speedy;
        }
        if((bx+15>max_x)||(bx<0))
        {
            speedx=-speedx;
        }
        if((by+25>max_y)||(by<0))
        {
            speedy=-speedy;
        }
        if(bx<=(x2+200)&&(bx+50>=x2)&&(by==y2-20))
        {
            speedy=-speedy;
        }
        bx+=speedx;
        by+=speedy;
        if((bx>=100)&&(bx<=300)&&(by==450))
        {
            counter=1;
            //System.out.println(counter);
            Air_hockey.end(1);            
        }
        if((bx>=100)&&(bx<=300)&&(by==0))
        {
            counter=1;
            //System.out.println(counter);
            Air_hockey.end(2);            
        }
    }
    @Override
    public boolean isFocusTraversable()//to gain focus
{
    return true;
}
    @Override
    public void mouseClicked(MouseEvent e) throws UnsupportedOperationException
    {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        x=e.getX();
        y=e.getY();      
        //if(counter==0)
           // repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) throws UnsupportedOperationException
    {
  //      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) throws UnsupportedOperationException
    {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) throws UnsupportedOperationException
    {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

    @Override
    public void mouseExited(MouseEvent e) throws UnsupportedOperationException
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public void run() throws UnsupportedOperationException
    {
        while(counter==0)
        {
            
            //System.out.println(counter);
        this.repaint();
        try {
            Thread.sleep(2);//reduce to increase the speed of ball
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (InterruptedException ex) {
            Logger.getLogger(stick.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }

    @Override
    public void keyTyped(KeyEvent e)throws UnsupportedOperationException
    {
    }

    @Override
    public void keyPressed(KeyEvent e) throws UnsupportedOperationException
    {
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_UP)
            y2-=10;
        else if(key==KeyEvent.VK_DOWN)
            y2+=10;
        else if(key==KeyEvent.VK_RIGHT)
            x2+=10;
        else if(key==KeyEvent.VK_LEFT)
            x2-=10;
        else
        {
            
        }      
    }

    @Override
    public void keyReleased(KeyEvent e) throws UnsupportedOperationException
    {
    }
}
