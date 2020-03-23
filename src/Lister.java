import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lister {

    public static ArrayList<Foraelder> foraelderliste = new ArrayList<Foraelder>();

    public void opretMedarbejderliste() {
        // Metode
    }

    public void opretBoerneliste() {
        // Metode
    }

    public void opretForaelderliste() throws FileNotFoundException {
        // ArrayList<Foraelder> foraelderliste = new ArrayList<Foraelder>();
        File foraeldreFraFil = new File("src/lister/Foraeldre");
        Scanner f = new Scanner(foraeldreFraFil);
        try {
            while (f.hasNextLine()) {
                String[] info = f.nextLine().split(",");
                String navn = info[0];
                String adresse = info[1];
                String email = info[2];
                String telefon1 = info[3];
                String telefon2 = info[4];
                String brugernavn = info[5];
                String password = info[5];

                foraelderliste.add(new Foraelder(navn, adresse, email, telefon1, telefon2, brugernavn, password));

            }
        }
        catch (Exception e) {}
    }

    public void opretLilleStueVenteliste() {
        // Metode
    }

    public void opretMellemStueVenteliste() {
        // Metode
    }

    public void opretStorStueVenteliste() {
        // Metode
    }

    public void opretLilleStueListe() {
        // Metode
    }

    public void opretMellemStueListe() {
        // Metode
    }

    public void opretStorStueListe() {
        // Metode
    }


}
