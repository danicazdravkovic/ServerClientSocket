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
public class Sastojak extends AbstractDomainObject implements Serializable {

    private Cokolada cokolada;
    private int rbSastojka;
    private String nazivSastojka;

    public Sastojak(Cokolada cokolada, int rbSastojka, String nazivSastojka) {
        this.cokolada = cokolada;
        this.rbSastojka = rbSastojka;
        this.nazivSastojka = nazivSastojka;
    }

    @Override
    public String toString() {
        return nazivSastojka;
    }

    public Sastojak() {
    }

    @Override
    public String nazivTabele() {
        return " sastojak ";
    }

    @Override
    public String alijas() {
        return " s ";
    }

    @Override
    public String join() {
        return " JOIN cokolada c USING (cokoladaID) "
                + "JOIN vrstaCokolade vc USING (vrstaCokoladeID) "
                + "JOIN proizvodjac p USING (proizvodjacID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            VrstaCokolade vc = new VrstaCokolade(rs.getLong("VrstaCokoladeID"),
                    rs.getString("NazivVrsteCokolade"));

            Proizvodjac p = new Proizvodjac(rs.getLong("ProizvodjacID"),
                    rs.getString("NazivProizvodjaca"), rs.getString("Adresa"),
                    rs.getString("BrojTelefona"));

            Cokolada c = new Cokolada(rs.getLong("CokoladaID"),
                    rs.getString("NazivCokolade"), rs.getString("Opis"),
                    rs.getDouble("CenaPoKG"), vc, p, null);

            Sastojak s = new Sastojak(c, rs.getInt("RbSastojka"), rs.getString("NazivSastojka"));

            lista.add(s);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (CokoladaID, RbSastojka, NazivSastojka) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " CokoladaID = " + cokolada.getCokoladaID();
    }

    @Override
    public String vrednostiZaInsert() {
        return cokolada.getCokoladaID() + ", " + rbSastojka + ", "
                + "'" + nazivSastojka + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String getByID() {
        return " WHERE C.COKOLADAID = " + cokolada.getCokoladaID();
    }

    public Cokolada getCokolada() {
        return cokolada;
    }

    public void setCokolada(Cokolada cokolada) {
        this.cokolada = cokolada;
    }

    public int getRbSastojka() {
        return rbSastojka;
    }

    public void setRbSastojka(int rbSastojka) {
        this.rbSastojka = rbSastojka;
    }

    public String getNazivSastojka() {
        return nazivSastojka;
    }

    public void setNazivSastojka(String nazivSastojka) {
        this.nazivSastojka = nazivSastojka;
    }
}
