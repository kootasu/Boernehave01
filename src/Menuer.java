import java.io.IOException;
import java.util.Scanner;

public class Menuer {
    Leder leder = new Leder();

    public void HovedMenu() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- Hovedmenu. Vælg venligst en funktion ved at indtaste tallet ---");
        System.out.println(" [1] Medarbejdere\n [2] Vagtplan\n [3] Venteliste\n");

        int menuValg = sc.nextInt();
            switch (menuValg) {
                case 1:
                    MedarbejderMenu();
                    break;
                case 2:
                    VagtplanMenu();
                    break;
                case 3:
                    VentelisteMenu();
                    break;
                default:
                    System.out.println("Ugyldig kommando. Indtast et tal fra menuen.");
            }

        }
        public void MedarbejderMenu () throws IOException {
            Scanner MedarbejderSc = new Scanner(System.in);

            System.out.println("--- Medarbejdere ---\n [1] Opret medarbejder\n [2] Se medarbejder\n [3] Tilbage til hovedmenuen");

            int medarbejderMenuValg = MedarbejderSc.nextInt();
            switch (medarbejderMenuValg) {
                case 1:
                    System.out.println("--- Opret medarbejder ---");
                    leder.opretMedarbejder();
                    MedarbejderMenu();
                    break;
                case 2:
                    System.out.println("--- Se medarbejder ---");
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

        public void VagtplanMenu() throws IOException {
            Scanner vagtplanMenuSc = new Scanner(System.in);

            System.out.println("--- Vagtplaner ---\n [1] Opret vagtplan\n [2] Se vagtplan\n [3] Opdater vagtplan\n [4] Slet vagtplan\n [5] Tilbage til hovedmenu");

            int vagtplanMenuValg = vagtplanMenuSc.nextInt();
            switch (vagtplanMenuValg) {
                case 1:
                    System.out.println("--- Opret vagtplan ---");
                    leder.opretVagtplan();
                    VagtplanMenu();
                    break;
                case 2:
                    System.out.println("--- Se vagt ---");
                    leder.seVagtplan();
                    VagtplanMenu();
                    break;
                case 3:
                    System.out.println("--- Opdater vagt ---");
                    leder.opdaterVagtplan();
                    VagtplanMenu();
                    break;
                case 4:
                    System.out.println("--- Slet vagt ---");
                    leder.sletVagtplan();
                    VagtplanMenu();
                    break;
                case 5:
                    HovedMenu();
                    break;
                default:
                    System.out.println("Ugyldig kommando. Indtast et tal fra menuen.");
            }
            vagtplanMenuSc.close();

        }
        public void VentelisteMenu () throws IOException {
            Scanner ventelisteMenuSc = new Scanner(System.in);

            System.out.println("Du har nu følgende muligheder:\n [1] Se venteliste\n [2] Tilføj barn til venteliste\n [3] Tilbage til hovedmenu");

            int ventelisteMenuValg = ventelisteMenuSc.nextInt();
            switch (ventelisteMenuValg) {
                case 1:
                    System.out.println("--- Se venteliste ---");
                    leder.seVenteliste();
                    VentelisteMenu();
                    break;
                case 2:
                    System.out.println("--- Tilføj barn til venteliste ---");
                    for (Foraelder foraelder : Lister.foraelderliste)
                    {
                        System.out.println(" [" + Lister.foraelderliste.indexOf(foraelder) + "] " + foraelder.toString());
                    }
                    int valgtForaelderSc = ventelisteMenuSc.nextInt();
                    Lister.foraelderliste.get(valgtForaelderSc).skrivBarnPaaVenteliste();
                    VentelisteMenu();
                    break;
                case 3:
                    HovedMenu();
                    break;
                default:
                    System.out.println("Ugyldig kommando. Indtat et tal fra menuen.");
            }

        }
}