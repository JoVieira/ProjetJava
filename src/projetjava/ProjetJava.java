<<<<<<< HEAD
package projetjava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == interfaceG.getButtonConnexion()) {
            String nom = interfaceG.getNbdd();
            String login = interfaceG.getLog();
            String mdp = interfaceG.getPass();

            interfaceG.setNom(nom);
            interfaceG.setLog(login);
            interfaceG.setMDP(mdp);

            String nomTest = "ECE";
            String logTest = "iTz";
            String mdpTest = "123";

            //if (nom.equals(nomTest) && login.equals(logTest) && mdp.equals(mdpTest)) {
                System.out.println("youpi");
                interfaceG.changerMenu();

         //   }

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
=======
package projetjava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == interfaceG.getButtonConnexion()) {
            String nom = interfaceG.getNbdd();
            String login = interfaceG.getLog();
            String mdp = interfaceG.getPass();

            interfaceG.setNom(nom);
            interfaceG.setLog(login);
            interfaceG.setMDP(mdp);

            String nomTest = "ECE";
            String logTest = "iTz";
            String mdpTest = "123";

            //if (nom.equals(nomTest) && login.equals(logTest) && mdp.equals(mdpTest)) {
                System.out.println("youpi");
                interfaceG.changerMenu();

         //   }

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
>>>>>>> 2748b72c409eae74bd889b021ce222d93453668a
