package accommodation.DAO;

import accommodation.domain.User;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.TreeSet;

public class UserDao implements Serializable {
    private static final long serialVersionUID = 1244;
    LinkedList<User> usersList;

    public UserDao(){
        usersList = new LinkedList<>();
    }

    public void saveUser(String first_name, String last_name, String username, String birth_date, String email, String telephone){
        User usr = new User(first_name,last_name,username, birth_date,email, telephone);
        usersList.add(usr);
    }

    public void saveUser(User user)
    {
        usersList.add(user);
    }

    public void deleteUser(User usr)
    {
        usersList.remove(usr);
    }

    public int getNrUseri(){
        return usersList.size();
    }

    public User getUser(int i){
        return usersList.get(i);
    }
}
