import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApoID_Clavier extends ApoDialog implements ActionListener {
    // NE PAS MODIFIER ces 3 lignes
    private static final String CHIFFRES_DANS_L_ORDRE = "0123456789";
    private static final int LONGUEUR_CODE = 4;
    private String resultatPourAffichage = super.retournerResultat();
    JButton[] bouton = new JButton[10];
    private JButton boutonDisabled;

    ApoID_Clavier(JFrame f, String titre, String codeCorrect)// NE PAS MODIFIER  cet en-tête
    {
        super(f, titre);
        setLayout(new GridLayout(4, 0));
        for (int i = 0; i < CHIFFRES_DANS_L_ORDRE.length(); i++) {
            bouton[i] = new JButton();
            bouton[i].setText(String.valueOf(CHIFFRES_DANS_L_ORDRE.charAt(i)));
            add(bouton[i]);
            bouton[i].addActionListener(this);
        }


        JButton go = new JButton("Go");
        go.setBackground(Color.BLACK);
        go.setForeground(Color.ORANGE);

        JButton stop = new JButton("Stop");
        stop.setBackground(Color.BLACK);
        stop.setForeground(Color.ORANGE);

        add(go);
        add(stop);
        for (int i = 0; i < 4; i++) {
            boutonDisabled = new JButton();
            add(boutonDisabled);
            boutonDisabled.setEnabled(false);
        }

    }

    public int valeurBouton(String bouton) {
        return Integer.parseInt(bouton);
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
                System.out.println(i);
            }
        }
    }

}
