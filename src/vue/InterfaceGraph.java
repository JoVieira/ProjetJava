/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

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
    private JPanel apresConnexion;
    private JPanel apresConnexion2;
    private JPanel formulaire;
    private JLabel co;
    private JLabel jlBdd;
    private JLabel petitText;
    private JTextField jtBdd;
    private JLabel jlLog;
    private JTextField jtLog;
    private JTextField vrai;
    private JLabel jlMDP;
    private JTextField jtMDP;
    private JButton boutonValider;
    private JButton rechercher;
    private JButton maj;
    private JButton graphique;
    private JButton quitter;
    private JPanel boutonsPanel;

    private JPanel formualaire2;
    private JPanel test;
    private JLabel lab;

    public InterfaceGraph() { // constructeur
        setTitle("Grey Hospital");
        //setResizable(false);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        //setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // instancier le panneau
        boutonsPanel = new JPanel();
        rechercher = new JButton();
        maj = new JButton();
        graphique = new JButton();
        quitter = new JButton();

        boutonsPanel.setLayout(null);
        boutonsPanel.add(rechercher);
        boutonsPanel.add(maj);
        boutonsPanel.add(graphique);
        boutonsPanel.add(quitter);

        boutonsPanel.setPreferredSize(new Dimension(90, 300));
        petitText = new JLabel();

        co = new JLabel();
        pan = new JPanel();
        lab = new JLabel(new ImageIcon("interface.png"));
        lab.setBounds(10, 50, 350, 350);
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
        pan.add(lab);

        rechercher.setBounds(0, 0, 200, 115);
        rechercher.setText("Rechercher");
        rechercher.setBackground(Color.lightGray);
        maj.setBounds(0, 115, 200, 115);
        maj.setText("Mise à jour");
        maj.setBackground(Color.lightGray);

        graphique.setBounds(0, 230, 200, 115);
        graphique.setText("Graphique");
        graphique.setBackground(Color.lightGray);

        quitter.setBounds(0, 345, 200, 115);
        quitter.setText("Quitter");
        quitter.setBackground(Color.lightGray);

        apresConnexion = new JPanel();
        apresConnexion.setLayout(null);
        apresConnexion.setBackground(Color.gray);

        apresConnexion.add(boutonsPanel);
        boutonsPanel.setBounds(0, 0, 200, 500);
        boutonsPanel.setBackground(Color.LIGHT_GRAY);

        apresConnexion2 = new JPanel();
        apresConnexion2.setLayout(null);
        apresConnexion2.setPreferredSize(new Dimension(600, 600));
        apresConnexion2.setBounds(200, 0, 800, 500);
        apresConnexion.add(apresConnexion2);

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
        result.add(jtBdd = new JTextField());

        result.add(jlLog = new JLabel("Login: "));
        jlLog.setFont(new Font("DialogInput", Font.BOLD, 15));
        result.add(jtLog = new JTextField());

        result.add(jlMDP = new JLabel("\nPassword:"));
        jlMDP.setFont(new Font("DialogInput", Font.BOLD, 15));
        result.add(jtMDP = new JTextField());
        result.add(jlMDP = new JLabel(""));

        return result;
    }

    public JButton getButtonConnexion() {
        return this.boutonValider;
    }
    public JButton getButtonRechercher() {
        return rechercher;
    }
    public JButton getButtonMAJ() {
        return maj;
    }
    public JButton getButtonQuitter() {
        return quitter;
    }
    public JButton getButtonGraph() {
        return this.graphique;
    }

    public String getNbdd() {
        return jtBdd.getText();
    }

    public String getLog() {
        return jtLog.getText();
    }

    public String getPass() {
        return jtMDP.getText();
    }

    public void setNom(String a) {
        jtBdd.setText(a);
    }

    public void setLog(String a) {
        jtLog.setText(a);
    }

    public void setMDP(String a) {
        jtMDP.setText(a);
    }

    public void changerMenu() {
        this.setContentPane(this.apresConnexion);
        this.revalidate();
    }
    
    public void affichReq(){
        JPanel panReq = new JPanel(); 
        JTextField req = new JTextField("Entrez ici votre requête");
        panReq.add(req);
        panReq.setVisible(true);
        this.setContentPane(panReq);
        this.revalidate();
    }

    public JButton getQuitter() {
        return quitter;
    }

}
