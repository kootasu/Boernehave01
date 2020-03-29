import java.util.Calendar;
import java.util.Date;

public class Barn {

    private String stue;
    private boolean aktiv;
    private Foraelder foraelder1;
    private Foraelder foraelder2;
    private String navn;
    private int alder;
    private String koen;
    private Date opskrivningsdato;

    public Barn(String stue, boolean aktiv, Foraelder foraelder1, Foraelder foraelder2, String navn, int alder, String koen, Date opskrviningsdato) {
        this.stue = stue;
        this.aktiv = aktiv;
        this.foraelder1 = foraelder1;
        this.foraelder2 = foraelder2;
        this.navn = navn;
        this.alder = alder;
        this.koen = koen;
        this.opskrivningsdato = opskrviningsdato;
    }
    public String getStue() {
        return stue;
    }

    public void setStue(String stue) {
        this.stue=stue;
    }



    public Foraelder getForaelder1() {
        return foraelder1;
    }

    public void setForaelder1(Foraelder foraelder1) {
        this.foraelder1 = foraelder1;
    }

    public Foraelder getForaelder2() {
        return foraelder2;
    }

    public void setForaelder2(Foraelder foraelder2) {
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
                ", foraelder1=" + foraelder1.getNavn() +
                ", foraelder2=" + foraelder2.getNavn() +
                ", navn='" + navn + '\'' +
                ", alder=" + alder +
                ", koen='" + koen + '\'' +
                ", opskrivningsdato=" + opskrivningsdato +
                '}';
    }
}
