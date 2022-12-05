import javax.swing.*;

public class ApoID_Run
{
    public static void main(String[] args)
    {//ne pas modifier !!
        if (0 == JOptionPane.showOptionDialog(null, "Choisissez la phase à exécuter",
                "Votre attention", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new String[]{"Phase 1", "Phase 2"}, "Phase 1"))
            premièrePhase();
        else
            secondePhase();
    }

    private static void premièrePhase()
    {//Votre code ici
        ApoID_Clavier clavier = new ApoID_Clavier(null,"Clavier virtuel par David Carvalho", "1234");
        clavier.showDialog();
     }

    private static void secondePhase()
    {//votre code ici
        //appelez setLocationRelativeTo(null); sur votre instance de fenêtre pour la centrer --après pack() !
        //facultatif...
    }
}
