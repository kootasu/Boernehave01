import java.io.IOException;
import java.util.Scanner;

public class Menuer {
    Leder leder = new Leder();


    public void HovedMenu() throws IOException {
        Scanner sc = new Scanner(System.in);


        System.out.println("Velkommen, vælg venligst en funktion ved at indtaste tallet");
        System.out.println("Du har nu følgende muligheder:\n [1] Medarbejdere\n [2] Vagtplan\n [3] Boern\n");

        int menuValg = sc.nextInt();
        switch (menuValg) {
            case 1:
                MedarbejderMenu();
                break;
            case 2:
                VagtplanMenu();
                break;
            case 3:
               // BoerneMenu();             inaktiv atm
                break;
            case 4:
                VentelisteMenu();
                break;
            default:
                System.out.println("Ugyldig kommando. Indtast et tal fra menuen.");
        }

    }
    public void MedarbejderMenu() throws IOException {
        Scanner MedarbejderSc = new Scanner(System.in);

        System.out.println("Du har nu valgt Medarbejdermenuen.");
        System.out.println("Du har nu følgende muligheder:\n [1] Opret medarbejder\n [2] Se medarbejder\n [3] Opdater medarbejder\n [4] Slet medarbejder\n");

        int medarbejderMenuValg = MedarbejderSc.nextInt();
        switch (medarbejderMenuValg) {
            case 1:
                leder.opretMedarbejder();
                break;
            case 2:
                leder.seMedarbejder();
                break;
            case 3:
                int indeksOpdater = MedarbejderSc.nextInt(); //Sandsynligvis andet indeks
                leder.opdaterMedarbejder(indeksOpdater);
                break;
            case 4:
                int indeksSlet = MedarbejderSc.nextInt(); // Sandsynligvis andet indeks
                leder.sletMedarbejder(indeksSlet);
                break;
            default:
                System.out.println("Ugyldig kommando. Indtast et tal fra menuen.");
        }
        MedarbejderSc.close();
    }

    public void VagtplanMenu() {
        Scanner vagtplanMenuSc = new Scanner(System.in);

        System.out.println("Du har nu valgt Vagtplanmenuen.");
        System.out.println("Du har nu følgende muligheder:\n [1] Opret vagtplan\n [2] Se vagtplan\n [3] Opdater vagtplan\n [4] Slet vagtplan\n");

        int vagtplanMenuValg = vagtplanMenuSc.nextInt();
        switch (vagtplanMenuValg) {
            case 1:
                leder.opretVagtplan();
                break;
            case 2:
                leder.seVagtplan();
                break;
            case 3:
                leder.opdaterVagtplan();
                break;
            case 4:
                leder.sletVagtplan();
                break;
            default:
                System.out.println("Ugyldig kommando. Indtast et tal fra menuen.");
        }
        vagtplanMenuSc.close();

    }

   /* public void BoerneMenu() {
        Scanner boerneMenuSc = new Scanner(System.in);

        System.out.println("Du har nu valgt Boernemenuen.");
        System.out.println("Du har nu følgende muligheder:\n [1] Opret barn\n [2] Se barn\n");

        int boerneMenuValg = boerneMenuSc.nextInt();
        switch (boerneMenuValg) {
            case 1:
                leder.opretBarn();
                break;
            case 2:
                leder.seBarn();
                break;
            default:
                System.out.println("Ugyldig kommando. Indtast et tal fra menuen.");
        }

    } */

    public void VentelisteMenu() {
        Scanner ventelisteMenuSc = new Scanner(System.in);

        System.out.println("Du har nu valgt Ventelistemenuen.");
        System.out.println("Du har nu følgende muligheder:\n [1] Se venteliste\n [2] Opdater venteliste\n");

        int ventelisteMenuValg = ventelisteMenuSc.nextInt();
        switch(ventelisteMenuValg) {
            case 1:
                leder.seVenteliste();
                break;
            case 2:
                leder.opdaterVenteliste();
                break;
            default:
                System.out.println("Ugyldig kommando. Indtat et tal fra menuen.");
        }

        }
}