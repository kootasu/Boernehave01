import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        Lister.opretVagtplanliste();
        Lister liste = new Lister();
        liste.opretVagtOenskerListe();
        liste.opretMedarbejderliste();
        liste.opretForaelderliste();
        liste.opretBoerneliste();
        Leder leder = new Leder();
        Lister.foraelderliste.get(1).skrivBarnPaaVenteliste();
        //leder.opdaterForaelder(1);
        //leder.godkendEllerAfvisVagtoenske();
        //leder.opretVagtplan();
        /*Lister liste = new Lister();
        liste.opretVagtOenskerListe();
        for (VagtOensker v:  Lister.vagtoenskeliste)
        {
            System.out.println(v.getStarttidspunkt());
            System.out.println(v.getSluttidspunkt());
            System.out.println(v.getMedarbejderID());
        }*/

        /*
        Lister.opretVagtplanliste();
        Lister liste = new Lister();
        liste.opretMedarbejderliste();
        Leder leder = new Leder();
        leder.opretVagtplan();
        leder.opdaterVagtplan();

        /*
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 1, 1, 8, 0, 0);
        Vagtplan vagtplan = new Vagtplan(calendar.getTime(), 8);
        System.out.println(vagtplan);
        */

        /*
        Lister lister = new Lister();
        lister.opretVagtplanliste();
        System.out.println(Lister.vagtplanliste.size());
        */

        /*
        System.out.println(Lister.foraelderliste);
        Lister lister = new Lister();
        lister.opretForaelderliste();
        System.out.println(Lister.foraelderliste);
        Leder leder = new Leder();
        //leder.opretForaelder();
        //System.out.println(Lister.foraelderliste);*/

        /*
        lister.opretMedarbejderliste();
        System.out.println(Lister.medarbejderliste);
        leder.opretMedarbejder();
        System.out.println(Lister.foraelderliste);
        */

        /*
        // Her har vi en test med at oprette vagtønsker
        Lister lister = new Lister();

        lister.opretMedarbejderliste();

        lister.opretVagtOenskerListe();
        System.out.println(Lister.vagtoenskeliste);

        Lister.medarbejderliste.get(0).oenskVagt2();
        */

        /*
        // Se, opdater og slet forældre
        Lister lister = new Lister();
        lister.opretForaelderliste();
        Leder leder = new Leder();
        leder.seForaelder();
        */

        /*
        // Se, opdater og slet medarbejdere
        Lister lister = new Lister();
        lister.opretMedarbejderliste();
        Leder leder = new Leder();
        leder.seMedarbejder();
        */

    }
}
