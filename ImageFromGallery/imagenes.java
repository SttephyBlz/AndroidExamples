package com.example.jjsingh.abonapp.asd;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Sttephy on 04/03/2017.
 */

public class imagenes  extends RealmObject {

    int id;

    String imagen;

    public imagenes() {
        this.id = 0;
        this.imagen = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
