package accommodation.DAO;

import accommodation.domain.Accommodation;
import accommodation.domain.Address;
import accommodation.domain.Hotel;
import accommodation.domain.RoomEquipment;
import java.util.Scanner;


public class HotelDao extends AccommodationDao {

    public void addCazare() {
        Scanner keybord = new Scanner(System.in);
        System.out.println("Dati numele hotelului:");
        String name = keybord.nextLine();
        System.out.println("Dati numarul de camere:");
        int nr_camere = keybord.nextInt();
        System.out.println("Dati numarul de stele (maxim 5):");
        int stars = keybord.nextInt();
        System.out.println("Apasati 1 daca avetii servici all inclusive daca nu 0(daca e unu automat breakfast este disponibil):");
        int ver = keybord.nextInt();
        boolean all_inclusive = false, breakfast;
        if (ver == 1) {
            all_inclusive = true;
            breakfast = true;
        } else {
            System.out.println("Apasiti 1 daca aveti servici de mic dejun daca nu apasati 0:");
            int ver2 = keybord.nextInt();
            if (ver2 == 1) {
                breakfast = true;
            } else {
                breakfast = false;
            }
        }

        Address adresa = new Address();
        adresa.createAddress();

        RoomTypeDao camere = new RoomTypeDao();

        for (int i = 0; i < nr_camere; i++) {
            keybord.nextLine();
            System.out.println("Dati tipul camerei:");
            String tip = keybord.nextLine();
            System.out.println("Dati suprafata:");
            float suprafata = keybord.nextFloat();
            System.out.println("Dati capacitatea:");
            int persoane = keybord.nextInt();
            System.out.println("Dati numarul camerei:");
            int nr_camera = keybord.nextInt();
            int ok = 0, etaj;
            System.out.println("Pentru 0 dati etajul, iar pentru 1 etajul se deduce din numarul camerei:");
            ok = keybord.nextInt();
            if (ok == 1) {
                etaj = Integer.parseInt(Integer.toString(nr_camera).substring(0, 1));
            } else {
                System.out.println("Dati etajul:");
                etaj = keybord.nextInt();
            }
            RoomEquipment dotari = new RoomEquipment();
            dotari.createRoomEquipment();
            camere.addRoom(tip, suprafata, persoane, nr_camera, etaj, true, dotari);
        }

        Hotel newHotel = new Hotel(name, nr_camere, camere, adresa, stars, all_inclusive, breakfast);
        cazari.add(newHotel);
    }

    public void afisare(Accommodation acomodation){
        Hotel accHotel = (Hotel)acomodation;
        System.out.print(accHotel.getName());
        for(int i=0; i<accHotel.getStars();i++)
            System.out.print("*");
        System.out.println();
        accHotel.getAdresa().afisare();
        System.out.println("Numar camere libere: " + calculareCamereLivere(accHotel));
        System.out.println("Rating:" + accHotel.getRating_note());
        System.out.print("Servici all inclusive: ");
        if (accHotel.isAll_inclusive()) {
            System.out.println("Da");
        } else {
            System.out.println("Nu");
        }
        System.out.print("Servici mic dejun");
        if(accHotel.isBreakfast())
        {
            System.out.println("Da");
        }
        else{
            System.out.println("Nu");
        }
    }

}
