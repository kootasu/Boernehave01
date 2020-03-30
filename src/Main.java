import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Lister.opretMedarbejderliste();
        Lister.opretForaelderliste();
        Lister.opretBoerneliste();
        Lister.opretVagtplanliste();
        Venteliste.opretVenteliste();
        Lister.opretVagtplanliste();

        for (Barn b : Lister.boerneliste)
        {
            if (!b.isAktiv())
                System.out.println(b);
        }
       /* Menuer menu = new Menuer();
        menu.HovedMenu();*/
    }
}