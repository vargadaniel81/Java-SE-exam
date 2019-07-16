/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * Varga Dániel (email: vargadaniel81@gmail.com)
 */
public interface IModel {
    List<Kategoria> getAllKategoria() throws SQLException;
    Map<Integer,Kategoria> getKategoriaMap() throws SQLException;
    int addKategoria(Kategoria k) throws SQLException;
    int removeKategoria(Kategoria k) throws SQLException;
    int updateKategoria(Kategoria k) throws SQLException;
    
    List<Koltseg> getAllKoltseg (Kategoria k) throws SQLException;
    List<Koltseg> getAllKoltseg() throws SQLException;
    int addKoltseg(Koltseg k) throws SQLException;
    int removeKoltseg(Koltseg k) throws SQLException;
    int updateKoltseg(Koltseg k) throws SQLException;
    
}
