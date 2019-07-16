/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * Varga Dániel (email: vargadaniel81@gmail.com)
 */
public class Koltseg {

    private int id;
    private String megnevezes;
    private int osszeg;
    private Date datum;
    private int kategoriaId;

    public Koltseg() {
    }

    public Koltseg(int id, String megnevezes, int osszeg, Date datum, int kategoriaId) {
        this.id = id;
        this.megnevezes = megnevezes;
        this.osszeg = osszeg;
        this.datum = datum;
        this.kategoriaId = kategoriaId;
    }

    public Koltseg(String megnevezes, int osszeg, Date datum, int kategoriaId) {
        this.megnevezes = megnevezes;
        this.osszeg = osszeg;
        this.datum = datum;
        this.kategoriaId = kategoriaId;
    }

    public int getKategoriaId() {
        return kategoriaId;
    }

    public void setKategoriaId(int kategoriaId) {
        this.kategoriaId = kategoriaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Koltseg{" + "id=" + id + ", megnevezes=" + megnevezes + ", osszeg=" + osszeg + ", datum=" + datum + ", kategoriaId=" + kategoriaId + '}';
    }

}
