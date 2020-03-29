import java.io.IOException;
import java.util.Scanner;

public class Menuer {
    Leder leder = new Leder();
    Lister lister = new Lister();


    public void HovedMenu() throws IOException {
        Scanner sc = new Scanner(System.in);


        System.out.println("Velkommen, vælg venligst en funktion ved at indtaste tallet");
        System.out.println("Du har nu følgende muligheder:\n [1] Medarbejdere\n [2] Vagtplan\n [3] Boern\n [4] Venteliste\n");

        int menuValg = sc.nextInt();
        //while (menuValg > 0) {
            switch (menuValg) {
                case 1:
                    MedarbejderMenu();
                    break;
                case 2:
                    VagtplanMenu();
                    break;
                case 3:
                   // BoerneMenu();
                    break;
                case 4:
                    VentelisteMenu();
                    break;
                default:
                    System.out.println("Ugyldig kommando. Indtast et tal fra menuen.");
            }
 /*           if (menuValg <= 0) {
                sc.close();
            }*/
        }
        public void MedarbejderMenu () throws IOException {
            Scanner MedarbejderSc = new Scanner(System.in);

            System.out.println("Du har nu følgende muligheder:\n [1] Opret medarbejder\n [2] Se medarbejder\n [3] Tilbage til hovedmenuen");

            int medarbejderMenuValg = MedarbejderSc.nextInt();
            switch (medarbejderMenuValg) {
                case 1:
                    leder.opretMedarbejder();
                    break;
                case 2:
                    System.out.println("Indtast venligst tallet på den medarbejder, du vil redigere oplysninger på:\n");
                    leder.seMedarbejder();
                    break;
                case 3:
                    HovedMenu();
                    break;
                default:
                    System.out.println("Ugyldig kommando. Indtast et tal fra menuen.");
            }
            MedarbejderSc.close();
        }

        public void VagtplanMenu(){
            Scanner vagtplanMenuSc = new Scanner(System.in);

            System.out.println("Du har nu følgende muligheder:\n [1] Opret vagtplan\n [2] Se vagtplan\n [3] Opdater vagtplan\n [4] Slet vagtplan\n");

            int vagtplanMenuValg = vagtplanMenuSc.nextInt();
            switch (vagtplanMenuValg) {
                case 1:
                    leder.opretVagtplan();
                    VagtplanMenu();
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
/*
        public void BoerneMenu() {
            Scanner boerneMenuSc = new Scanner(System.in);

            System.out.println("----Boernemenuen----");
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

    }
*/
        public void VentelisteMenu () {
            Scanner ventelisteMenuSc = new Scanner(System.in);

            System.out.println("Du har nu følgende muligheder:\n [1] Se venteliste\n [2] Opdater venteliste\n");

            int ventelisteMenuValg = ventelisteMenuSc.nextInt();
            switch (ventelisteMenuValg) {
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