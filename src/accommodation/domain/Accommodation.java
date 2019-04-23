package accommodation.domain;

import accommodation.DAO.RoomTypeDao;
import accommodation.DAO.*;

import java.io.Serializable;

public class Accommodation implements Serializable {
    private static final long serialVersionUID = 1235;
    private int id;
    private String name;
    private int nr_camere;
    private float rating_note;
    private int nr_rating;
    private RoomTypeDao camere;
    private Address adresa;

    public Accommodation(String name, int nr_camere, RoomTypeDao camere, Address adresa){
        this.name = name;
        this.nr_camere = nr_camere;
        this.nr_rating = 0;
        this.camere = camere;
        this.adresa = adresa;
    }
    public Accommodation(){
        this.name = null;
        this.nr_camere = 0;
        this.nr_rating = 0;
        this.camere = null;
        this.adresa = null;
    }

    public String getName(){ return this.name; }
    public int getNr_camere(){return this.nr_camere;}
    public float getRating_note(){return this.rating_note;}
    public void setName (String name){this.name = name;}
    public void setNr_camere(int avaible_rooms){this.nr_camere = avaible_rooms;}
    public void setRating_note(float rating){
        this.nr_rating++;
        this.rating_note = rating/this.nr_rating;
    }

    public RoomTypeDao getCamere() {
        return camere;
    }

    public void setCamere(RoomTypeDao camere) {
        this.camere = camere;
    }

    public Address getAdresa() {
        return adresa;
    }

    public void setAdresa(Address adresa) {
        this.adresa = adresa;
    }
}
