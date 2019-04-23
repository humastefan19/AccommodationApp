package accommodation.DAO;

import accommodation.domain.RoomEquipment;
import accommodation.domain.RoomType;

import java.io.Serializable;

public class RoomTypeDao implements Serializable {

    private static final long serialVersionUID = 1237;
    RoomType[] camere;

    public RoomTypeDao(){
        camere = new RoomType[1];
    }

    public void addRoom (String name, float m2, int nr_pers, int nr_camera, int etaj, boolean free, RoomEquipment dotari){

           RoomType newRoom = new RoomType(name, m2, nr_pers, nr_camera, etaj, free, dotari);
           int ok=0;
           for(int i=0;i<camere.length;i++)
           {
               if(camere[i] == null)
               {
                   camere[i] = newRoom;
                   ok=1;
                   break;
               }
           }
           if(ok==0)
           {
               RoomType aux[] = new RoomType[camere.length+1];
               for(int i=0;i<camere.length;i++)
               {
                   aux[i] = new RoomType();
                   aux[i] = camere[i];
               }
               aux[camere.length] = newRoom;
               camere = aux;
           }
        }


    public void removeRoom(int nr_camera)
    {
        for(int i=0; i<camere.length;i++)
        {
            if(camere[i].getNr_camera() == nr_camera)
            {
                camere[i] = null;
            }
        }
    }

    public void afisareCamere(){

        for(int i=0;i<camere.length;i++)
        {
            if(camere[i].isFree()!=false)
            System.out.println(camere[i].getName());
            System.out.print("Suprafata: ");
            System.out.println(camere[i].getM2());
            System.out.print("Numar persoane: ");
            System.out.println(camere[i].getNr_pers());
            System.out.print("Etaj:");
            System.out.println(camere[i].getEtaj());
            camere[i].getDotari().getRoomEquipment();
        }
    }

    public RoomType getCamera(int i) {
        return camere[i];
    }
}
