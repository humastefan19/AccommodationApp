package accommodation.domain;


import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1245;
    private String first_name;
    private String last_name;
    private String username;
    private String birth_date;
    private String email;
    private String telephone;

    public User(){
        this("Huma", "Stefan" , "humastefan19" , "19/04/1997" , "stefan.huma1@my.fmi.unibuc.ro" , "0723158231"  );
    }

    public User (String first_name, String last_name, String username, String birth_date, String email,String telephone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.birth_date = birth_date;
        this.email = email;
        this.telephone = telephone;

    }


    public String getFirst_name(){ return this.first_name; }
    public String getLast_name(){ return this.last_name; }
    public String getUsername() { return this.username; }
    public String getBirth_date() { return this.birth_date;}
    public String getEmail() {return this.email;}
    public String getTelephone() { return this.telephone;}
    public void setFirst_name(String first_name){ this.first_name = first_name;}
    public void setLast_name(String last_name) {this.last_name = last_name;}
    public void setUsername (String username) {this.username = username;}
    public void setBirth_date (String birth_date) {this.birth_date = birth_date;}
    public void setEmail (String email){ this.email = email;}
    public void setTelephone (String telephone) {this.telephone = telephone;}


}
