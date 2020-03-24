import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello Børnehave!");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 1, 1, 8, 0, 0);
        Vagtplan vagtplan = new Vagtplan(calendar.getTime(), 8);
        System.out.println(vagtplan);

        System.out.println(Lister.foraelderliste);
        Lister lister = new Lister();
        lister.opretForaelderliste();
        System.out.println(Lister.foraelderliste);
        Leder leder = new Leder();
        leder.opretForaelder();
        System.out.println(Lister.foraelderliste);

        lister.opretMedarbejderliste();
        System.out.println(Lister.medarbejderliste);
        leder.opretMedarbejder();
        System.out.println(Lister.foraelderliste);

    }
}
