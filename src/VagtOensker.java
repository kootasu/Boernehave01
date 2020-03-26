import java.util.*;

public class VagtOensker {

    private Date starttidspunkt;
    private Date sluttidspunkt;
    private String medarbejderID;

    public VagtOensker(Date starttidspunkt, Date sluttidspunkt, String medarbejderID) {
        this.starttidspunkt = starttidspunkt;
        this.sluttidspunkt = sluttidspunkt;
        this.medarbejderID = medarbejderID;
    }

    public String toString() {
        //return "" + starttidspunkt.getTime() + "," + sluttidspunkt.getTime() + "," + medarbejderID + "\n";
        return starttidspunkt + "," + sluttidspunkt + "," + medarbejderID;
    }

    public Date getStarttidspunkt() {
        return starttidspunkt;
    }

    public void setStarttidspunkt(Date starttidspunkt) {
        this.starttidspunkt = starttidspunkt;
    }

    public Date getSluttidspunkt() {
        return sluttidspunkt;
    }

    public void setSluttidspunkt(Date sluttidspunkt) {
        this.sluttidspunkt = sluttidspunkt;
    }

    public String getMedarbejderID() {
        return medarbejderID;
    }

    public void setMedarbejderID(String medarbejderID) {
        this.medarbejderID = medarbejderID;
    }
}