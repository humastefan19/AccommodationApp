package accommodation.view;

import accommodation.DAO.*;
import accommodation.domain.User;
import accommodation.service.ClientService;

import java.util.Scanner;

public class ClientView {

    public static User loginPanel(UserDao useri){
        User login = new User();
        int ok=0;
        Scanner keyboard = new Scanner(System.in);
        while (ok == 0) {
            System.out.println("Bine ati venit!");
            System.out.print("Indroduceti numele de utilizator:");
            String username = keyboard.nextLine();
            System.out.print("Dati ziua de nastere (Exemplu: 19-04-1997): ");
            String birth_date = keyboard.nextLine();
            login = ClientService.loginUser(useri, username, birth_date);
            if(login != null){
                ok = 1;
            }
        }
        return login;
    }

    public static void menuPanel(User user, HotelDao hotels, PensiuneDao pensiuni, ApartmentDao apartamente, ReservationDao rezervari){
        int optiune = -1;
        Scanner keybord = new Scanner(System.in);
        while(optiune != 0 ){
            System.out.println("Selectati optiunea:");
            System.out.println("1.Afisare Hoteluri");
            System.out.println("2.Afisare Pensiuni");
            System.out.println("3.Afisare Apartamente");
            System.out.println("4.Cautare locuri de cazare:");
            System.out.println("5.Rezervare cazare:");
            System.out.println("6.Update user");
            System.out.println("7.Adaugare cazare:");
            System.out.println("8.Rating cazari");
            System.out.println("0.EXIT");
            optiune = -1;
            while(optiune<0 || optiune >7)
            {
                optiune = keybord.nextInt();
                if(optiune<0 || optiune >7)
                {
                    System.out.println("Optiunea nu exista! Introduceti alta!");
                }
            }
            if (optiune == 1) {
                hotels.afiseazaCazare();
            } else if (optiune == 2) {
                pensiuni.afiseazaCazare();
            }else if(optiune == 3){
                apartamente.afiseazaCazare();
            } else if(optiune == 4){

            }else if(optiune == 5) {
                System.out.println("Ce tip de cazare doriti sa rezervatii:\n1.Hotel\n2.Pensiune\n3.Apartament");
                int opt = keybord.nextInt();
                if(opt == 1) {
                    ClientService.clientReservation(user,hotels,rezervari);
                } else if(opt == 2){
                    ClientService.clientReservation(user,pensiuni,rezervari);
                }else if(opt == 3){
                    ClientService.clientReservation(user,apartamente,rezervari);
                }
            }else if(optiune == 6){

            }else if(optiune == 7){
                System.out.println("Ce tip de cazare doriti sa adaugatii:\n1.Hotel\n2.Pensiune\n3.Apartament");
                int opt = keybord.nextInt();
                if(opt == 1) {
                    hotels.addCazare();
                } else if(opt == 2){
                    pensiuni.addCazare();
                }else if(opt == 3){
                    apartamente.addCazare();
                }
            }

        }
    }
}
