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
public class Proizvodjac extends AbstractDomainObject implements Serializable {
    
    private Long proizvodjacID;
    private String nazivProizvodjaca;
    private String adresa;
    private String brojTelefona;

    public Proizvodjac() {
    }

    public Proizvodjac(Long proizvodjacID, String nazivProizvodjaca, String adresa, String brojTelefona) {
        this.proizvodjacID = proizvodjacID;
        this.nazivProizvodjaca = nazivProizvodjaca;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String toString() {
        return nazivProizvodjaca;
    }
    
    @Override
    public String nazivTabele() {
        return " proizvodjac ";
    }

    @Override
    public String alijas() {
        return " p ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Proizvodjac p = new Proizvodjac(rs.getLong("ProizvodjacID"),
                    rs.getString("NazivProizvodjaca"), rs.getString("Adresa"),
                    rs.getString("BrojTelefona"));

            lista.add(p);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " ProizvodjacID = " + proizvodjacID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String getByID() {
        return "";
    }

    public Long getProizvodjacID() {
        return proizvodjacID;
    }

    public void setProizvodjacID(Long proizvodjacID) {
        this.proizvodjacID = proizvodjacID;
    }

    public String getNazivProizvodjaca() {
        return nazivProizvodjaca;
    }

    public void setNazivProizvodjaca(String nazivProizvodjaca) {
        this.nazivProizvodjaca = nazivProizvodjaca;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }
}
