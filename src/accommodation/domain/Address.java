package accommodation.domain;

import accommodation.DAO.AccommodationDao;

import java.io.Serializable;
import java.util.Scanner;

public class Address implements Serializable {
    private static final long serialVersionUID = 1236;
    private String strada;
    private int numar;
    private String judet;
    private String localitate;
    private String cod_postal;

    public Address(String strada, int numar, String judet, String localitate, String cod_postal) {
        this.strada = strada;
        this.numar = numar;
        this.judet = judet;
        this.localitate = localitate;
        this.cod_postal = cod_postal;
    }

    public Address(){
        this.strada = null;
        this.numar = 0;
        this.judet = null;
        this.localitate = null;
        this.cod_postal = null;
    }

    public void createAddress(){

        Scanner keybord = new Scanner(System.in);
        System.out.println("Dati numele Strazi");
        String strada = keybord.nextLine();
        System.out.println("Dati numarul strazi:");
        int numar = keybord.nextInt();
        keybord.nextLine();
        System.out.println("Dati judetul:");
        String judet = keybord.nextLine();
        System.out.println("Dati localitatea:");
        String localitate = keybord.nextLine();
        System.out.println("Dati codul postal:");
        String cod_postal = keybord.nextLine();

        this.setStrada(strada);
        this.setNumar(numar);
        this.setJudet(judet);
        this.setLocalitate(localitate);
        this.setCod_postal(cod_postal);

    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getLocalitate() {
        return localitate;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public void afisare()
    {
        System.out.println(this.strada + ' ' + this.numar +',' + this.judet +',' + this.localitate + ',' + this.cod_postal);
    }
}
