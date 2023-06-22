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
import java.util.Date;

/**
 *
 * @author Danica
 */
public class Racun extends AbstractDomainObject implements Serializable {

    private Long racunID;
    private Date datumVreme;
    private double ukupanIznos;
    private Kupac kupac;
    private Administrator administrator;
    private ArrayList<StavkaRacuna> stavkeRacuna;

    public Racun() {
    }

    public Racun(Long racunID, Date datumVreme, double ukupanIznos, Kupac kupac, Administrator administrator, ArrayList<StavkaRacuna> stavkeRacuna) {
        this.racunID = racunID;
        this.datumVreme = datumVreme;
        this.ukupanIznos = ukupanIznos;
        this.kupac = kupac;
        this.administrator = administrator;
        this.stavkeRacuna = stavkeRacuna;
    }

    @Override
    public String nazivTabele() {
        return " racun ";
    }

    @Override
    public String alijas() {
        return " r ";
    }

    @Override
    public String join() {
        return " JOIN kupac k USING (kupacID) "
                + "JOIN administrator a USING (administratorid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            
            Kupac k = new Kupac(rs.getLong("KupacID"),
                    rs.getString("ImeKupca"), rs.getString("PrezimeKupca"),
                    rs.getString("Email"), rs.getString("BrojTelefona"));
            
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));
            
            Racun r = new Racun(rs.getLong("RacunID"), 
                    rs.getTimestamp("DatumVreme"), rs.getDouble("UkupanIznos"), k, a, null);

            lista.add(r);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (DatumVreme, UkupanIznos, KupacID, AdministratorID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " RacunID = " + racunID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new java.sql.Date(datumVreme.getTime()) + "', "
                + ukupanIznos + ", "
                + kupac.getKupacID() + ", " + administrator.getAdministratorID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String getByID() {
        return "";
    }

    public Long getRacunID() {
        return racunID;
    }

    public void setRacunID(Long racunID) {
        this.racunID = racunID;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public ArrayList<StavkaRacuna> getStavkeRacuna() {
        return stavkeRacuna;
    }

    public void setStavkeRacuna(ArrayList<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }

    
}
