package accommodation.domain;

import java.io.Serializable;
import java.util.Scanner;

public class RoomEquipment implements Serializable {
    private static final long serialVersionUID = 1264;
    private boolean wi_fi;
    private boolean plasmaTv;
    private boolean bathroom_shower;
    private boolean Bathroom_bathtub;
    private boolean fridge_beverege;
    private boolean ac;

    public RoomEquipment() {
        this.wi_fi = false;
        this.plasmaTv = false;
        this.bathroom_shower = false;
        this.Bathroom_bathtub = false;
        this.fridge_beverege = false;
        this.ac = false;

    }

    public boolean isWi_fi() {
        return wi_fi;
    }

    public void setWi_fi(boolean wi_fi) {
        this.wi_fi = wi_fi;
    }

    public boolean isPlasmaTv() {
        return plasmaTv;
    }

    public void setPlasmaTv(boolean plasmaTv) {
        this.plasmaTv = plasmaTv;
    }

    public boolean isBathroom_shower() {
        return bathroom_shower;
    }

    public void setBathroom_shower(boolean bathroom_shower) {
        this.bathroom_shower = bathroom_shower;
    }

    public boolean isBathroom_bathtub() {
        return Bathroom_bathtub;
    }

    public void setBathroom_bathtub(boolean bathroom_bathtub) {
        Bathroom_bathtub = bathroom_bathtub;
    }

    public boolean isFridge_beverege() {
        return fridge_beverege;
    }

    public void setFridge_beverege(boolean fridge_beverege) {
        this.fridge_beverege = fridge_beverege;
    }

    public boolean isAc() {
        return ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public void createRoomEquipment (){
        int ok;
        Scanner keybord  = new Scanner(System.in);
        System.out.println("Wi-fi(1/0):");
        ok = keybord.nextInt();
        if(ok == 1){
            this.wi_fi = true;
        }
        else {
            this.wi_fi = false;
        }
        System.out.println("plasmaTv(1/0):");
        ok= keybord.nextInt();
        if (ok == 1) {
            this.plasmaTv = true;
        }
        else{
            this.plasmaTv = false;
        }
        System.out.println("Shower(1/0)(daca e 1 inseamna ca nu exista cada, daca e 0 e altfel):");
        ok = keybord.nextInt();
        if(ok == 1){
            this.bathroom_shower = true;
            this.Bathroom_bathtub = false;
        }
        else {
            this.bathroom_shower = false;
            this.Bathroom_bathtub = true;
        }
        System.out.println("Fridge Beverages(1/0):");
        ok = keybord.nextInt();
        if(ok == 1)
        {
            this.fridge_beverege = true;
        }
        else
        {
            this.fridge_beverege = false;
        }
        System.out.println("AC(1/0):");
        ok = keybord.nextInt();
        if(ok==1)
        {
            this.ac = true;
        }
        else{
            this.ac = false;
        }

    }

    public void getRoomEquipment(){
        System.out.println("WI-FI:" + (wi_fi? "da" : "nu"));
        System.out.println("Plasma TV: " +(plasmaTv? "da":"nu"));
        if (bathroom_shower) {
            System.out.println("Shower: Da");
        } else {
            System.out.println("Cada: Da");
        }
        System.out.println("Fridge Beverages: " + (fridge_beverege? "Da" : "Nu"));
        System.out.println("AC: " + (ac?"Da":"Nu"));
    }
}
