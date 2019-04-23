package accommodation.service;

import accommodation.DAO.HotelDao;
import accommodation.DAO.UserDao;
import accommodation.domain.Hotel;

import java.io.*;
import java.util.Scanner;

public class DataManipulation {

    private static DataManipulation date = null;

    private DataManipulation(){};
    public static DataManipulation get_instance(){
        if(date == null){
            date = new DataManipulation();
        }
        return date;
    }
    public void writer(Object ob, String fisier){
        try{
            FileOutputStream outS = new FileOutputStream(fisier);
            ObjectOutputStream objectOutS = new ObjectOutputStream(outS);
            objectOutS.writeObject(ob);
            objectOutS.flush();
            objectOutS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Object reader(String fisier){
        Object ob = null;
        try{
            FileInputStream inputS = new FileInputStream(fisier);
            ObjectInputStream objectInputS = new ObjectInputStream(inputS);
            ob = objectInputS.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ob;
    }

    public UserDao readUsers(){
        UserDao users = new UserDao();
        try{
            Scanner fileReader = new Scanner(new File("User.csv"));
            fileReader.useDelimiter(",");
            while(fileReader.hasNext()){
                users.saveUser(fileReader.next(), fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next(),fileReader.next());
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
    public void writeUsers(UserDao users){
        try{
            PrintWriter fileWriter = new PrintWriter(new File("User.csv"));
            //StringBuilder linie = new StringBuilder();
            for(int i=0;i<users.getNrUseri();i++){
                StringBuilder linie = new StringBuilder();
                linie.append(users.getUser(i).getFirst_name());
                linie.append(',');
                linie.append(users.getUser(i).getLast_name());
                linie.append(',');
                linie.append(users.getUser(i).getUsername());
                linie.append(',');
                linie.append(users.getUser(i).getBirth_date());
                linie.append(',');
                linie.append(users.getUser(i).getEmail());
                linie.append(',');
                linie.append(users.getUser(i).getTelephone());
                if(i!= users.getNrUseri()-1)
                {
                    linie.append(',');
                }
                fileWriter.write(linie.toString());
            }
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
