import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Medarbejder {
    private String navn;
    private String email;
    private String telefonnummer;
    private String brugernavn;
    private String password;
    private String stue;
    private String stilling;



    public Medarbejder(String navn, String email, String telefonnummer, String brugernavn, String password, String stue, String stilling) {
        this.navn = navn;
        this.email = email;
        this.telefonnummer = telefonnummer;
        this.brugernavn = brugernavn;
        this.password = password;
        this.stue = stue;
        this.stilling = stilling;
    }


    public void seVagtplan() {      //Metode

    }

    private void sletVagtOenske() { //Metode

    }

    private void oenskVagt() {      //Metode
        Scanner sc = new Scanner(System.in);
        System.out.println("Hej," + navn + ". Indtast information din ønskede vagt:");
        System.out.println("Starttidspunkt for vagt: ");
        String tidStart = sc.nextLine();
        System.out.println("Sluttidspunkt for vagt: ");
        String tidSlut = sc.nextLine();
        System.out.println("Dato for vagt: ");
        String vagtDato = sc.nextLine();
        System.out.println("Navn på din stue: ");
        String stue = sc.nextLine();

        // Tilføjer forælderobjekt til ArrayList foraelderliste
        Lister.vagtoenskeliste.add(new VagtOensker (navn, tidStart, tidSlut, vagtDato, stue));
        // Metode til at slette?

        // Metode til at skrive til liste
}

    @Override
    public String toString() {
        return navn + "," + email + "," + telefonnummer + "," +
                brugernavn + "," + password + "," +
                stue + "," + stilling;
    }
}
