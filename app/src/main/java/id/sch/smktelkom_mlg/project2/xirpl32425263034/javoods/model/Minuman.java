package id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.model;

import java.io.Serializable;

/**
 * Created by Prasetya on 7/4/2017.
 */

public class Minuman implements Serializable {
    public String nama;
    public String alat;
    public String step;
    public String foto;

    public Minuman(String nama, String alat, String step, String foto) {
        this.nama = nama;
        this.alat = alat;
        this.step = step;
        this.foto = foto;
    }

}
