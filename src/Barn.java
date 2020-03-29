import java.util.Calendar;
import java.util.Date;

public class Barn {

   private String stue;
   private boolean aktiv;
   private String navn;
   private String foraelder1;
   private String foraelder2;
   private int alder;
   private String koen;
   private Date opskrivningsdato;

    public Barn(String stue, boolean aktiv, String navn, String foraelderID1, String foraelderID2, int alder, String koen, Date opskrivningsdato) {
        this.stue = stue;
        this.aktiv = aktiv;
        this.navn = navn;
        this.foraelder1 = foraelderID1;
        this.foraelder2 = foraelderID2;
        this.alder = alder;
        this.koen = koen;
        this.opskrivningsdato = opskrivningsdato;
    }
    public String getStue() {
        return stue;
    }

    public void setStue(String stue) {
        this.stue=stue;
    }


    public String getForaelder1() {
        return foraelder1;
    }

    public void setForaelder1(String foraelder1) {
        this.foraelder1 = foraelder1;
    }

    public String getForaelder2() {
        return foraelder2;
    }

    public void setForaelder2(String foraelder2) {
        this.foraelder2 = foraelder2;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public String getKoen() {
        return koen;
    }

    public void setKoen(String koen) {
        this.koen = koen;
    }

    public Date getOpskrviningsdato() {
        return opskrivningsdato;
    }

    public void setOpskrviningsdato(Date opskrviningsdato) {
        this.opskrivningsdato = opskrviningsdato;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public String barnTextFilFormat()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(opskrivningsdato);
        String s = String.format("%s,%s,%s,%s,%s,%d,%s,%s", stue, aktiv, navn, foraelder1.getIdNummer(), foraelder2.getIdNummer(), alder, koen, ""+ calendar.get(Calendar.DATE) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.YEAR));
        return s;
    }

    @Override
    public String toString() {
        return "Barn{" +
                "stue='" + stue + '\'' +
                ", aktiv=" + aktiv +
              //  ", foraelder1=" + foraelder1.getNavn() +
              //  ", foraelder2=" + foraelder2.getNavn() +
                ", navn='" + navn + '\'' +
                ", alder=" + alder +
                ", koen='" + koen + '\'' +
                ", opskrivningsdato=" + opskrivningsdato +
                '}';
    }
}
