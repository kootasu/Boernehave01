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

    public void opretMedarbejder() {
        // Metode
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

    public void opretForaelder() {
        // Findes ikke på klassediagrammet endnu

        // Tager imod info fra scanner
        Scanner f = new Scanner(System.in);
        String navn = f.nextLine();
        String adresse = f.nextLine();
        String email = f.nextLine();
        String telefon1 = f.nextLine();
        String telefon2 = f.nextLine();
        String brugernavn = f.nextLine();
        String password = f.nextLine();

        // Tilføjer forælderobjekt til ArrayList foraelderliste
        Lister.foraelderliste.add(new Foraelder(navn, adresse, email, telefon1, telefon2, brugernavn, password));

        // Gem ArrayList i fil
        // Hvordan kan man gøre det?

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
