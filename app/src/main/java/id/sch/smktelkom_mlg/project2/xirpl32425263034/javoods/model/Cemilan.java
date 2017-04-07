package id.sch.smktelkom_mlg.project2.xirpl32425263034.javoods.model;

import java.io.Serializable;

/**
 * Created by Prasetya on 7/4/2017.
 */

public class Cemilan implements Serializable {
    public String nama;
    public String step;
    public String foto;

    public Cemilan(String nama, String step, String foto) {
        this.nama = nama;

        this.step = step;
        this.foto = foto;
    }

}
