/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * Varga Dániel (email: vargadaniel81@gmail.com)
 */
public class Kategoria {

    private int id;
    private String megnevezes;

    public Kategoria() {
    }

    public Kategoria(int id, String megnevezes) {
        this.id = id;
        this.megnevezes = megnevezes;
    }

    public Kategoria(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    @Override
    public String toString() {
        return megnevezes;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
