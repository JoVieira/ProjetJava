/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Amathasan
 */
public class InterfaceGraph extends JFrame {
    
    private JPanel pan; // panneau
    private JPanel formulaire;
    private JLabel co;
    private JLabel jlBdd;
    private JLabel petitText;
    private JTextField jtBdd;
    private JLabel jlLog;
    private JTextField jtLog;
    private JLabel jlMDP;
    private JTextField jtMDP;
    private JButton boutonValider;
    
    private JPanel formualaire2;
    private JPanel test;
    
    public InterfaceGraph() { // constructeur
        setTitle("HospiECE");
        //setResizable(false);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        //setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // instancier le panneau
        petitText = new JLabel();
        co = new JLabel();
        pan = new JPanel();
        test = new JPanel();
        pan.setLayout(null);
        getContentPane().add(pan);
        pan.setBackground(Color.gray);
        
        JPanel fields = new JPanel();
        /*GridLayout fieldsLayout = new GridLayout(4, 2);
      fields.setLayout(fieldsLayout);
        fieldsLayout.setVgap(3);*/
        fields.setLayout(null);
        formulaire = new JPanel(new GridLayout(14, 0));
        // formulaire.setLayout(null);
        //formulaire2 = new JPanel(new GridLayout(14, 0));

        fields.setPreferredSize(new Dimension(600, 600));
        fields.setBounds(370, 0, 800, 500);
        
        for (Component comp : initFields()) {
            formulaire.add(comp);
        }
        //fields.setBackground(Color.lightGray);
        formulaire.setBounds(0, 150, 400, 450);
        
        petitText.setText("Bienvenue sur votre application Hospitalier");
        petitText.setBounds(0, 10, 1200, 40);//x,y, larg, haut
        petitText.setBackground(Color.red);
        petitText.setFont(new Font("DialogInput", Font.BOLD, 23));
        
        co.setText("Connexion à la Base De Données:");
        co.setBounds(0, 10, 1200, 40);//x,y, larg, haut
        co.setFont(new Font("DialogInput", Font.BOLD, 23));
        test.add(co);
        test.setBounds(-8, 100, 450, 40);
        JPanel monButton = new JPanel();
        //monButton.setLayout(null);
        //  monButton.setPreferredSize(new Dimension(100, 100));
        monButton.setBounds(50, 50, 10, 20);

        // monButton.setLayout(null);
        //monButton.setBackground(Color.red);
        //monButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        fields.add(petitText);
        monButton.add(boutonValider = new JButton("Connexion"));
        boutonValider.setBackground(Color.gray);
        boutonValider.setForeground(Color.white);
        formulaire.add(monButton);
        
        fields.add(formulaire);
        fields.add(test);
        pan.add(fields);
        //  pan.add(monButton);

        this.setVisible(true);
        
    }
    
    private ArrayList<Component> initFields() {
        ArrayList<Component> result = new ArrayList<>();
        /*  result.add(co = new JLabel("Connexion a la BASE DE DONNEES :"));
        co.setFont(new Font("Serif", Font.BOLD, 25));
        result.add(co = new JLabel("  "))*/;
        
        result.add(jlBdd = new JLabel("Nom de la base de données:"));
        jlBdd.setFont(new Font("DialogInput", Font.BOLD, 15));
        result.add(jtBdd = new JTextField("", 10));
        
        result.add(jlLog = new JLabel("Login: "));
        jlLog.setFont(new Font("DialogInput", Font.BOLD, 15));
        result.add(jtLog = new JTextField("", 10));
        
        result.add(jlMDP = new JLabel("\nPassword:"));
        jlMDP.setFont(new Font("DialogInput", Font.BOLD, 15));
        result.add(jtMDP = new JTextField("", 10));
        result.add(jlMDP = new JLabel(""));
        
        return result;
    }
    
    public void actionPerformed(ActionEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To
        // change body of generated methods, choose Tools | Templates.
        if (e.getSource() == boutonValider) {
            System.out.println("Formulaire validé");
        } else {
            System.out.println("Formulaire non validé");
        }
        
    }
    
}
