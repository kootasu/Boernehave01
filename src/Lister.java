import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Lister {

    public static ArrayList<Medarbejder> medarbejderliste = new ArrayList<Medarbejder>();
    public static ArrayList<Barn> boerneliste = new ArrayList<Barn>();
    public static ArrayList<Foraelder> foraelderliste = new ArrayList<Foraelder>();

    public void opretMedarbejderliste() throws FileNotFoundException {
        File medarbejdereFraFil = new File("src/lister/Medarbejdere.txt");
        Scanner f = new Scanner(medarbejdereFraFil);
        try {
            while (f.hasNextLine()) {
                String[] info = f.nextLine().split(",");
                String navn = info[0];
                String email = info[1];
                String telefonnummer = info[2];
                String brugernavn = info[3];
                String password = info[4];
                String stue = info[5];
                String stilling = info[6];
                medarbejderliste.add(new Medarbejder(navn, email, telefonnummer, brugernavn, password, stue, stilling));
            }
        }
        catch (Exception e) {}
    }

/*
    // Laurits: Jeg har lidt bøvl med denne metode
    public void opretBoerneliste() throws FileNotFoundException {
        File boernFraFil = new File("src/lister/Medarbejdere.txt");
        Scanner f = new Scanner(boernFraFil);
        try {
            while (f.hasNextLine()) {
                String[] info = f.nextLine().split(",");
                String stue = info[0];
                boolean aktiv = info[1];
                Foraelder foraelder1 = info[2];
                Foraelder foraelder2 = info[3];
                String navn = info[4];
                String alder = info[5];
                String koen = info[6];
                Date opskrivningsdato = info[7];
                boerneliste.add(new Barn(stue, aktiv, foraelder1, foraelder2, navn, alder, koen, opskrivningsdato));
            }
        }
        catch (Exception e) {}
    }

 */


    public void opretForaelderliste() throws FileNotFoundException {
        File foraeldreFraFil = new File("src/lister/Foraeldre");
        Scanner f = new Scanner(foraeldreFraFil);
        try {
            while (f.hasNextLine()) {
                String[] info = f.nextLine().split(",");
                String navn = info[0];
                String adresse = info[1];
                String email = info[2];
                String telefonnummer1 = info[3];
                String telefonnummer2 = info[4];
                String brugernavn = info[5];
                String password = info[6];
                foraelderliste.add(new Foraelder(navn, adresse, email, telefonnummer1, telefonnummer2, brugernavn, password));
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
