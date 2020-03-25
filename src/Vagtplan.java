import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Vagtplan {
    Vagt[][] vagter;
    Date startTidspunkt;
    int antalDage;

    public Vagtplan(Date startTidspunkt, int antalDage)
    {
        vagter = new Vagt[antalDage][16];
        this.startTidspunkt = startTidspunkt;
        this.antalDage = antalDage;
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(startTidspunkt);

        for(int dag = 0; dag < vagter.length; dag++)
        {
            for (int time = 0; time < 16; time++)
            {
                vagter[dag][time] = new Vagt(calendar.getTime());
                calendar.add(Calendar.MINUTE, 30);
            }

            calendar.add(Calendar.DATE, 1);
            calendar.set(Calendar.MINUTE, 0);
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
        String s = startTidspunkt.toString() + "\n";
        s+= antalDage + "\n";

        for (int dag = 0; dag < vagter.length; dag++)
        {
            for (int time = 0; time < 16; time++)
            {
                s+= vagter[dag][time].toString() + " Medarbejdere";
                s+= vagter[dag][time].getMedarbejdere().toString() + "\n";
            }
            s+= "\n";
        }
        return s;
    }
    @Override
    public String toString()
    {
        String s ="";
        int ugeNr = 1;
        s+= "\n   Uge "+ugeNr + "\n\n";
        for (int dag = 0; dag < vagter.length; dag++)
        {
            for (int time = 0; time < 16; time++)
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
