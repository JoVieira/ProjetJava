/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author joel
 */
public class ProjetJava extends JFrame implements ActionListener {
    
    private JPanel pan;
    private JButton bout;
    
    public ProjetJava() {
        setTitle("Hopital");
        setSize(600,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pan = new JPanel();
        getContentPane().add(pan);
        this.setLayout(new BorderLayout());
        bout = new JButton("coucou"); 
        add(bout, "North");
        bout.addActionListener(this);
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        bout.setText("salut");
    }
    
    public static void main(String[] args) {
        ProjetJava pj = new ProjetJava();
        pj.setVisible(true);

    }
    
}
