import java.io.FileNotFoundException;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello Børnehave!");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 1, 1, 8, 0, 0);
        Vagtplan vagtplan = new Vagtplan(calendar.getTime(), 8);
        System.out.println(vagtplan);


        Lister lister = new Lister();
        lister.opretForaelderliste();
        System.out.println(Lister.foraelderliste);

        Leder leder = new Leder();
        leder.opretForaelder();
        System.out.println(Lister.foraelderliste);

    }
}
