package accommodation.DAO;

import accommodation.domain.Accommodation;
import accommodation.domain.Address;
import accommodation.domain.Apartment;
import accommodation.domain.RoomEquipment;
import java.util.Scanner;

public class ApartmentDao extends AccommodationDao {

    public void addCazare(){

        Scanner keybord = new Scanner(System.in);
        System.out.println("Dati numele apartamentului:");
        String name = keybord.nextLine();
        System.out.println("Dati numarul de camere:");
        int nr_camere = keybord.nextInt();
        System.out.println("Dati tipul apartamentului(decomandat/semidecomandat):");
        String tip_camera = keybord.nextLine();
        System.out.println("Apasati 1 daca avetii servici de demipensiune daca nu 0(daca e unu automat pesiune completa este false):");
        int ver = keybord.nextInt();
        boolean balcon = false;
        if (ver == 1) {
            balcon = true;
        } else {
            balcon = false;
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
            int ok=0, etaj;
            System.out.println("Pentru 0 dati etajul, iar pentru 1 etajul se deduce din numarul camerei:");
            ok = keybord.nextInt();
            if(ok == 1)
            {
                etaj = Integer.parseInt(Integer.toString(nr_camera).substring(0, 1));
            }
            else{
                System.out.println("Dati etajul:");
                etaj = keybord.nextInt();
            }
            RoomEquipment dotari = new RoomEquipment();
            dotari.createRoomEquipment();
            camere.addRoom(tip,suprafata,persoane,nr_camera,etaj,false,dotari);
        }

        Apartment newApartament = new Apartment(name, nr_camere,camere,adresa, tip_camera,balcon);
        cazari.add(newApartament);
    }

    public void afisare(Accommodation acomodation){
        Apartment accApart = (Apartment) acomodation;
        System.out.println(accApart.getName());
        accApart.getAdresa().afisare();
        System.out.println("Numar camere libere: " + calculareCamereLivere(accApart));
        System.out.println("Rating:" + accApart.getRating_note());
        System.out.println("Tip apartament : "+accApart.getTip());
        System.out.print("Balcon: ");
        if(accApart.isBalcon() == true)
        {
            System.out.println("Da");
        }
        else
        {
            System.out.println("Nu");
        }
    }
}

