package accommodation.DAO;

import accommodation.domain.Accommodation;

import java.io.Serializable;
import java.util.ArrayList;


public abstract class AccommodationDao implements Serializable {

    public static final long serialVersionUID = 1234;
    protected ArrayList<Accommodation> cazari;

    public AccommodationDao(){
        cazari = new ArrayList<>();
    }
    public abstract void addCazare ();
    public void deleteCazare(String nume){

        for(int i=0;i<cazari.size();i++)
        {
            if(cazari.get(i).getName().equals(nume))
            {
                cazari.remove(i);
            }
        }
    }

    public static int calculareCamereLivere(Accommodation cazare){
        int notFree = 0;
         for(int i=0;i<cazare.getNr_camere();i++)
            if(cazare.getCamere().getCamera(i).isFree() == false)
            {
                notFree++;
            }
        return cazare.getNr_camere() - notFree;
    }
    public void afiseazaCazare(){
        for(int i=0;i<cazari.size();i++) {
            if(calculareCamereLivere(cazari.get(i))!=0) {
                System.out.println(cazari.get(i).getName());
                System.out.print("Adresa: ");
                cazari.get(i).getAdresa().afisare();
                System.out.print("Numar camere disponibile: ");
                System.out.println(calculareCamereLivere(cazari.get(i)));

            }
        }
    }
    public abstract void afisare(Accommodation acomodation);

    public int getMarime(){
        return cazari.size();
    }
    public Accommodation getAccommodation(int i){
        return cazari.get(i);
    }

}
