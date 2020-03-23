import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Børnehave!");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 1, 1, 8, 0, 0);
        Vagtplan vagtplan = new Vagtplan(calendar.getTime(), 8);
        System.out.println(vagtplan);
    }
}