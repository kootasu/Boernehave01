import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public void sePerson(ArrayList liste) {
        for (int i = 0; liste.size() > i; i++) {
            System.out.println("[" + (i) + "] " + liste.get(i));
        }
    }

    public void sletIndholdITekstfil(String path) throws IOException {
        new FileWriter(path, false).close();
    }

    public void gemArrayListITekstfil(String path, ArrayList liste) throws IOException {
        FileWriter f = new FileWriter(path, true);
        try {
            for (int i = 0; i < liste.size(); i++) {
                f.write(liste.get(i).toString() + "\n");
            }
            f.close();
        } catch (IOException e) {
        }
    }

    public void opretVagtplan() {
        Date startTidspunkt = null;
        int antalDage;
        int vagtplanNummer;
        Calendar calendar = Calendar.getInstance();
        Scanner input = new Scanner(System.in);
        String filNavnStartTid;
        String filNavnSlutTid;
        Vagtplan vagtplan;

        System.out.println("Hvornår skal vagtplanen starte? (Angiv datoen i formatet: dd/mm/aaaa)");
        try {
            startTidspunkt = new SimpleDateFormat("dd/MM/yyyy/H").parse(input.nextLine()+"/8"); //Tilføjer /8 til input, hvilket svarer til kl 08, da vagtplanerne skal starte fra kl 08 af.
        }
        catch (Exception e)
        {
            System.out.println("Der skete en fejl: " + e.getMessage());
        }

        System.out.println("Hvor mange dage skal vagtplanen vare?");
        antalDage = input.nextInt();

        vagtplan = new Vagtplan(startTidspunkt, antalDage);

        calendar.setTime(startTidspunkt);

        filNavnStartTid = ""+ calendar.get(Calendar.DATE) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.YEAR);
        //filNavnStartTid = String.format("%d-%d-%d", calendar.get(Calendar.DATE),calendar.get(Calendar.MONTH + 1),calendar.get(Calendar.YEAR));
        calendar.add(Calendar.DATE, antalDage);

        filNavnSlutTid =  ""+ calendar.get(Calendar.DATE) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.YEAR);
        System.out.println("Vagtplanen er nu oprettet.");

        //Gemmer vagtplanen
        try {
             FileWriter f = new FileWriter("src/lister/Vagtplaner/vagtplan " + filNavnStartTid + " " + filNavnSlutTid + ".txt", true);

            f.write(vagtplan.TextFilFormat());

            f.close();
        }
        catch (IOException e) {
        }
        Lister.vagtplanliste.add(vagtplan);
    }

    public void seVagtplan() {
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

    public void opdaterVagtplan() {
        String[] filer = new File("src/lister/Vagtplaner/").list();
        Scanner input = new Scanner(System.in);
        Date startTidspunkt;
        int antalDage;
        int valg;
        int filValg;
        int taeller = 1;
        Vagtplan valgteVagtplan = null;
        Date medarbejderStartTidspunkt = null;
        Date medarbejderSlutTidspunkt = null;
        Medarbejder medarbejder;

        System.out.println("Hvilken vagtplan vil du opdatere?");

        for (String s : filer)
        {
            System.out.println("" + taeller + " : " + s);
            taeller++;
        }

        filValg = input.nextInt();
        try {
            input = new Scanner(new File("src/lister/Vagtplaner/" + filer[filValg - 1]));
            startTidspunkt = new Date(Long.parseLong(input.nextLine()));
            antalDage = input.nextInt();
            for (Vagtplan vagtplan : Lister.vagtplanliste) {
                if (vagtplan.getStartTidspunkt().equals(startTidspunkt) && vagtplan.getAntalDage() == antalDage) {
                    valgteVagtplan = vagtplan;
                }
            }
            for (int i = 0; i < Lister.vagtplanliste.size(); i++) {
                if (Lister.vagtplanliste.get(i).getStartTidspunkt().equals(startTidspunkt) && Lister.vagtplanliste.get(i).getAntalDage() == antalDage) {
                    valgteVagtplan = Lister.vagtplanliste.get(i);
                }
            }

            System.out.println("Hvad er start tidspunktet for vagten? (Angiv tidspunktspunktet i formatet : dd/mm/yyyy/tt");
            input = new Scanner(System.in);
            medarbejderStartTidspunkt = new SimpleDateFormat("dd/MM/yyyy/HH").parse(input.nextLine());

            System.out.println("Hvad er slut tidspunktet for vagten? (Angiv tidspunktspunktet i formatet : dd/mm/yyyy/tt");
            input = new Scanner(System.in);
            medarbejderSlutTidspunkt = new SimpleDateFormat("dd/MM/yyyy/HH").parse(input.nextLine());

            System.out.println("Hvilken medarbejder skal have vagten?");
            taeller = 1;
            for (Medarbejder m : Lister.medarbejderliste) {
                System.out.println("" + taeller + " : " + m.toString());
                taeller++;
            }
            taeller--;
            input = new Scanner(System.in);
            valg = input.nextInt();

            Vagt[][] vagter = valgteVagtplan.getVagter();

            for (int i = 0; i < vagter.length; i++) {
                for (int j = 0; j < vagter[i].length; j++) {
                    if ((vagter[i][j].getTime() >= medarbejderStartTidspunkt.getTime()) && (vagter[i][j].getTime() <= medarbejderSlutTidspunkt.getTime())) {
                        vagter[i][j].getMedarbejdere().add(Lister.medarbejderliste.get(valg-1));
                    }
                }
            }


            FileWriter f = new FileWriter("src/lister/Vagtplaner/" + filer[filValg-1]);
            f.write(valgteVagtplan.TextFilFormat());

            f.close();

            Lister.opretVagtplanliste();

        }
        catch (Exception e)
        {
            System.out.printf("Fejl");
            System.out.println(e.getMessage());
        }
    }

    public void sletVagtplan() {
        int taeller = 1;
        int valg;
        Scanner input = new Scanner(System.in);
        String[] filer = new File("src/lister/Vagtplaner/").list();
        File filNavn;

        System.out.println("Hvilken vagtplan vil du slette?");

        for (String fil : filer)
        {
            System.out.println(taeller + " : " + fil);
            taeller++;
        }

        valg = input.nextInt();
        filNavn = new File("src/lister/Vagtplaner/" + filer[valg-1]);
        filNavn.setWritable(true);

         if (filNavn.delete())
             System.out.println("slettet");
         else {
             System.out.println("Ikke slettet");
             System.out.println(filNavn.getPath());
         }
        //System.out.println("Filen  ["+ filer[valg - 1] + "] er nu slettet");

    }

    public void opretMedarbejder() throws IOException {
        // Tager imod info fra scanner
        Scanner s = new Scanner(System.in);
        System.out.println("Fortæl mig lidt om medarbejderen :P");
        System.out.println("Navn: ");
        String navn = s.nextLine();
        System.out.println("Email: ");
        String email = s.nextLine();
        System.out.println("Telefonnummer: ");
        String telefonnummer = s.nextLine();
        System.out.println("Brugernavn: ");
        String brugernavn = s.nextLine();
        System.out.println("Password: ");
        String password = s.nextLine();
        System.out.println("Stue: ");
        String stue = s.nextLine();
        System.out.println("Stilling: ");
        String stilling = s.nextLine();
        System.out.println("MedarbejderID: ");
        String medarbejderID = s.nextLine();
        s.close();
        ArrayList<String> attributliste = new ArrayList<String>(List.of(navn, email, telefonnummer, brugernavn, password, stue, stilling, medarbejderID));

        // Tilføjer medarbejderobjekt til ArrayList medarbejderliste
        Lister.medarbejderliste.add(new Medarbejder(navn, email, telefonnummer, brugernavn, password, stue, stilling, medarbejderID/*, attributliste*/));

        // Sletter alt i tekstfilen
        sletIndholdITekstfil("src/lister/Medarbejdere.txt");

        // Skriver elementerne fra ArrayListen medarbejderliste til fil
        gemArrayListITekstfil("src/lister/Medarbejdere.txt", Lister.medarbejderliste);
    }

    public void seMedarbejder() throws IOException {
        // Printer alle medarbejdere fra ArrayListen medarbejderliste
        sePerson(Lister.medarbejderliste);

        // Vælg en medarbejder
        Scanner sc = new Scanner(System.in);
        int indeks = sc.nextInt();
        System.out.println("Du har valgt " + Lister.medarbejderliste.get(indeks).getNavn());

        System.out.println("Du har nu følgende muligheder: [1] Opdater, [2] Slet, [3] Tilbage");
        int valg = sc.nextInt();
        switch (valg) {
            case 1:
                opdaterMedarbejder(indeks);
                break;
            case 2:
                sletMedarbejder(indeks);
                break;
            case 3:
                System.out.println("Tilbage");
                seMedarbejder();
                break;
        }
        sc.close();
    }

    public void opdaterMedarbejder(int indeks) throws IOException {
        Medarbejder m = Lister.medarbejderliste.get(indeks);
        ArrayList<String> attributliste = new ArrayList<String>(List.of(m.getNavn(), m.getEmail(), m.getTelefonnummer(), m.getBrugernavn(), m.getPassword(), m.getStue(), m.getStilling(), m.getMedarbejderID()));
        System.out.println("Du har ny følgende muligheder:");
        for (int i = 0; i < attributliste.size(); i++) {
            System.out.println("[" + i + "] " + attributliste.get(i));
        }
        System.out.println("[" + attributliste.size() + "] Gå tilbage");
        Scanner scValg = new Scanner(System.in);
        int valg = scValg.nextInt();
        if (valg == attributliste.size()) {
            seMedarbejder();
        } else {
            System.out.println("Hvad vil du ændre \"" + attributliste.get(valg) + "\" til?");
            Scanner scAendring = new Scanner(System.in);
            String aendring = scAendring.nextLine();
            // Opdaterer attributten i den lokale attributliste
            attributliste.set(valg, aendring);
            System.out.println(attributliste);
            // Opdaterer selve medarbejderobjektet
            Lister.medarbejderliste.set(valg, new Medarbejder(attributliste.get(0), attributliste.get(1), attributliste.get(2), attributliste.get(3), attributliste.get(4), attributliste.get(5), attributliste.get(6), attributliste.get(7)));
            System.out.println("Ændret til: \"" + attributliste.get(valg) + "\"");
            sletIndholdITekstfil("src/lister/Medarbejdere");
            gemArrayListITekstfil("src/lister/Medarbejdere", Lister.medarbejderliste);
            opdaterMedarbejder(indeks);
        }
    }

    public void sletMedarbejder(int indeks) throws IOException {
        System.out.println("Du har valgt helt og aldeles at slette " + Lister.medarbejderliste.get(indeks).getNavn());
        System.out.println("Er du helt sikker? Tryk [0] for ja, [1] for at gå tilbage");
        Scanner sc = new Scanner(System.in);
        int valg = sc.nextInt();
        switch (valg) {
            case 0:
                System.out.println("Sletter " + Lister.medarbejderliste.get(indeks).getNavn());
                // Fjern element fra ArrayList
                Lister.medarbejderliste.remove(indeks);
                // Slet al info i fil
                sletIndholdITekstfil("src/lister/Medarbejdere");
                // Gem opdateret ArrayList til fil
                gemArrayListITekstfil("src/lister/Medarbejdere", Lister.medarbejderliste);
                break;
            case 1:
                // Gå tilbage
                seMedarbejder();
                break;
        }
        sc.close();
    }

    public void opretForaelder() throws IOException {
        // Tager imod info fra scanner
        Scanner s = new Scanner(System.in);
        System.out.println("Fortæl mig lidt om forælderen :)");
        System.out.println("Navn: ");
        String navn = s.nextLine();
        System.out.println("Adresse: ");
        String adresse = s.nextLine();
        System.out.println("Email: ");
        String email = s.nextLine();
        System.out.println("Telefonnummer 1: ");
        String telefon1 = s.nextLine();
        System.out.println("Telefonnummer 2: ");
        String telefon2 = s.nextLine();
        System.out.println("Brugernavn: ");
        String brugernavn = s.nextLine();
        System.out.println("Password: ");
        String password = s.nextLine();
        System.out.println("ID: ");
        String id = s.nextLine();
        s.close();

        // Tilføjer forælderobjekt til ArrayList foraelderliste
        Lister.foraelderliste.add(new Foraelder(navn, adresse, email, telefon1, telefon2, brugernavn, password, id));

        // Sletter alt i tekstfilen
        sletIndholdITekstfil("src/lister/Foraeldre");

        // Skriver elementerne fra ArrayListen foraelderliste til fil
        gemArrayListITekstfil("src/lister/Foraeldre", Lister.foraelderliste);
    }

    public void seForaelder() throws IOException {
        // Printer alle forædre fra ArrayListen foraelderliste
        sePerson(Lister.foraelderliste);

        // Vælg en forælder
        Scanner sc = new Scanner(System.in);
        int indeks = sc.nextInt();
        System.out.println("Du har valgt " + Lister.foraelderliste.get(indeks).getNavn());

        System.out.println("Du har nu følgende muligheder: [1] Opdater, [2] Slet, [3] Tilbage");
        int valg = sc.nextInt();
        switch (valg) {
            case 1:
                opdaterForaelder(indeks);
                break;
            case 2:
                sletForaelder(indeks);
                break;
            case 3:
                System.out.println("Tilbage");
                seForaelder();
                break;
        }
        sc.close();
    }

    public void opdaterForaelder(int indeks) throws IOException {
        Foraelder f = Lister.foraelderliste.get(indeks);
        ArrayList<String> attributliste = new ArrayList<String>(List.of(f.getNavn(), f.getAdresse(), f.getEmail(), f.getTelefonnummer1(), f.getTelefonnummer2(), f.getBrugernavn(), f.getPassword(), f.getIdNummer()));
        System.out.println("Du har nu følgende muligheder:");
        for (int i = 0; i < attributliste.size(); i++) {
            System.out.println("[" + i + "] " + attributliste.get(i));
        }
        System.out.println("[" + attributliste.size() + "] Gå tilbage");
        Scanner scValg = new Scanner(System.in);
        int valg = scValg.nextInt();
        if (valg == attributliste.size()) {
            seForaelder();
        } else {
            System.out.println("Hvad vil du ændre \"" + attributliste.get(valg) + "\" til?");
            Scanner scAendring = new Scanner(System.in);
            String aendring = scAendring.nextLine();
            // Opdaterer attributten i den lokale attributliste
            attributliste.set(valg, aendring);
            System.out.println(attributliste);
            // Opdaterer selve forælderobjektet
            Lister.foraelderliste.set(valg, new Foraelder(attributliste.get(0), attributliste.get(1), attributliste.get(2), attributliste.get(3), attributliste.get(4), attributliste.get(5), attributliste.get(6), attributliste.get(7)));
            System.out.println("Ændret til: \"" + attributliste.get(valg) + "\"");
            sletIndholdITekstfil("src/lister/Foraeldre");
            gemArrayListITekstfil("src/lister/Foraeldre", Lister.foraelderliste);
            opdaterForaelder(indeks);
        }
    }

    public void sletForaelder(int indeks) throws IOException {
        System.out.println("Du har valgt helt og aldeles at slette " + Lister.foraelderliste.get(indeks).getNavn());
        System.out.println("Er du helt sikker? Tryk [0] for ja, [1] for at gå tilbage");
        Scanner sc = new Scanner(System.in);
        int valg = sc.nextInt();
        switch (valg) {
            case 0:
                System.out.println("Sletter " + Lister.foraelderliste.get(indeks).getNavn());
                // Fjern element fra ArrayList
                Lister.medarbejderliste.remove(indeks);
                // Slet al info i fil
                sletIndholdITekstfil("src/lister/Foraeldre");
                // Gem opdateret ArrayList til fil
                gemArrayListITekstfil("src/lister/Foraeldre", Lister.foraelderliste);
                break;
            case 1:
                // Gå tilbage
                seForaelder();
                break;
        }
        sc.close();
    }

    public void seVenteliste() {
        // Metode
    }

    public void opdaterVenteliste() {
        // Metode
    }

    public void godkendEllerAfvisVagtoenske() {
        int valg;
        Scanner scanner = new Scanner(System.in);
        VagtOensker vagtOenske;

        System.out.println("Vælg hvilken vagtønske du vil godkende/afvise.\n");
        System.out.println("Liste over vagtønsker");
        for (int i = 0; i < Lister.vagtoenskeliste.size(); i++)
        {
            System.out.println(i +1 + " : " + Lister.vagtoenskeliste.get(i));
        }
        valg = scanner.nextInt() - 1;
        vagtOenske = Lister.vagtoenskeliste.get(valg);

        System.out.println("1 : Godekend - "+ vagtOenske.toString());
        System.out.println("2 : Afvis - " + vagtOenske.toString());

        valg = scanner.nextInt();

        if (valg == 1)
        {
            for (Vagtplan vagtplan : Lister.vagtplanliste)
            {
                Date slutTidspunkt;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(vagtplan.getStartTidspunkt());
                calendar.add(Calendar.DATE, vagtplan.getAntalDage());
                slutTidspunkt = calendar.getTime();
                if (vagtOenske.getStarttidspunkt().getTime()>= vagtplan.getStartTidspunkt().getTime() && vagtOenske.getSluttidspunkt().getTime() <= slutTidspunkt.getTime())
                {
                    Calendar vagtOenskerCalender = Calendar.getInstance();
                    vagtOenskerCalender.setTime(vagtOenske.getStarttidspunkt());
                    while (vagtOenskerCalender.getTime().getTime() <= vagtOenske.getSluttidspunkt().getTime())
                    {
                        if (findVagt(vagtOenskerCalender.getTime()) != null) {
                            findVagt(vagtOenskerCalender.getTime()).getMedarbejdere().add(Lister.medarbejderliste.get(Integer.parseInt(vagtOenske.getMedarbejderID())));
                            vagtOenskerCalender.add(Calendar.HOUR, 1);
                        }
                        else
                            break;
                    }

                    Lister.opretVagtplanliste();
                    vagtplan.gemVagtPlan(vagtplan.getFilNavn());
                    Lister.vagtoenskeliste.remove(vagtOenske);
                    Lister.opdaterVagtOenskeListe();
                    System.out.println("Medarbejderen er nu tilføjet til vagten.");
                    return;

                }
                else
                {
                    System.out.println("Der findes ikke en vagt til vagtønsket");
                    return;
                }

            }

        }
        else if (valg == 2)
        {
            Lister.vagtoenskeliste.remove(vagtOenske);
            Lister.opdaterVagtOenskeListe();
            System.out.println("Vagtønsket er nu slettet.");
        }
    }

    public Vagt findVagt(Date tidspunnkt)
    {
        for (Vagtplan vagtplan : Lister.vagtplanliste)
        {
            for (Vagt[] dag : vagtplan.getVagter())
            {
                for (Vagt time : dag)
                {
                    if (time.getTime() == tidspunnkt.getTime())
                        return time;
                }
            }
        }
        return null;
    }

}
