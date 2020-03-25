import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Medarbejder {
    private String navn;
    private String email;
    private String telefonnummer;
    private String brugernavn;
    private String password;
    private String stue;
    private String stilling;
    private String medarbejderID;



    public Medarbejder(String navn, String email, String telefonnummer, String brugernavn, String password, String stue, String stilling, String medarbejderID) {
        this.navn = navn;
        this.email = email;
        this.telefonnummer = telefonnummer;
        this.brugernavn = brugernavn;
        this.password = password;
        this.stue = stue;
        this.stilling = stilling;
        this.medarbejderID = medarbejderID;
    }


    public void seVagtplan() {      //Metode

    }

    private void sletVagtOenske() { //Metode

    }

    private void oenskVagt() {      //Metode
        Scanner sc = new Scanner(System.in);
        System.out.println("Hej," + navn + ". Indtast information på din ønskede vagt:");
        System.out.println("Starttidspunkt for vagt: ");
        //String tidStart = sc.nextLine();
        Date tidStart = new Date(Long.parseLong(sc.nextLine()));
        System.out.println("Sluttidspunkt for vagt: ");
        //String tidSlut = sc.nextLine();
        Date tidSlut = new Date(Long.parseLong(sc.nextLine()));
        //System.out.println("Dato for vagt: ");



        // Tilføjer forælderobjekt til ArrayList foraelderliste
        Lister.vagtoenskeliste.add(new VagtOensker (tidStart, tidSlut, medarbejderID));

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
