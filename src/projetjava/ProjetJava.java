/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author joel
 */
public class ProjetJava extends JFrame implements ActionListener {
    
    private JButton b1, b2, b3;
    
    public ProjetJava() {
        setTitle("Hopital");
        setSize(600,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,3));
        b1 = new JButton("coucou"); 
        b2 = new JButton("bonjour"); 
        b3 = new JButton("Quitter"); 
        getContentPane().add(b1);
        getContentPane().add(b2);
        getContentPane().add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        if(e.getSource()==b1)
            b1.setText("salut");
        if(e.getSource()==b2)
            b2.setText("bonsoir");
        if(e.getSource()==b3)
            System.exit(0);
    }
    
    public static void main(String[] args) {
        ProjetJava pj = new ProjetJava();
        pj.setVisible(true);

    }
    
}
