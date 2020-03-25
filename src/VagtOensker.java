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
}