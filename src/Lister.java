import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Lister {

    public static ArrayList<Medarbejder> medarbejderliste = new ArrayList<Medarbejder>();
    public static ArrayList<Barn> boerneliste = new ArrayList<Barn>();
    public static ArrayList<Foraelder> foraelderliste = new ArrayList<Foraelder>();
    public static ArrayList<Vagtplan> vagtplanliste = new ArrayList<>();
    public static ArrayList<VagtOensker> vagtoenskeliste = new ArrayList<VagtOensker>();

    public void opretMedarbejderliste() throws FileNotFoundException {
        File medarbejdereFraFil = new File("src/lister/Medarbejdere");
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
                String medarbejderID = info [7];
                medarbejderliste.add(new Medarbejder(navn, email, telefonnummer, brugernavn, password, stue, stilling, medarbejderID));
            }
        }
        catch (Exception e) {}
    }


   /* // Laurits: Jeg har lidt bøvl med denne metode
    public void opretBoerneliste() throws FileNotFoundException {
        File boernFraFil = new File("src/lister/Boern.txt");
        Scanner f = new Scanner(boernFraFil);
        try {
            while (f.hasNextLine()) {
                String[] info = f.nextLine().split(",");
                String stue = info[0];
                boolean aktiv = Boolean.parseBoolean(info[1]);
                Foraelder foraelder1 = info[2]; // Thomas: Vi har givet forældrene nogle id numre så vi ikke behøver at have hele forældre objektet i børnefilen.
                Foraelder foraelder2 = info[3];
                String navn = info[4];
                int alder = Integer.parseInt(info[5]);
                String koen = info[6];
                Date opskrivningsdato = new SimpleDateFormat("dd/MM/yyyy").parse(info[7]);
                boerneliste.add(new Barn(stue, aktiv, foraelder1, foraelder2, navn, alder, koen, opskrivningsdato));
            }
        }
        catch (Exception e) {}
    }*/




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
                String idNummer = info[7];
                foraelderliste.add(new Foraelder(navn, adresse, email, telefonnummer1, telefonnummer2, brugernavn, password, idNummer));
                //foraelderliste.add(new Foraelder(navn, adresse, email, telefonnummer1, telefonnummer2, brugernavn, password));
            }
        }
        catch (Exception e) {}
    }

    public static void opretVagtplanliste()
    {
        String[] vagtplaner = new File("src/lister/Vagtplaner/").list();
        for (String s : vagtplaner)
        {
            try {
                File f = new File("src/lister/Vagtplaner/"+s);
                Scanner input = new Scanner(f);
                Date startTidspunkt = new Date(Long.parseLong(input.nextLine()));
                int antalDage = input.nextInt();
                Vagtplan vagtplan = new Vagtplan(startTidspunkt, antalDage);
                vagtplanliste.add(vagtplan);
            }
            catch (Exception e)
            {
                System.out.println("Opret vagtplan liste: " + e.getMessage());
            }
        }

    }

    /* Metoden tager tage en tekst string og laver den om til en Date type. Den tager udgangs punkt i at teksten kommer fra en vagtplan fil*/
    public static Date udtraekDato(String dato)
    {

        int maaned = 0;
        Date date = null;
        String[] data = dato.split(" ");

        switch (data[1])
        {
            case "Jan":
                maaned = 1;
                break;
            case "Feb":
                maaned = 2;
                break;
            case "Mar":
                maaned = 3;
                break;
            case "Apr":
                maaned = 4;
                break;
            case "May":
                maaned = 5;
                break;
            case "Jun":
                maaned = 6;
                break;
            case "Jul":
                maaned = 7;
                break;
            case "Aug":
                maaned = 8;
                break;
            case "Sep":
                maaned = 9;
                break;
            case "Oct":
                maaned = 10;
                break;
            case "Nov":
                maaned = 11;
                break;
            case "Dec":
                maaned = 12;
                break;

        }

        String datoFormateret = String.format("%s:%d:%s:%s", data[2], maaned, data[5], data[3]);
        try {
            date = new SimpleDateFormat("dd:MM:yyyy:HH:mm:ss").parse(datoFormateret);
        }
        catch (Exception e)
        {

        }
        return date;

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
    public void opretVagtOenskerListe() throws FileNotFoundException {
        File vagtOenskerFraFil = new File("src/lister/VagtOensker");
        Scanner sc = new Scanner(vagtOenskerFraFil);
        try {
            while (sc.hasNextLine()) {
                String[] info = sc.nextLine().split(",");
                Date tidStart = new Date(Long.parseLong(info[0]));
                Date tidSlut = new Date(Long.parseLong(info[1]));
                String medarbejderID = info[2];
                vagtoenskeliste.add(new VagtOensker(tidStart, tidSlut, medarbejderID));
            }
        }
        catch (Exception e) {}
    }
}
