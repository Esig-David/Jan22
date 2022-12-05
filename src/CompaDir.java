import java.io.File;

public class CompaDir
{
    static final File REP_DEPART = new File("Rendus");//NE PAS MODIFIER cette ligne, ça doit marcher tel quel

    public static void main(String[] args)
    {
    }

    private static void parcoursPlat(File repDepart) // point de départ à adapter
    {
        for ( File f : repDepart.listFiles())
        {
            if (f.isDirectory() )
                ;
            else
                ;
        }
    }

    private static void parcoursRécursif(File repDepart) // point de départ à adapter
    {
        for ( File f : repDepart.listFiles())
        {
            if ( f.isDirectory() )
                // un appel à parcoursRécursif(f); est possible
                ;
            else
                ;
        }
    }

    private static File repDansCopie(File rep) // NE PAS MODIFIER !!
    {
        if ( !rep.isDirectory() )
            throw new IllegalArgumentException(rep+"n'est pas un répertoire !");
        String nomRep = rep.toString();
        String nomRepCopie = nomRep.replace("Rendus", "CopieRendus");
        return new File(nomRepCopie);
    }
}
