import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ApoID_Clavier extends ApoDialog implements ActionListener {
    // NE PAS MODIFIER ces 3 lignes
    private static final String CHIFFRES_DANS_L_ORDRE = "0123456789";
    private static final int LONGUEUR_CODE = 4;
    private String resultatPourAffichage = super.retournerResultat();
    private JButton[] bouton = new JButton[10];
    private String inputCode = "";
    private JButton[] boutonDisabled = new JButton[5];
    private JButton go;
    private JButton stop;
    private String code;
    private int nombreTentative = 0;

    ApoID_Clavier(JFrame f, String titre, String codeCorrect)// NE PAS MODIFIER  cet en-tête
    {
        super(f, titre);
        code = codeCorrect;
        setLayout(new GridLayout(4, 0));
        String chiffres = KnuthShuffle.melangerLettres(CHIFFRES_DANS_L_ORDRE);
        for (int i = 0; i < CHIFFRES_DANS_L_ORDRE.length(); i++) {
            int chiffre = Integer.parseInt(String.valueOf(chiffres.charAt(i)));
            bouton[chiffre] = new JButton();
            bouton[chiffre].setText(String.valueOf(chiffres.charAt(i)));
            add(bouton[chiffre]);
            bouton[chiffre].addActionListener(this);
        }


        go = new JButton("Go");
        go.addActionListener(this);
        go.setBackground(Color.BLACK);
        go.setForeground(Color.ORANGE);

        stop = new JButton("Stop");
        stop.addActionListener(this);
        stop.setBackground(Color.BLACK);
        stop.setForeground(Color.ORANGE);

        add(go);
        add(stop);

        for (int i = 0; i < 4; i++) {
            boutonDisabled[i] = new JButton();
            add(boutonDisabled[i]);
            boutonDisabled[i].setEnabled(false);
        }

    }

    @Override
    public String retournerResultat() // NE PAS MODIFIER !!!
    {
        return resultatPourAffichage;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < CHIFFRES_DANS_L_ORDRE.length(); i++) {
            if (ae.getSource().equals(bouton[i])) {
                inputCode += String.valueOf(i);
                inputAffichage("_");
            }
        }
        if (ae.getSource().equals(go)) {
            nombreTentative++;
            if (code.equals(inputCode)){
                JOptionPane.showMessageDialog(null, "code correct !", "Apo-identification", JOptionPane.INFORMATION_MESSAGE);
                resultatPourAffichage = "Réussite après 1 essai";
                inputCode = "";
                System.exit(0);
            } else {
                if (nombreTentative == 1){
                    JOptionPane.showMessageDialog(null, "code erroné ! \n\n Deux essais restants", "Apo-identification", JOptionPane.WARNING_MESSAGE);
                    resultatPourAffichage = "Réussite après 2 essais";
                    inputAffichage("");
                    inputCode = "";
                } else if (nombreTentative == 2){
                    JOptionPane.showMessageDialog(null, "code erroné ! \n\n Il reste un dernier essai", "Apo-identification", JOptionPane.WARNING_MESSAGE);
                    resultatPourAffichage = "Réussite après 3 essais";
                    inputAffichage("");
                    inputCode = "";
                } else {
                    JOptionPane.showMessageDialog(null, "échec !", "Apo-identification", JOptionPane.ERROR_MESSAGE);
                    resultatPourAffichage = "Echec après 3 essais";
                    inputAffichage("");
                    inputCode = "";
                    System.exit(0);
                }
            }
        }
        else if (ae.getSource().equals(stop)){
            resultatPourAffichage = "Abandon";
            System.exit(0);
        }

    }

    private void inputAffichage(String s) {
        for (int j = 0; j < inputCode.length(); j++) {
            if (inputCode.length() <= LONGUEUR_CODE) {
                boutonDisabled[j].setText(s);
            }
        }
    }

}
