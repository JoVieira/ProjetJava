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

    public ProjetJava() {
        interfaceG.getButtonConnexion().addActionListener(this);
        interfaceG.getButtonMAJ().addActionListener(this);
        interfaceG.getButtonQuitter().addActionListener(this);
        interfaceG.getButtonRechercher().addActionListener(this);

    }

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
                System.out.println("youpi");

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
            System.out.println("Cool");
            interfaceG.affichReq();
            interfaceG.getValReq().addActionListener(this);
        }
        if(e.getSource() == interfaceG.getValReq()){
            System.out.println(interfaceG.getReq().getText());
            try {
                //con.ajouterRequete(interfaceG.getReq().getText());
                con.ajouterTable(interfaceG.getReq().getText());
                con.ajouterRequete("SELECT salaire FROM Infirmier ORDER BY salaire;");
                 for (String table : con.tables) {
                     System.out.println("" + table);
        }
                 afficherRequetes();
                 afficherLignes("infirmier");
                 afficherRes("SELECT salaire FROM Infirmier ORDER BY salaire;");
                ArrayList a = con.remplirChampsTable(interfaceG.getReq().getText());
                
                for(int i=0;i<a.size();i++) {
                    System.out.println(a.get(i));
                }
            } catch (SQLException ex) { }
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
     * Afficher les lignes de la table sélectionnée
     */
    public void afficherLignes(String nomTable) {
        try {
            ArrayList<String> liste;

            // effacer les résultats
           

            // recupérér les résultats de la table selectionnee
            liste = con.remplirChampsTable(nomTable);

            // afficher les champs de la table selectionnee 
            
            for (String liste1 : liste) {
                System.out.println("" +liste);
            }

            // recuperer la liste de la table sélectionnée
            String requeteSelectionnee = "select * from " + nomTable + ";";
            liste = con.remplirChampsRequete(requeteSelectionnee);

            // afficher les lignes de la requete selectionnee a partir de la liste
            for (String liste1 : liste) {
                System.out.println("" + liste);
            }

        } catch (SQLException e) {
            // afficher l'erreur dans les résultats
           

        }
    }
    
    public void afficherRequetes() {
        for (String requete : con.requetes) {
            System.out.println("" + requete);
        }
    }
    
        public ArrayList<String> afficherRes(String requeteSelectionnee) throws SQLException {
        ArrayList<String> liste = null;
        try {

            // effacer les résultats
            

            // recupérér les résultats de la requete selectionnee
            liste = con.remplirChampsRequete(requeteSelectionnee);

            // afficher les lignes de la requete selectionnee a partir de la liste
            for (String liste1 : liste) {
                System.out.println("" + liste1);
            }
        } catch (SQLException e) {
            // afficher l'erreur dans les résultats
            
        }
        return liste;
    }


}
