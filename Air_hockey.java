/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.air_hockey;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Air_hockey
{
    int x=100,y=400;
    static int count=0;
    static JFrame f;
    static JLabel l;
    static stick s1;
    static JButton b1,b2;
    Thread t;
    Air_hockey() throws UnsupportedOperationException
    {
        System.out.println(count);
        f=new JFrame("AIR HOCKEY");
        f.setSize(500,500);    
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s1=new stick(x,y);
        f.add(s1);
        f.setBackground(Color.white);
        f.setVisible(true); 
        t=new Thread(s1);
        t.start();
        
    }
    static void end(int win)
    {
        count=1;
        JDialog d=new JDialog();
        l=new JLabel();
        if(win==1)
            l.setText("GOAL!1 RED WINS");
        else
            l.setText("GOAL!! GREEN WINS");
        l.setHorizontalAlignment(SwingConstants.CENTER);
        d.setSize(150,150);
        d.setLayout(new GridLayout(3,1));
        b1=new JButton("Replay");
        b2=new JButton("Exit");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                f.dispose();
                new Air_hockey();
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        //b1.setBounds(10, 50, 40, 30);
        //b1.setBounds(60, 50, 40, 30);
        d.add(l);
        d.add(b1);
        d.add(b2);
        //d.setLayout(new FlowLayout(FlowLayout.CENTER));
        d.setTitle("LOST");
        //s1.setVisible(false);
        d.setVisible(true);
    }
    public static void main(String[] args) 
    {
        new Air_hockey();
        
    }

}
