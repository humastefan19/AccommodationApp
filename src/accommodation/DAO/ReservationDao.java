package accommodation.DAO;

import accommodation.domain.Accommodation;
import accommodation.domain.Reservation;
import accommodation.domain.User;

import java.io.Serializable;

public class ReservationDao implements Serializable {

    private static final long serialVersionUID = 1256;
    Reservation[] rezervari;

    public ReservationDao(){
        rezervari = new Reservation[1];
    }

    public void addReservation(User user, Accommodation accommodation){
        Reservation newReservation = new Reservation(user, accommodation);
        int ok=0;
        for(int i=0;i<rezervari.length;i++)
        {
            if(rezervari[i] == null)
            {
                ok=1;
                rezervari[i] = newReservation;
            }
        }
        if(ok == 0)
        {
            Reservation[] aux = new Reservation[rezervari.length + 1];
            for(int i=0;i<rezervari.length;i++)
            {
                aux[i] = rezervari[i];
            }
            aux[aux.length-1] = newReservation;
            rezervari = aux;
        }
    }
    public void deleteRezervation(int i){
        rezervari[i] = null;
    }

    public Reservation[] getRezervari() {
        return rezervari;
    }
}
