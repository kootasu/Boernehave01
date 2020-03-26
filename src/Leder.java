import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Leder {

    private String navn;
    private String email;
    private String telefonnummer;
    private String brugernavn;
    private String password;

    public Leder(String navn, String email, String telefonnummer, String brugernavn, String password) {
        this.navn = navn;
        this.email = email;
        this.telefonnummer = telefonnummer;
        this.brugernavn = brugernavn;
        this.password = password;
    }

    public Leder() {
    }

    public String getNavn() { return navn; }

    public void setNavn(String navn) { this.navn = navn; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getTelefonnummer() { return telefonnummer; }

    public void setTelefonnummer(String telefonnummer) { this.telefonnummer = telefonnummer; }

    public String getBrugernavn() { return brugernavn; }

    public void setBrugernavn(String brugernavn) { this.brugernavn = brugernavn; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Navn: " + navn + "\n" +
                "Email: " + email + "\n" +
                "Telefonnummer: " + telefonnummer + "\n" +
                "Brugernavn: " + brugernavn + "\n" +
                "Password: " + password;
    }

    public void sletIndholdITekstfil(String path) throws IOException {
        new FileWriter(path, false).close();
    }

    public void gemArrayListITekstfil(String path, ArrayList liste) throws IOException {
        FileWriter f = new FileWriter(path, true);
        try {
            for (int i = 0; i < liste.size(); i++) {
                f.write(liste.get(i).toString() + "\n");
            }
            f.close();
        } catch (IOException e) {
        }
    }

    public void opretVagtplan() {
        Date startTidspunkt = null;
        int antalDage;
        int vagtplanNummer;
        Calendar calendar = Calendar.getInstance();
        Scanner input = new Scanner(System.in);
        String filNavnStartTid;
        String filNavnSlutTid;
        Vagtplan vagtplan;

        System.out.println("Hvornår skal vagtplanen starte? (Angiv datoen i formatet: dd/mm/aaaa)");
        try {
            startTidspunkt = new SimpleDateFormat("dd/MM/yyyy/H").parse(input.nextLine()+"/8"); //Tilføjer /8 til input, hvilket svarer til kl 08, da vagtplanerne skal starte fra kl 08 af.
        }
        catch (Exception e)
        {
            System.out.println("Der skete en fejl: " + e.getMessage());
        }

        System.out.println("Hvor mange dage skal vagtplanen vare?");
        antalDage = input.nextInt();

        vagtplan = new Vagtplan(startTidspunkt, antalDage);

        calendar.setTime(startTidspunkt);

        filNavnStartTid = ""+ calendar.get(Calendar.DATE) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.YEAR);
        //filNavnStartTid = String.format("%d-%d-%d", calendar.get(Calendar.DATE),calendar.get(Calendar.MONTH + 1),calendar.get(Calendar.YEAR));
        calendar.add(Calendar.DATE, antalDage);

        filNavnSlutTid =  ""+ calendar.get(Calendar.DATE) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.YEAR);
        System.out.println("Vagtplanen er nu oprettet.");

        //Gemmer vagtplanen
        try {
             FileWriter f = new FileWriter("src/lister/Vagtplaner/vagtplan " + filNavnStartTid + " " + filNavnSlutTid + ".txt", true);

            f.write(vagtplan.TextFilFormat());

            f.close();
        }
        catch (IOException e) {
        }
        Lister.vagtplanliste.add(vagtplan);
    }

    public void seVagtplan() {
        int taeller = 1;
        int valg;
        Scanner input = new Scanner(System.in);
        String[] filer = new File("src/lister/Vagtplaner/").list();

        System.out.println("Hvilken vagtplan vil du se?");

        for (String fil : filer)
        {
            System.out.println(taeller + " : " + fil);
            taeller++;
        }

        valg = input.nextInt();

        System.out.println(Lister.vagtplanliste.get(valg - 1).toString());

    }

    public void opdaterVagtplan() {
        String[] filer = new File("src/lister/Vagtplaner/").list();
        Scanner input = new Scanner(System.in);
        Date startTidspunkt;
        int antalDage;
        int valg;
        int filValg;
        int taeller = 1;
        Vagtplan valgteVagtplan = null;
        Date medarbejderStartTidspunkt = null;
        Date medarbejderSlutTidspunkt = null;
        Medarbejder medarbejder;

        System.out.println("Hvilken vagtplan vil du opdatere?");

        for (String s : filer)
        {
            System.out.println("" + taeller + " : " + s);
            taeller++;
        }

        filValg = input.nextInt();
        try {
            input = new Scanner(new File("src/lister/Vagtplaner/" + filer[filValg - 1]));
            startTidspunkt = new Date(Long.parseLong(input.nextLine()));
            antalDage = input.nextInt();
            for (Vagtplan vagtplan : Lister.vagtplanliste) {
                if (vagtplan.startTidspunkt.equals(startTidspunkt) && vagtplan.antalDage == antalDage) {
                    valgteVagtplan = vagtplan;
                }
            }
            for (int i = 0; i < Lister.vagtplanliste.size(); i++) {
                if (Lister.vagtplanliste.get(i).startTidspunkt.equals(startTidspunkt) && Lister.vagtplanliste.get(i).antalDage == antalDage) {
                    valgteVagtplan = Lister.vagtplanliste.get(i);
                }
            }

            System.out.println("Hvad er start tidspunktet for vagten? (Angiv tidspunktspunktet i formatet : dd/mm/yyyy/tt");
            input = new Scanner(System.in);
            medarbejderStartTidspunkt = new SimpleDateFormat("dd/MM/yyyy/HH").parse(input.nextLine());

            System.out.println("Hvad er slut tidspunktet for vagten? (Angiv tidspunktspunktet i formatet : dd/mm/yyyy/tt");
            input = new Scanner(System.in);
            medarbejderSlutTidspunkt = new SimpleDateFormat("dd/MM/yyyy/HH").parse(input.nextLine());

            System.out.println("Hvilken medarbejder skal have vagten?");
            taeller = 1;
            for (Medarbejder m : Lister.medarbejderliste) {
                System.out.println("" + taeller + " : " + m.toString());
                taeller++;
            }
            taeller--;
            input = new Scanner(System.in);
            valg = input.nextInt();

            Vagt[][] vagter = valgteVagtplan.getVagter();

            for (int i = 0; i < vagter.length; i++) {
                for (int j = 0; j < vagter[i].length; j++) {
                    if ((vagter[i][j].getTime() >= medarbejderStartTidspunkt.getTime()) && (vagter[i][j].getTime() <= medarbejderSlutTidspunkt.getTime())) {
                        vagter[i][j].getMedarbejdere().add(Lister.medarbejderliste.get(valg-1));
                    }
                }
            }


            FileWriter f = new FileWriter("src/lister/Vagtplaner/" + filer[filValg-1]);
            f.write(valgteVagtplan.TextFilFormat());

            f.close();

            Lister.opretVagtplanliste();

        }
        catch (Exception e)
        {
            System.out.printf("Fejl");
            System.out.println(e.getMessage());
        }
    }

    public void sletVagtplan() {
        int taeller = 1;
        int valg;
        Scanner input = new Scanner(System.in);
        String[] filer = new File("src/lister/Vagtplaner/").list();
        File filNavn;

        System.out.println("Hvilken vagtplan vil du slette?");

        for (String fil : filer)
        {
            System.out.println(taeller + " : " + fil);
            taeller++;
        }

        valg = input.nextInt();
        filNavn = new File("src/lister/Vagtplaner/" + filer[valg-1]);
        filNavn.setWritable(true);

         if (filNavn.delete())
             System.out.println("slettet");
         else {
             System.out.println("Ikke slettet");
             System.out.println(filNavn.getPath());
         }
        //System.out.println("Filen  ["+ filer[valg - 1] + "] er nu slettet");

    }

    public void opretMedarbejder() throws IOException {
        // Tager imod info fra scanner
        Scanner s = new Scanner(System.in);
        System.out.println("Fortæl mig lidt om medarbejderen :P");
        System.out.println("Navn: ");
        String navn = s.nextLine();
        System.out.println("Email: ");
        String email = s.nextLine();
        System.out.println("Telefonnummer: ");
        String telefonnummer = s.nextLine();
        System.out.println("Brugernavn: ");
        String brugernavn = s.nextLine();
        System.out.println("Password: ");
        String password = s.nextLine();
        System.out.println("Stue: ");
        String stue = s.nextLine();
        System.out.println("Stilling: ");
        String stilling = s.nextLine();
        System.out.println("MedarbejderID: ");
        String medarbejderID = s.nextLine();
        s.close();

        // Tilføjer medarbejderobjekt til ArrayList medarbejderliste
        Lister.medarbejderliste.add(new Medarbejder(navn, email, telefonnummer, brugernavn, password, stue, stilling, medarbejderID));

        // Sletter alt i tekstfilen
        sletIndholdITekstfil("src/lister/Medarbejdere.txt");

        // Skriver elementerne fra ArrayListen medarbejderliste til fil
        gemArrayListITekstfil("src/lister/Medarbejdere.txt", Lister.medarbejderliste);
    }

    public void seMedarbejder() throws IOException {
        // Printer alle medarbejdere fra ArrayListen medarbejderliste
        System.out.println("Vælg en af de søde medarbejdere:");
        for (int i = 0; Lister.medarbejderliste.size() > i; i++) {
            System.out.println("[" + (i) + "] " +
                    Lister.medarbejderliste.get(i).getNavn() + ", " +
                    Lister.medarbejderliste.get(i).getEmail() + ", " +
                    Lister.medarbejderliste.get(i).getTelefonnummer() + ", " +
                    Lister.medarbejderliste.get(i).getBrugernavn() + ", " +
                    Lister.medarbejderliste.get(i).getPassword() + ", " +
                    Lister.medarbejderliste.get(i).getStue() + ", " +
                    Lister.medarbejderliste.get(i).getStilling() + ", " +
                    Lister.medarbejderliste.get(i).getMedarbejderID());
        }

        // Vælg en medarbejder
        Scanner sc = new Scanner(System.in);
        int medarbejderIndeks = sc.nextInt();
        System.out.println("Du har valgt " + Lister.medarbejderliste.get(medarbejderIndeks).getNavn());

        System.out.println("Du har nu følgende muligheder: [1] Opdater medarbejder, [2] Slet medarbejder, [3] Tilbage");
        int valg = sc.nextInt();
        switch (valg) {
            case 1:
                opdaterMedarbejder(medarbejderIndeks);
                break;
            case 2:
                sletMedarbejder(medarbejderIndeks);
                break;
            case 3:
                System.out.println("Tilbage");
                seMedarbejder();
                break;
        }
        sc.close();
    }

    public void opdaterMedarbejder(int medarbejderIndeks) {
        System.out.println("Du har valgt at opdatere " + Lister.medarbejderliste.get(medarbejderIndeks).getNavn());
        // Metode til at opdatere medarbejder
    }

    public void sletMedarbejder(int medarbejderIndeks) throws IOException {
        System.out.println("Du har valgt helt og aldeles at slette " + Lister.medarbejderliste.get(medarbejderIndeks).getNavn());
        System.out.println("Er du helt sikker? Tryk [1] for ja, [2] for at gå tilbage til alle medarbejdere");
        Scanner sc = new Scanner(System.in);
        int valg = sc.nextInt();
        switch (valg) {
            case 1:
                System.out.println("Sletter " + Lister.medarbejderliste.get(medarbejderIndeks).getNavn());
                // Fjern element fra ArrayList
                Lister.medarbejderliste.remove(medarbejderIndeks);
                // Slet al info i fil
                sletIndholdITekstfil("src/lister/Medarbejdere");
                // Gem opdateret ArrayList til fil
                gemArrayListITekstfil("src/lister/Medarbejdere", Lister.medarbejderliste);
                // Opretter ArrayList igen
                Lister.opretMedarbejderliste();
                break;
            case 2:
                // Gå tilbage
                seMedarbejder();
                break;
        }
        sc.close();
    }

    public void opretForaelder() throws IOException {
        // Tager imod info fra scanner
        Scanner s = new Scanner(System.in);
        System.out.println("Fortæl mig lidt om forælderen :)");
        System.out.println("Navn: ");
        String navn = s.nextLine();
        System.out.println("Adresse: ");
        String adresse = s.nextLine();
        System.out.println("Email: ");
        String email = s.nextLine();
        System.out.println("Telefonnummer 1: ");
        String telefon1 = s.nextLine();
        System.out.println("Telefonnummer 2: ");
        String telefon2 = s.nextLine();
        System.out.println("Brugernavn: ");
        String brugernavn = s.nextLine();
        System.out.println("Password: ");
        String password = s.nextLine();
        s.close();

        // Tilføjer forælderobjekt til ArrayList foraelderliste

        /*Kommenterer denne linje indtil der er styr på alt omkring forældre
        Lister.foraelderliste.add(new Foraelder(navn, adresse, email, telefon1, telefon2, brugernavn, password));*/

        // Sletter alt i tekstfilen
        sletIndholdITekstfil("src/lister/Foraeldre");

        // Skriver elementerne fra ArrayListen foraelderliste til fil
        gemArrayListITekstfil("src/lister/Foraeldre", Lister.foraelderliste);
    }

    public void seForaelder() {
        // Metode
    }

    public void opdaterForaelder() {
        // Metode
    }

    public void sletForaelder() {
        // Metode
    }

    public void seVenteliste() {
        // Metode
    }

    public void opdaterVenteliste() {
        // Metode
    }

    public void godkendEllerAfvisVagtoenske() {
        // Metode
    }


}
