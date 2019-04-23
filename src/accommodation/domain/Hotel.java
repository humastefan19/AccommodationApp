package accommodation.domain;

import accommodation.DAO.RoomTypeDao;
import accommodation.domain.Accommodation;

public class Hotel extends Accommodation{

    private int stars;
    private boolean all_inclusive;
    private boolean breakfast;

    public Hotel(String name, int avaible_rooms, RoomTypeDao camere,Address adresa, int stars, boolean all_inclusive, boolean breakfast) {
        super(name, avaible_rooms, camere, adresa);
        this.stars = stars;
        this.all_inclusive = all_inclusive;
        this.breakfast = breakfast;
    }
    public Hotel(){
        super();
        this.stars = 0;
        this.all_inclusive = false;
        this.breakfast = false;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isAll_inclusive() {
        return all_inclusive;
    }

    public void setAll_inclusive(boolean all_inclusive) {
        this.all_inclusive = all_inclusive;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }
}
