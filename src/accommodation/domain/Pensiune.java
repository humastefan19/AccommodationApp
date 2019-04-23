package accommodation.domain;

import accommodation.DAO.RoomTypeDao;

public class Pensiune extends Accommodation {

    private int panselute;
    private boolean demi_pesiune;
    private boolean pesiune_completa;


    public Pensiune(String name, int nr_camere, RoomTypeDao camere, Address adresa, int panselute, boolean demi_pensiune, boolean pesiune_completa) {
        super(name, nr_camere, camere, adresa);
        this.panselute = panselute;
        this.pesiune_completa = pesiune_completa;
        this.demi_pesiune = demi_pensiune;
    }
    public Pensiune(){
        super();
        this.panselute = 0;
        this.demi_pesiune = false;
        this.pesiune_completa = false;
    }

    public int getPanselute() {
        return panselute;
    }

    public void setPanselute(int panselute) {
        this.panselute = panselute;
    }

    public boolean isDemi_pesiune() {
        return demi_pesiune;
    }

    public void setDemi_pesiune(boolean demi_pesiune) {
        this.demi_pesiune = demi_pesiune;
    }

    public boolean isPesiune_completa() {
        return pesiune_completa;
    }

    public void setPesiune_completa(boolean pesiune_completa) {
        this.pesiune_completa = pesiune_completa;
    }
}
