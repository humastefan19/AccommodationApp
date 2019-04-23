package accommodation.service;

import accommodation.DAO.*;
import accommodation.domain.Accommodation;
import accommodation.domain.Hotel;
import accommodation.domain.User;

import java.util.Scanner;

public class ClientService {

    public static User loginUser(UserDao user , String username, String birth_date){
        for(int i=0;i<user.getNrUseri();i++)
        {
            if(user.getUser(i).getUsername().equals(username) && user.getUser(i).getBirth_date().equals(birth_date))
            {
                return user.getUser(i);
            }
        }
        return null;
    }

    public static void clientReservation(User utilizator, AccommodationDao cazari, ReservationDao rezervari){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Unde doriti sa va cazari?");
        System.out.print(cazari.getMarime());
        for(int i=0;i<cazari.getMarime();i++)
        {
                System.out.print((i + 1) + ". ");
                cazari.afisare(cazari.getAccommodation(i));
        }
        System.out.println("Scrieti numarul hotelului");
        int nr_hotel = keyboard.nextInt();
        Accommodation cazareClient = cazari.getAccommodation(nr_hotel-1);

        System.out.println("Camerele disponibile:");
        cazari.getAccommodation(nr_hotel-1).getCamere().afisareCamere();

        System.out.println("Cate camere doriti sa rezervati?");
        int nr_camere = keyboard.nextInt();
        RoomTypeDao camera_aleasa = new RoomTypeDao();
        for(int i=0;i<nr_camere;i++) {
            System.out.println("Scrieti numarul camerei:");
            int nr_camera = keyboard.nextInt();
            cazari.getAccommodation(nr_hotel - 1).getCamere().getCamera(nr_camera - 1).setFree(false);
            camera_aleasa.addRoom(cazari.getAccommodation(nr_hotel - 1).getCamere().getCamera(nr_camera - 1).getName(),
                    cazari.getAccommodation(nr_hotel - 1).getCamere().getCamera(nr_camera - 1).getM2(),
                    cazari.getAccommodation(nr_hotel - 1).getCamere().getCamera(nr_camera - 1).getNr_pers(),
                    cazari.getAccommodation(nr_hotel - 1).getCamere().getCamera(nr_camera - 1).getNr_camera(),
                    cazari.getAccommodation(nr_hotel - 1).getCamere().getCamera(nr_camera - 1).getEtaj(),
                    cazari.getAccommodation(nr_hotel - 1).getCamere().getCamera(nr_camera - 1).isFree(),
                    cazari.getAccommodation(nr_hotel - 1).getCamere().getCamera(nr_camera - 1).getDotari());
        }
        cazareClient.setCamere(camera_aleasa);

        rezervari.addReservation(utilizator, cazareClient);
        DataManipulation.get_instance().writer(rezervari, "Rezervari.csv");
        AuditService.audit("rezervare_write");
    }

    public static void afisareCazari(AccommodationDao accomodation){
        accomodation.afiseazaCazare();
    }

    public static void adaugareRating(AccommodationDao cazari){
        Scanner keyboord = new Scanner(System.in);
        System.out.println("Selectati "+ cazari.getClass().getSimpleName()+" pentru rating:");
        cazari.afiseazaCazare();
        int i = keyboord.nextInt();
        System.out.println("Dati ratingul:");
        float rating = keyboord.nextInt();
        cazari.getAccommodation(i-1).setRating_note(rating);
    }

    public static void userAdd(User user, UserDao users) {
        users.saveUser(user);
    }
    public static void hotelAdd(HotelDao hotel){
        hotel.addCazare();
    }
    public static void pensiuneAdd(PensiuneDao pensiuni){
        pensiuni.addCazare();
    }
    public static void apartamentAdd(ApartmentDao apartamente){
        apartamente.addCazare();
    }
}
