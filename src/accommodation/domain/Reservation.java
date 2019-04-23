package accommodation.domain;

import java.io.Serializable;

public class Reservation implements Serializable {

    private static final long serialVersionUID = 1255;
    User user;
    Accommodation accommodation;

    public Reservation(User user, Accommodation accommodation){
        this.user = user;
        this.accommodation = accommodation;
    }

    public User getUser() {
        return user;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }
}
