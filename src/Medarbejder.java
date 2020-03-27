import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    //private ArrayList<String> attributliste;

    public Medarbejder(String navn, String email, String telefonnummer, String brugernavn, String password, String stue, String stilling, String medarbejderID/*, ArrayList attributliste*/) {
        this.navn = navn;
        this.email = email;
        this.telefonnummer = telefonnummer;
        this.brugernavn = brugernavn;
        this.password = password;
        this.stue = stue;
        this.stilling = stilling;
        this.medarbejderID = medarbejderID;
        //this.attributliste = attributliste;
    }

    public void seVagtplan() {      //Metode
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

    public void sletVagtOenske() { //Metode

    }

    public void oenskVagt2() throws ParseException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hej, " + navn + "\n" +
                "Hvornår skal vagten begynde? Angiv datoen i formatet: dd/mm/aaaa/t\n" +
                "(Fx 30/01/2020/8)");
        Date tidStart = new SimpleDateFormat("dd/MM/yyyy/H").parse(sc.nextLine()+"/8"); //Tilføjer /8 til input, hvilket svarer til kl 08, da vagtplanerne skal starte fra kl 08 af.
        System.out.println(tidStart);
        System.out.println("Hvornår skal vagten slutte? Angiv datoen i formatet: dd/mm/aaaa/t\n" +
                "(Fx 30/01/2020/8)");
        Date tidSlut = new SimpleDateFormat("dd/MM/yyyy/H").parse(sc.nextLine()+"/8"); //Tilføjer /8 til input, hvilket svarer til kl 08, da vagtplanerne skal starte fra kl 08 af.
        System.out.println(tidSlut);

        // Tilføjer vagtoensker-objekt til ArrayList vagtoenskeliste
        Lister.vagtoenskeliste.add(new VagtOensker (tidStart, tidSlut, medarbejderID));

        // Sletter indhold i tekstfil
        new FileWriter("src/lister/VagtOensker", false).close();

        // Skriver hele ArrayListen vagtoenskeliste til filen
        FileWriter f = new FileWriter("src/lister/VagtOensker", true);
        try {
            for (int i = 0; i < Lister.vagtoenskeliste.size(); i++) {
                f.write(Lister.vagtoenskeliste.get(i).toString() + "\n");
            }
            f.close();
        } catch (IOException e) {
        }


        /*
        FileWriter f = new FileWriter("src/lister/VagtOensker", true);
        try {
            f.write(Lister.vagtoenskeliste.toString());
            f.close();
        } catch (IOException e) {}
        */
    }

    public String getMedarbejderID() {
        return medarbejderID;
    }

    public void setMedarbejderID(String medarbejderID) {
        this.medarbejderID = medarbejderID;
    }

    public void oenskVagt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hej," + navn + ". Indtast information på din ønskede vagt:");
        System.out.println("Starttidspunkt for vagt: ");
        Date tidStart = new Date(Long.parseLong(sc.nextLine()));
        System.out.println("Sluttidspunkt for vagt: ");
        Date tidSlut = new Date(Long.parseLong(sc.nextLine()));

        // Tilføjer vagtønsket til ArrayList vagtoenskeliste
        Lister.vagtoenskeliste.add(new VagtOensker (tidStart, tidSlut, medarbejderID));
    }

    @Override
    public String toString() {
        return navn + "," + email + "," + telefonnummer + "," +
                brugernavn + "," + password + "," +
                stue + "," + stilling + ","+ medarbejderID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getBrugernavn() {
        return brugernavn;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStue() {
        return stue;
    }

    public void setStue(String stue) {
        this.stue = stue;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    /*
    public ArrayList<String> getAttributliste() {
        return attributliste;
    }

    public void setAttributliste(ArrayList<String> attributliste) {
        this.attributliste = attributliste;
    }
    */

}
