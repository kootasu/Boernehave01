public class Foraelder {

    private String navn;
    private String adresse;
    private String email;
    private String telefonnummer1;
    private String telefonnummer2;
    private String brugernavn;
    private String password;

    public Foraelder(String navn, String adresse, String email, String telefonnummer1, String telefonnummer2, String brugernavn, String password) {
        this.navn = navn;
        this.adresse = adresse;
        this.email = email;
        this.telefonnummer1 = telefonnummer1;
        this.telefonnummer2 = telefonnummer2;
        this.brugernavn = brugernavn;
        this.password = password;
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

    @Override
    public String toString() {
        return "Navn: " + navn + "\n" +
                "Adresse: " + adresse + "\n" +
                "Email: " + email + "\n" +
                "Telefonnummer 1: " + telefonnummer1 + "\n" +
                "Telefonnummer 2: " + telefonnummer2 + "\n" +
                "Brugernavn: " + brugernavn + "\n" +
                "Password: " + password;
    }

    public void skrivBarnPaaVenteliste() {
        // Metode
    }

    public void fjernBarnFraVenteliste() {
        // Metode
        // Står endnu ikke på klassediagrammet
    }

    public void seVentelistePlacering() {
        // Metode
    }

}