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
