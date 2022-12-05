import javax.swing.*;
import java.awt.*;
// NE PAS MODIFIER !
public class ApoDialog extends JDialog implements ApoDialogInterface
{
    ApoDialog(Frame f, String titre)
    {
        super(f, titre, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    String showDialog()
    {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        return retournerResultat();
    }
}


