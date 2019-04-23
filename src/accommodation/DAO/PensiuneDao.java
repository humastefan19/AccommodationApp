package accommodation.DAO;

import accommodation.domain.Accommodation;
import accommodation.domain.Address;
import accommodation.domain.Pensiune;
import accommodation.domain.RoomEquipment;
import java.util.Scanner;


public class PensiuneDao extends AccommodationDao {

    public void addCazare() {

        Scanner keybord = new Scanner(System.in);
        System.out.println("Dati numele pensiuni:");
        String name = keybord.nextLine();
        System.out.println("Dati numarul de camere:");
        int nr_camere = keybord.nextInt();
        System.out.println("Dati numarul de panselute (maxim 5):");
        int panselute = keybord.nextInt();
        System.out.println("Apasati 1 daca avetii servici de demipensiune daca nu 0(daca e unu automat pesiune completa este false):");
        int ver = keybord.nextInt();
        boolean demi_pensiune = false, pensiune_completa = false;
        if (ver == 1) {
            demi_pensiune = true;
            pensiune_completa = false;
        } else {
            pensiune_completa = true;
            demi_pensiune = true;
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
            camere.addRoom(tip, suprafata, persoane, nr_camera, etaj, false, dotari);
        }

        Pensiune newPensiune = new Pensiune(name, nr_camere, camere, adresa, panselute, demi_pensiune, pensiune_completa);
        cazari.add(newPensiune);

    }

    public void afisare(Accommodation acomodation)
    {
        Pensiune accPensiune = (Pensiune) acomodation;
        System.out.print(accPensiune.getName());
        for(int i=0; i<accPensiune.getPanselute();i++)
            System.out.print("*");
        System.out.println();
        accPensiune.getAdresa().afisare();
        System.out.println("Numar camere libere: " + calculareCamereLivere(accPensiune));
        System.out.println("Rating:" + accPensiune.getRating_note());
        System.out.print("Servici pensiune:");
        if(accPensiune.isPesiune_completa()!=false)
            System.out.println("Pensiune Completa");
        else
            System.out.println("Demi Pensiune");
    }
}
