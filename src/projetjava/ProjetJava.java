package projetjava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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

    public ProjetJava() {
        interfaceG.getButtonConnexion().addActionListener(this);
        interfaceG.getButtonMAJ().addActionListener(this);
        interfaceG.getButtonQuitter().addActionListener(this);

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

            //if (nom.equals(nomTest) && login.equals(logTest) && mdp.equals(mdpTest)) {
                System.out.println("youpi");
                try {
                    Connexion con = new Connexion("Thomas", "25041962", "Taylor", "isthebest");
                    

                } catch (SQLException | ClassNotFoundException g) {
                    g.printStackTrace();
                }
                interfaceG.changerMenu();
                
                
                }
            
            //}
        if(e.getSource() == interfaceG.getButtonQuitter())
                    System.exit(0);
                if(e.getSource() == interfaceG.getButtonMAJ()){
                    System.out.println("Cool");
                    interfaceG.affichReq();

        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        InterfaceGraph a;
        ProjetJava b;
        b = new ProjetJava();
        // a = new InterfaceGraph();

    }

}
