import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ApoID_TableauBord extends JFrame {
    private JButton codeHasard;
    private JButton saisirCode;

    ApoID_TableauBord(JFrame f, String titre){
        setLayout(new FlowLayout());
        codeHasard = new JButton("tirer un code au hasard");
        saisirCode = new JButton("saisir un code");
        add(codeHasard);
        add(saisirCode);


    }


    // NE PAS MODIFIER !
    private static String tirerCodeAuHasard() {
        return new String(((new java.util.Random()).ints(4, 0, 10)).map(num -> num + (int) '0').toArray(), 0, 4);
    }


//    class WindowKiller extends WindowAdapter
//    {
//        @Override
//        public void windowClosing(WindowEvent e)
//        {
//            if (testEnCours)
//                System.out.println("oops");
//            else
//                System.exit(0);
//        }
//    }
}


