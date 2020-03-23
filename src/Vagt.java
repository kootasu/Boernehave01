import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* Denne klasse arver fra Date og har et Arraylist over medarbejdere som atrribut */
public class Vagt extends Date {
    private ArrayList<Medarbejder> medarbejdere;

    public Vagt(Date tid)
    {
        // Man kan ikke sætte en date direkte. Derfor laves først at calender objektet og tiden overføres derfra til dette objekts tid via setTime
        this.setTime(tid.getTime());
        medarbejdere = new ArrayList<>();

    }
    public ArrayList<Medarbejder> getMedarbejdere()
    {
        return medarbejdere;
    }

    public Calendar getTid()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this);
        return calendar;
    }


}
