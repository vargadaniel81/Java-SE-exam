/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Varga Dániel (email: vargadaniel81@gmail.com)
 */
public class DBModel implements IModel {

    private Connection conn;
    private PreparedStatement getAllKategoriaPstmt;
    private PreparedStatement getAllKoltsegPstmt;
    private PreparedStatement getAllKoltsegKategoriaPstmt;
    private PreparedStatement addKoltsegPstmt;
    private PreparedStatement removeKoltsegPstmt;

    public DBModel(Connection conn) throws SQLException {
        this.conn = conn;
        getAllKategoriaPstmt = conn.prepareStatement("SELECT * FROM kategoria");
        getAllKoltsegPstmt = conn.prepareStatement("SELECT * FROM koltseg");
        getAllKoltsegKategoriaPstmt = conn.prepareStatement("SELECT * FROM koltseg WHERE kategoriaid=?");
        addKoltsegPstmt = conn.prepareStatement("INSERT INTO koltseg (megnevezes,osszeg,datum,kategoriaid) VALUES (?,?,?,?)");
        removeKoltsegPstmt = conn.prepareStatement("DELETE from koltseg WHERE id=?");
    }

    @Override
    public List<Koltseg> getAllKoltseg(Kategoria k) throws SQLException {
        getAllKoltsegKategoriaPstmt.setInt(1, k.getId());

        ResultSet rs = getAllKoltsegKategoriaPstmt.executeQuery();
        List<Koltseg> koltsegList = new ArrayList<>();
        while (rs.next()) {
            Koltseg kolt = new Koltseg(
                    rs.getInt("id"),
                    rs.getString("megnevezes"),
                    rs.getInt("osszeg"),
                    rs.getDate("datum"),
                    rs.getInt("kategoriaid"));
            koltsegList.add(kolt);
        }
        rs.close();
        return koltsegList;
    }

    @Override
    public List<Kategoria> getAllKategoria() throws SQLException {
        ResultSet rs = getAllKategoriaPstmt.executeQuery();
        List<Kategoria> katList = new ArrayList<>();
        while (rs.next()) {
            Kategoria k = new Kategoria(
                    rs.getInt("id"),
                    rs.getString("megnevezes"));
            katList.add(k);
        }
        rs.close();
        return katList;
    }

    @Override
    public List<Koltseg> getAllKoltseg() throws SQLException {
        ResultSet rs = getAllKoltsegPstmt.executeQuery();
        List<Koltseg> koltsegList = new ArrayList<>();
        while (rs.next()) {
            Koltseg k = new Koltseg(
                    rs.getInt("id"),
                    rs.getString("megnevezes"),
                    rs.getInt("osszeg"),
                    rs.getDate("datum"),
                    rs.getInt("kategoriaid"));
            koltsegList.add(k);
        }
        rs.close();
        return koltsegList;
    }

    @Override
    public int addKoltseg(Koltseg k) throws SQLException {
        addKoltsegPstmt.setString(1, k.getMegnevezes());
        addKoltsegPstmt.setInt(2, k.getOsszeg());
        addKoltsegPstmt.setDate(3, new java.sql.Date(k.getDatum().getTime()));
        addKoltsegPstmt.setInt(4, k.getKategoriaId());
        return addKoltsegPstmt.executeUpdate();
    }

    @Override
    public int removeKoltseg(Koltseg k) throws SQLException {
        removeKoltsegPstmt.setInt(1, k.getId());
        return removeKoltsegPstmt.executeUpdate();
    }

    @Override
    public Map<Integer, Kategoria> getKategoriaMap() throws SQLException {
        List<Kategoria> katList = getAllKategoria();
        Map<Integer, Kategoria> katMap = new HashMap<>();
        for (Kategoria k : katList) {
            katMap.put(k.getId(), k);
        }
        return katMap;
    }

    @Override
    public int addKategoria(Kategoria k) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int removeKategoria(Kategoria k) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateKategoria(Kategoria k) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateKoltseg(Koltseg k) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
