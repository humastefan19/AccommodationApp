package accommodation.domain;

import java.io.Serializable;

public class RoomType implements Serializable {

    private static final long serialVersionUID = 1238;
    private String name;
    private float m2;
    private int nr_pers;
    private int nr_camera;
    private int etaj;
    private boolean free;
    private RoomEquipment dotari;


    public RoomType(String name, float m2, int nr_pers, int nr_camera, int etaj, boolean free, RoomEquipment dotari) {
        this.name = name;
        this.m2 = m2;
        this.nr_pers = nr_pers;
        this.nr_camera = nr_camera;
        this.etaj = etaj;
        this.free = free;
        this.dotari = dotari;
    }

    public RoomType() {
        this.name = "nu";
        this.m2 = 0;
        this.nr_pers = 0;
        this.free = true;
        this.dotari = new RoomEquipment();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getM2() {
        return m2;
    }

    public void setM2(float m2) {
        this.m2 = m2;
    }

    public int getNr_pers() {
        return nr_pers;
    }

    public void setNr_pers(int nr_pers) {
        this.nr_pers = nr_pers;
    }

    public int getNr_camera() {
        return nr_camera;
    }

    public void setNr_camera(int nr_camera) {
        this.nr_camera = nr_camera;
    }

    public int getEtaj() {
        return etaj;
    }

    public void setEtaj(int etaj) {
        this.etaj = etaj;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public RoomEquipment getDotari() {
        return dotari;
    }

    public void setDotari(RoomEquipment dotari) {
        this.dotari = dotari;
    }
}
