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
    //¨Panel principale
    private JPanel pan; 
    
    //Panel qui va se charger une fois la connection est effectué
    private JPanel apresConnexion;
    
    //Panel qui se situe a gauche du panel bouton dans le panel apresConection
    private JPanel apresConnexion2;
    
    //Panel qui contient le formualaire
    private JPanel formulaire;
    
    //JLabel qui affiche "Connexion à la Base De Données"
    private JLabel texteCoBDD;
    
    //JLabel pour afficher l'information a entrer et JTextField pour recuperer la saisie
    private JLabel jlBdd;
    private JLabel texteBienvenue;
    private JTextField jtBdd;
    private JLabel jlLog;
    private JTextField jtLog;
    private JLabel jlMDP;
    private JTextField jtMDP;
    
    //Tout les boutons necessaires
    private JButton boutonConnection;
    private JButton boutonRechercher;
    private JButton boutonMaj;
    private JButton boutonGraphique;
    private JButton boutonQuitter;
    
    //Panel qui contient les boutons rechercher, maj...
    private JPanel boutonsPanel;

    
    //JPanel qui va prendre le texte du Jlabel Connection a la Base de ...
    private JPanel quiContientTextCoBDD;
    
    //JLabel qui affichera une image
    private JLabel image;

    public InterfaceGraph() { // constructeur
        setTitle("Grey Hospital");
        //setResizable(false);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        //setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // instancier le panneau, bouton...
        boutonsPanel = new JPanel();
        boutonRechercher = new JButton();
        boutonMaj = new JButton();
        boutonGraphique = new JButton();
        boutonQuitter = new JButton();

        boutonsPanel.setLayout(null);
        boutonsPanel.add(boutonRechercher);
        boutonsPanel.add(boutonMaj);
        boutonsPanel.add(boutonGraphique);
        boutonsPanel.add(boutonQuitter);

       
        
        //Composant qui permet d'afficher le texte "Bienvenue...."
        texteBienvenue = new JLabel();

        //JLabel 
        texteCoBDD = new JLabel();
        
        //Panel principal
        pan = new JPanel();
        
        //On cree un JLabel avec l'image
        image = new JLabel(new ImageIcon("interface.png"));
        
        //Position de l'image....taile....
        image.setBounds(10, 50, 350, 350);
        quiContientTextCoBDD = new JPanel();
        pan.setLayout(null);
        getContentPane().add(pan);
        pan.setBackground(Color.gray);

        //Panel qui contient le texte Bienvenue..., le formulaire, bouton
        JPanel DeuxiemeePanelaGaucheDuPan = new JPanel();
        
        
       //Pour gerer les elements comme je veux dans le Panel
        DeuxiemeePanelaGaucheDuPan.setLayout(null);
        
        //Panel qui contient l'arrayliste (les JTextfield ...)
        formulaire = new JPanel(new GridLayout(14, 0));
        

        //Je choisis la position x,y, largeur, et hauteur de mon Panel fields
        DeuxiemeePanelaGaucheDuPan.setBounds(370, 0, 800, 500);

        //Dans le panel formulaire j'ajoute mon arrayListe (fonction)
        for (Component comp : initFields()) {
            formulaire.add(comp);
        }
        
        //Je choisis la position x,y, largeur, et hauteur de mon Panel formulaire
        formulaire.setBounds(0, 150, 400, 450);
        
        //On modifie le texte de JLabel
        texteBienvenue.setText("Bienvenue sur votre application Hospitalier");
        
        //On choisis sa position ....
        texteBienvenue.setBounds(0, 10, 1200, 40);//x,y, larg, haut
        texteBienvenue.setBackground(Color.red);
        
        //Police , taille
        texteBienvenue.setFont(new Font("DialogInput", Font.BOLD, 23));

        texteCoBDD.setText("Connexion à la Base De Données:");
        texteCoBDD.setBounds(0, 10, 1200, 40);//x,y, larg, haut
        texteCoBDD.setFont(new Font("DialogInput", Font.BOLD, 23));
        
        //Jpanel avec le texte
        quiContientTextCoBDD.add(texteCoBDD);
        
        //Position, hauteur... du Panel avec le texte
        quiContientTextCoBDD.setBounds(-8, 100, 450, 40);
        
        //Panel qui va prendre le bouton connexion
        JPanel monButton = new JPanel();
        

       
        DeuxiemeePanelaGaucheDuPan.add(texteBienvenue);
        
        //On ajoute le bouton dans le panel 
        monButton.add(boutonConnection = new JButton("Connexion"));
        
        boutonConnection.setBackground(Color.gray);
        boutonConnection.setForeground(Color.white);
        
       //J'ajoute le panel bouton dans le panel formulaire
        formulaire.add(monButton);

        //On ajoute tous dans le panel fields
        DeuxiemeePanelaGaucheDuPan.add(formulaire);
        DeuxiemeePanelaGaucheDuPan.add(quiContientTextCoBDD);
        
        pan.add(DeuxiemeePanelaGaucheDuPan);
        pan.add(image);

        boutonRechercher.setBounds(0, 0, 200, 115);
        boutonRechercher.setText("Rechercher");
        boutonRechercher.setBackground(Color.lightGray);
        boutonMaj.setBounds(0, 115, 200, 115);
        boutonMaj.setText("Mise à jour");
        boutonMaj.setBackground(Color.lightGray);

        boutonGraphique.setBounds(0, 230, 200, 115);
        boutonGraphique.setText("Graphique");
        boutonGraphique.setBackground(Color.lightGray);

        boutonQuitter.setBounds(0, 345, 200, 115);
        boutonQuitter.setText("Quitter");
        boutonQuitter.setBackground(Color.lightGray);

        //Panel qui va se charger une fois la connection est effectué
        apresConnexion = new JPanel();
        apresConnexion.setLayout(null);
        apresConnexion.setBackground(Color.gray);

        //On ajoute nos boutons dans le Panel apresConnection 
        apresConnexion.add(boutonsPanel);
        
        //On choisis la positions dans notre page apresConnection
        boutonsPanel.setBounds(0, 0, 200, 500);
        boutonsPanel.setBackground(Color.LIGHT_GRAY);

        //On add
        apresConnexion2 = new JPanel();
        apresConnexion2.setLayout(null);
        apresConnexion2.setBounds(200, 0, 800, 500);
        apresConnexion.add(apresConnexion2);

        //  pan.add(monButton);
        this.setVisible(true);

    }

     //formualire
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
        return this.boutonConnection;
    }
    public JButton getButtonRechercher() {
        return boutonRechercher;
    }
    public JButton getButtonMAJ() {
        return boutonMaj;
    }
    public JButton getButtonQuitter() {
        return boutonQuitter;
    }
    public JButton getButtonGraph() {
        return this.boutonGraphique;
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
 //Charger le panel actuel par apresConnection
    public void changerMenu() {
        this.setContentPane(this.apresConnexion);
        this.revalidate();
    }
    //
    public void affichReq(){
        JPanel panReq = new JPanel(); 
        JTextField req = new JTextField("Entrez ici votre requête");
        panReq.add(req);
        panReq.setVisible(true);
        this.setContentPane(panReq);
        this.revalidate();
    }

    public JButton getQuitter() {
        return boutonQuitter;
    }

}
