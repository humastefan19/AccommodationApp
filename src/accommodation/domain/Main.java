package accommodation.domain;

import accommodation.DAO.*;
import accommodation.service.ApplicationService;
import accommodation.service.DataManipulation;
import accommodation.view.ClientView;

public class Main {

    public static void main(String[] args){
        ApplicationService loadsave = new ApplicationService();
        ReservationDao rezervari = new ReservationDao();
        AccommodationDao hotels = new HotelDao();
        AccommodationDao pensiuni = new PensiuneDao();
        AccommodationDao apartamente = new ApartmentDao();
        UserDao useri = new UserDao();
        useri = DataManipulation.get_instance().readUsers();
        //System.out.println(useri.getUser(0).getUsername());
        hotels = loadsave.readHotels();
        pensiuni = loadsave.readPensiuni();
        apartamente = loadsave.readApartamente();
        rezervari = loadsave.readReservartion();
        useri.saveUser("Andronic", "Larisa", "larandr97", "30-12-1997", "larisaandr97@yahoo.com", "0723132432");
        User login = new User();
        //login = ClientView.loginPanel(useri);
        //ClientView.menuPanel(login,(HotelDao)hotels,(PensiuneDao)pensiuni,(ApartmentDao)apartamente,rezervari);
        loadsave.saveDataCSV(useri,(HotelDao)hotels,(PensiuneDao)pensiuni,(ApartmentDao)apartamente,rezervari);
    }
}