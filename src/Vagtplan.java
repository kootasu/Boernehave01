import java.util.Calendar;
import java.util.Date;

public class Vagtplan {
    Vagt[][] vagter;

    public Vagtplan(Date startTidspunkt, int antalDage)
    {
        vagter = new Vagt[antalDage][16];
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
