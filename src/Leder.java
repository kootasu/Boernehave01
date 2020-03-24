import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
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
        // Findes ikke på klassediagrammet endnu
    }

    public void opretVagtplan() {
        // Metode
    }

    public void seVagtplan() {
        // Metode
    }

    public void opdaterVagtplan() {
        // Metode
    }

    public void sletVagtplan() {
        // Metode
    }

    public void opretMedarbejder() throws IOException {
        // Findes ikke på klassediagrammet endnu

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
        sletIndholdITekstfil("src/lister/Medarbejdere.txt");

        // Skriver elementerne fra ArrayListen medarbejderliste til fil
        FileWriter f = new FileWriter("src/lister/Medarbejdere.txt", true);
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
        Lister.foraelderliste.add(new Foraelder(navn, adresse, email, telefon1, telefon2, brugernavn, password));

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
        // Findes ikke på klassediagrammet endnu
        // Metode
    }

    public void opdaterForaelder() {
        // Findes ikke på klassediagrammet endnu
        // Metode
    }

    public void sletForaelder() {
        // Findes ikke på klassediagrammet endnu
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
