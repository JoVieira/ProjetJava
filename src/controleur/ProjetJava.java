package controleur;

import modele.Connexion;
import vue.InterfaceGraph;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.omg.CORBA.SystemException;

/**
 *
 * @author joel
 */
public class ProjetJava implements ActionListener {

    /**
     * @param args the command line arguments
     */
    private InterfaceGraph interfaceG = new InterfaceGraph();
    private Connexion con;

/**
 *
 * @author joel & maxime & romuald
 * Constructeur par défaut, permet
 * d'initialiser tous les Listeneer
 */
    public ProjetJava() {
        interfaceG.getButtonConnexion().addActionListener(this);
        interfaceG.getButtonMAJ().addActionListener(this);
        interfaceG.getButtonQuitter().addActionListener(this);
        interfaceG.getButtonRechercher().addActionListener(this);

    }

/**
 *
 * @author joel & maxime & romuald
 * @param ActionEvent e
 * la méthode principale qui relie interface et
 * contrôle, elle regroupe toutes les 
 * méthodes qui seront utilisées
 */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == interfaceG.getButtonConnexion()) {
            String nom = interfaceG.getNbdd();
            String login = interfaceG.getLog();
            String mdp = interfaceG.getPass();

            interfaceG.setNom(nom);
            interfaceG.setLog(login);
            interfaceG.setMDP(mdp);

            String nomTest = "hopital";
            String logTest = "Taylor";
            String mdpTest = "isthebest";

           // if (nom.equals(nomTest) && login.equals(logTest) && mdp.equals(mdpTest)) {
            //if (nom.equals(nomTest) && login.equals(logTest) && mdp.equals(mdpTest)) {
                try {
                    con = new Connexion("Thomas", "25041962", "Taylor", "isthebest");
                } catch (SQLException | ClassNotFoundException g) {
                    g.printStackTrace();
                }
                interfaceG.changerMenu();
               // }
            //}
        }
        
        if(e.getSource() == interfaceG.getButtonQuitter())
            System.exit(0);
        if(e.getSource() == interfaceG.getButtonMAJ()){
            interfaceG.affichReq();
            interfaceG.getValReq().addActionListener(this);
        }
        if(e.getSource() == interfaceG.getValReq()){
            System.out.println(interfaceG.getReq().getText());
            //try {
                //con.ajouterRequete(interfaceG.getReq().getText());

   afficherLignes(interfaceG.getReq().getText());
            //} catch (SQLException ex) { }
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InterfaceGraph a;
        ProjetJava b;
        b = new ProjetJava();
        // a = new InterfaceGraph();

    }
    
    

/**
 *
 * @author joel & maxime & romuald
 * @param String nomTable
 * Utilise la méthode afficherRes pour afficher toutes les lignes
 * d'une table
 * @see afficherRes()
 * @version 2.0
 */
    public void afficherLignes(String nomTable) {
        try {
            ArrayList<String> liste;

            // recupérér les résultats de la table selectionnee
            liste = con.remplirChampsTable(nomTable);

            // afficher les champs de la table selectionnee 
                System.out.println(liste);

            // recuperer la liste de la table sélectionnée
            String requeteSelectionnee = "select * from " + nomTable + ";";
            
            //afficher ladite liste
            afficherRes(requeteSelectionnee);
        } catch (SQLException e) {
            // afficher l'erreur dans les résultats
            e.printStackTrace();
        }
    }

/**
 *
 * @author joel & maxime & romuald
 * Méthode qui permet d'afficher dans la console la requête saisie
 */
    public void afficherRequetes() {
        for (String requete : con.requetes) {
            System.out.println(requete);
        }
    }
    
/**
 *
 * @author joel & maxime & romuald
 * Méthode qui affiche la liste des éléments en retour d'une requête SQL
 * @throws java.sql.SQLException
 * @param String requeteSelectionnee, la requête SQL souhaitée
 * @return ArrayList liste, la lsite de tous les éléments qui consituent le résutltat de la requête
 * @version 2.0
 */
    public ArrayList<String> afficherRes(String requeteSelectionnee) throws SQLException {
        ArrayList<String> liste = null;
        try {
            // recupérér les résultats de la requete selectionnee
            liste = con.remplirChampsRequete(requeteSelectionnee);

            // afficher les lignes de la requete selectionnee a partir de la liste
            for (String liste1 : liste) {
                System.out.println(liste1);
            }
        } catch (SQLException e) {
            // afficher l'erreur dans les résultats
            e.printStackTrace();
        }
        return liste;
    }


}
