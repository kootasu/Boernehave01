import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
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

    public void opretVagtplan() {
        Date startTidspunkt = null;
        int antalDage;
        int vagtplanNummer;
        Scanner input = new Scanner(System.in);

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

        Vagtplan vagtplan = new Vagtplan(startTidspunkt, antalDage);

        System.out.println("Vagtplanen er nu oprettet.");

        //Gemmer vagtplanen
        try {
            vagtplanNummer = new File("src/lister/Vagtplaner/").list().length;
            FileWriter f = new FileWriter("src/lister/Vagtplaner/vagtplan" + vagtplanNummer + ".txt", true);

            f.write(vagtplan.TextFilFormat());

            f.close();
        }
        catch (IOException e) {
        }

    }

    public void seVagtplan() {

    }

    public void opdaterVagtplan() {

    }

    public void sletVagtplan() {
        // Metode
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

        // Tilføjer forælderobjekt til ArrayList foraelderliste
        Lister.medarbejderliste.add(new Medarbejder(navn, email, telefonnummer, brugernavn, password, stue, stilling));

        // Sletter alt i tekstfilen
        sletIndholdITekstfil("src/lister/Medarbejdere");

        // Skriver elementerne fra ArrayListen medarbejderliste til fil
        FileWriter f = new FileWriter("src/lister/Medarbejdere", true);
        try {
            for (int i = 0; i < Lister.medarbejderliste.size(); i++) {
                f.write(Lister.medarbejderliste.get(i).toString() + "\n");
            }
            f.close();
        } catch (IOException e) {
        }
    }

    public void seMedarbejder() {
        // Metode
    }

    public void opdaterMedarbejder() {
        // Metode
    }

    public void sletMedarbejder() {
        // Metode
    }

    public void opretForaelder() throws IOException {
        // Findes ikke på klassediagrammet endnu

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

        // Tilføjer forælderobjekt til ArrayList foraelderliste

        /*Kommenterer denne linje indtil der er styr på alt omkring forældre
        Lister.foraelderliste.add(new Foraelder(navn, adresse, email, telefon1, telefon2, brugernavn, password));*/

        // Sletter alt i tekstfilen
        sletIndholdITekstfil("src/lister/Foraeldre");

        // Skriver elementerne fra ArrayListen foraelderliste til fil
        FileWriter f = new FileWriter("src/lister/Foraeldre", true);
        try {
            for (int i = 0; i < Lister.foraelderliste.size(); i++) {
                f.write(Lister.foraelderliste.get(i).toString() + "\n");
            }
            f.close();
        } catch (IOException e) {
        }
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
