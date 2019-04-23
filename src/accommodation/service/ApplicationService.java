package accommodation.service;

import accommodation.DAO.*;

public class ApplicationService {

    public UserDao readUsers(){
        AuditService.audit("users_read");
        return DataManipulation.get_instance().readUsers();
    }

    public HotelDao readHotels(){
        AuditService.audit("hotels_read");
        return (HotelDao) DataManipulation.get_instance().reader("Hotels.csv");
    }

    public PensiuneDao readPensiuni(){
        AuditService.audit("pensiuni_read");
        return (PensiuneDao) DataManipulation.get_instance().reader("Pensiuni.csv");
    }

    public ApartmentDao readApartamente(){
        AuditService.audit("apartamente_read");
        return (ApartmentDao) DataManipulation.get_instance().reader("Apartamente.csv");
    }

    public ReservationDao readReservartion(){
        AuditService.audit("reservation_read");
        return (ReservationDao) DataManipulation.get_instance().reader("Rezervari.csv");
    }

    private void saveUser(UserDao users){
        AuditService.audit("users_save");
        DataManipulation.get_instance().writeUsers(users);
    }

    private void saveHotels(HotelDao hotels){
        AuditService.audit("hotels_save");
        DataManipulation.get_instance().writer(hotels, "Hotels.csv");
    }

    private void savePennsiune(PensiuneDao pensiuni){
        AuditService.audit("pensiune_save");
        DataManipulation.get_instance().writer(pensiuni,"Pensiuni.csv");
    }

    private void saveApartmanete(ApartmentDao apartamente){
        AuditService.audit("apartament_save");
        DataManipulation.get_instance().writer(apartamente, "Apartamente.csv");
    }

    private void saveRezervation(ReservationDao rezervari){
        AuditService.audit("rezervari_save");
        DataManipulation.get_instance().writer(rezervari,"Rezervari.csv");
    }

    public void loadDataCSV(HotelDao hotels, PensiuneDao pensiuni, ApartmentDao apartamente, ReservationDao rezervari){
        hotels = readHotels();
        pensiuni = readPensiuni();
        apartamente = readApartamente();
        rezervari = readReservartion();
    }

    public void saveDataCSV(UserDao users,HotelDao hotels, PensiuneDao pensiuni, ApartmentDao apartamente, ReservationDao rezervari){
        saveUser(users);
        saveHotels(hotels);
        savePennsiune(pensiuni);
        saveApartmanete(apartamente);
        saveRezervation(rezervari);
    }
}
