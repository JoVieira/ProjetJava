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
                ArrayList<ArrayList<String>> a = con.remplirChampsRequete(interfaceG.getReq().getText());
                
                /*for(int i=0;i<a.size();i++) {
                    for(int j=0;j<a.get(i).size();j++) {
                        System.out.println(a.get(i).get(j));
                    }
                }*/
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

}
