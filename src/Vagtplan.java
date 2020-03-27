import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Vagtplan {
    public Vagt[][] getVagter() {
        return vagter;
    }

    public void setVagter(Vagt[][] vagter) {
        this.vagter = vagter;
    }

    private Vagt[][] vagter;
    private Date startTidspunkt;
    private int antalDage;

    public Vagtplan(Date startTidspunkt, int antalDage)
    {
        vagter = new Vagt[antalDage][8];
        this.startTidspunkt = startTidspunkt;
        this.antalDage = antalDage;
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(startTidspunkt);

        for(int dag = 0; dag < vagter.length; dag++)
        {
            for (int time = 0; time < 8; time++)
            {
                vagter[dag][time] = new Vagt(calendar.getTime());
                calendar.add(Calendar.HOUR, 1);
            }

            calendar.add(Calendar.DATE, 1);
            calendar.set(Calendar.HOUR,-4);
        }
    }
    public void tilfoejVagt(Calendar startTidspunkt, Calendar slutTidspunkt, Medarbejder medarbejder)
    {
        for (Vagt[] dage : vagter) {
            for (Vagt dag : dage) {
                if (dag.getTid().compareTo(startTidspunkt) > 0 && dag.getTid().compareTo(slutTidspunkt) < 0) {
                    ArrayList<Medarbejder> medarbejdere = dag.getMedarbejdere();
                    medarbejdere.add(medarbejder);
                }
            }
        }

    }
    /* Denne metode returner vagtplanen i txt format, der er egnet til at gemme i en fil, så man letter kan læse data ind fra vagtplanen igen*/
    public String TextFilFormat()
    {
        String s = "" + startTidspunkt.getTime() + "\n";
        s+= antalDage + "\n";

        for (int dag = 0; dag < vagter.length; dag++)
        {
            for (int time = 0; time < 8; time++)
            {
                s+= vagter[dag][time].toString() + " Medarbejdere [";
                for (Medarbejder m : vagter[dag][time].getMedarbejdere())
                {
                    s+= m.getMedarbejderID() + ", ";
                }
                s+= "]\n";

            }

            s+= "\n";
        }
        return s;
    }

    public Date getStartTidspunkt() {
        return startTidspunkt;
    }

    public void setStartTidspunkt(Date startTidspunkt) {
        this.startTidspunkt = startTidspunkt;
    }

    public int getAntalDage() {
        return antalDage;
    }

    public void setAntalDage(int antalDage) {
        this.antalDage = antalDage;
    }

    public void gemVagtPlan(String filNavn)
    {
        FileWriter f = null;
        try {
            f = new FileWriter(new File(filNavn));
            f.write(TextFilFormat());
            f.close();
        }
        catch (IOException io) {
            System.out.println("Kunne ikke gemme vagtplanen: " + filNavn + io.getMessage());
            io.printStackTrace();
        }
    }

    public String getFilNavn()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTidspunkt);
        String filNavnStartTid;
        String filNavnSlutTid;

        filNavnStartTid = ""+ calendar.get(Calendar.DATE) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.YEAR);
        calendar.add(Calendar.DATE, antalDage);
        filNavnSlutTid =  ""+ calendar.get(Calendar.DATE) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.YEAR);

        return "src/lister/Vagtplaner/vagtplan " + filNavnStartTid + " " + filNavnSlutTid + ".txt";
    }

    @Override
    public String toString()
    {
        String s ="";
        int ugeNr = 1;
        s+= "\n   Uge "+ugeNr + "\n\n";
        for (int dag = 0; dag < vagter.length; dag++)
        {
            for (int time = 0; time < 8; time++)
            {
                s+= vagter[dag][time].toString() + " Medarbejdere";
                s+= vagter[dag][time].getMedarbejdere().toString() + "\n";
            }
            if (vagter[dag][0].getTid().get(Calendar.DAY_OF_WEEK) == 1)
            {
                ugeNr++;
                s+= "\n\t\t-----Uge "+ugeNr + "-----\n";

            }
            s+= "\n";
        }
        return s;
    }
}
