import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Foraelder {

    private String navn;
    private String adresse;
    private String email;
    private String telefonnummer1;
    private String telefonnummer2;
    private String brugernavn;
    private String password;
    private String idNummer;

    public Foraelder(String navn, String adresse, String email, String telefonnummer1, String telefonnummer2, String brugernavn, String password, String idNummer) {
        this.navn = navn;
        this.adresse = adresse;
        this.email = email;
        this.telefonnummer1 = telefonnummer1;
        this.telefonnummer2 = telefonnummer2;
        this.brugernavn = brugernavn;
        this.password = password;
        this.idNummer = idNummer;
    }

    public String getNavn() { return navn; }

    public void setNavn(String navn) { this.navn = navn; }

    public String getAdresse() { return adresse; }

    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getTelefonnummer1() { return telefonnummer1; }

    public void setTelefonnummer1(String telefonnummer1) { this.telefonnummer1 = telefonnummer1; }

    public String getTelefonnummer2() { return telefonnummer2; }

    public void setTelefonnummer2(String telefonnummer2) { this.telefonnummer2 = telefonnummer2; }

    public String getBrugernavn() { return brugernavn; }

    public void setBrugernavn(String brugernavn) { this.brugernavn = brugernavn; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getIdNummer() {
        return idNummer;
    }

    public void setIdNummer(String idNummer) {
        this.idNummer = idNummer;
    }

    public void skrivBarnPaaVenteliste() {
        String stue;
        String barneNavn;
        Foraelder foraelder;
        int alder;
        String koen;
        Date opskrivningsDato;
        Scanner input;
        Barn barn;
        Lister liste;

        input = new Scanner(System.in);

        System.out.println("Hvilken stue skal barnet opskrives på?");
        stue = input.nextLine();

        System.out.println("Hvad er barnets navn?");
        barneNavn = input.nextLine();

        System.out.println("Hvad er barnets alder?");
        alder = Integer.parseInt(input.nextLine());

        System.out.println("Hvad er barnets køn?");
        koen = input.nextLine();

        opskrivningsDato = new Date();

        foraelder = this; // Man kunne evt. oprette en ny forælder, men her er de 2 forælder de samme.

        barn = new Barn(stue, false, this, foraelder, barneNavn, alder, koen, opskrivningsDato);

        Lister.boerneliste.add(barn);
        Leder leder = new Leder();
        try {
            FileWriter sletText = new FileWriter("src/lister/Boern");
            sletText.write("");
            sletText.close();
            FileWriter f = new FileWriter("src/lister/Boern", true);
            for (int i = 0; i < Lister.boerneliste.size(); i++) {
                f.write(Lister.boerneliste.get(i).barnTextFilFormat() + "\n");
            }
            f.close();
        } catch (IOException e) {
            System.out.println("Der skete en fejl ifm. at skrive barnet på venteliste: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void seVentelistePlacering()
    {
        Barn barn = null;

        //Finder forælderens barn
        for (Barn b : Lister.boerneliste)
        {
            if (b.getForaelder1().getIdNummer() == idNummer || b.getForaelder2().getIdNummer() == idNummer)
                barn = b;
        }

        System.out.println("Barnet er nummer: " + Venteliste.findPlacering(barn) + " på ventelisten.");
    }

    @Override
    public String toString() {
        return navn + "," + adresse + "," + email + "," +
                telefonnummer1 + "," + telefonnummer2 + "," +
                brugernavn + "," + password + "," + idNummer;
    }
}
