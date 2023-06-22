/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Danica
 */
public class Kupac extends AbstractDomainObject implements Serializable {
    
    private Long kupacID;
    private String imeKupca;
    private String prezimeKupca;
    private String email;
    private String brojTelefona;

    public Kupac(Long kupacID, String imeKupca, String prezimeKupca, String email, String brojTelefona) {
        this.kupacID = kupacID;
        this.imeKupca = imeKupca;
        this.prezimeKupca = prezimeKupca;
        this.email = email;
        this.brojTelefona = brojTelefona;
    }

    public Kupac() {
    }

    @Override
    public String toString() {
        return imeKupca + " " + prezimeKupca;
    }
    
    @Override
    public String nazivTabele() {
        return " kupac ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Kupac k = new Kupac(rs.getLong("KupacID"),
                    rs.getString("ImeKupca"), rs.getString("PrezimeKupca"),
                    rs.getString("Email"), rs.getString("BrojTelefona"));

            lista.add(k);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (ImeKupca, PrezimeKupca, Email, BrojTelefona) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " KupacID = " + kupacID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + imeKupca + "', '" + prezimeKupca + "', "
                + "'" + email + "', '" + brojTelefona + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "email = '" + email + "', brojTelefona = '" + brojTelefona + "' ";
    }

    @Override
    public String getByID() {
        return "";
    }

    public Long getKupacID() {
        return kupacID;
    }

    public void setKupacID(Long kupacID) {
        this.kupacID = kupacID;
    }

    public String getImeKupca() {
        return imeKupca;
    }

    public void setImeKupca(String imeKupca) {
        this.imeKupca = imeKupca;
    }

    public String getPrezimeKupca() {
        return prezimeKupca;
    }

    public void setPrezimeKupca(String prezimeKupca) {
        this.prezimeKupca = prezimeKupca;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }
}
