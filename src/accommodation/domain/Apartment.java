package accommodation.domain;

import accommodation.DAO.RoomTypeDao;

public class Apartment extends Accommodation {

    private String tip;
    private boolean balcon;

    public Apartment(String name, int nr_camere, RoomTypeDao camere, Address adresa, String tip, boolean balcon) {
        super(name, nr_camere, camere, adresa);
        this.tip = tip;
        this.balcon = balcon;
    }

    public Apartment(){
        super();
        this.tip = null;
        this.balcon = false;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean isBalcon() {
        return balcon;
    }

    public void setBalcon(boolean balcon) {
        this.balcon = balcon;
    }
}
