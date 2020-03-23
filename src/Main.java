import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello Børnehave!");

        Lister lister = new Lister();
        lister.opretForaelderliste();
        System.out.println(Lister.foraelderliste);

        Leder leder = new Leder();
        leder.opretForaelder();
        System.out.println(Lister.foraelderliste);

    }
}