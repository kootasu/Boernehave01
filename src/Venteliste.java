import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;

public class Venteliste {

   private Barn barn;

   static LinkedList<Barn>boern = new LinkedList<>();

   public static void opretVenteliste()
   {
       for (Barn barn : Lister.boerneliste)
       {
           if (!barn.isAktiv())
           {
               boern.add(barn);
           }
       }
       Collections.sort(boern);
   }


   public static int findPlacering(Barn barn)
   {
       for (int i = 0; i < boern.size(); i++)
       {
           //Her kommer der en nødløsning. Da børnene ikke har nogen id numre, kan man ikke identificere et unikt barn.
           //I stedet kigges der på om barnets navn og opskrivnings dato er den samme, så barnet kan blive identificeret på den måde.
           if (barn.getNavn() == boern.get(i).getNavn())
           {
               Calendar barnFraBoerneliiste = Calendar.getInstance();
               Calendar barnFraForælder = Calendar.getInstance();

               barnFraBoerneliiste.setTime(boern.get(i).getOpskrviningsdato());
               barnFraForælder.setTime(barn.getOpskrviningsdato());

               if (barnFraForælder.get(Calendar.DATE) == barnFraBoerneliiste.get(Calendar.DATE) && barnFraForælder.get(Calendar.MONTH) == barnFraBoerneliiste.get(Calendar.MONTH) && barnFraForælder.get(Calendar.YEAR) == barnFraBoerneliiste.get(Calendar.YEAR))
               {
                   return i;
               }
           }
       }
       return -1;
   }

}
