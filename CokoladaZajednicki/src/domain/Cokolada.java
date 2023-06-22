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
public class Cokolada extends AbstractDomainObject implements Serializable {

    private Long cokoladaID;
    private String nazivCokolade;
    private String opis;
    private double cenaPoKG;
    private VrstaCokolade vrstaCokolade;
    private Proizvodjac proizvodjac;
    private ArrayList<Sastojak> sastojci;

    public Cokolada(Long cokoladaID, String nazivCokolade, String opis, double cenaPoKG, VrstaCokolade vrstaCokolade, Proizvodjac proizvodjac, ArrayList<Sastojak> sastojci) {
        this.cokoladaID = cokoladaID;
        this.nazivCokolade = nazivCokolade;
        this.opis = opis;
        this.cenaPoKG = cenaPoKG;
        this.vrstaCokolade = vrstaCokolade;
        this.proizvodjac = proizvodjac;
        this.sastojci = sastojci;
    }

    public Cokolada() {
    }

    @Override
    public String toString() {
        return nazivCokolade + " (Proizvodjac: " + proizvodjac.getNazivProizvodjaca()
                + ", CenaPoKG: " + cenaPoKG + "din)";
    }

    @Override
    public String nazivTabele() {
        return " cokolada ";
    }

    @Override
    public String alijas() {
        return " c ";
    }

    @Override
    public String join() {
        return " JOIN vrstaCokolade vc USING (vrstaCokoladeID) "
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

            lista.add(c);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (NazivCokolade, Opis, CenaPoKG, VrstaCokoladeID, ProizvodjacID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " CokoladaID = " + cokoladaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivCokolade + "', '" + opis + "', "
                + cenaPoKG + ", " + vrstaCokolade.getVrstaCokoladeID() 
                + ", " + proizvodjac.getProizvodjacID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " nazivCokolade = '" + nazivCokolade + "', opis = '" + opis + "', "
                + "cenaPoKG = " + cenaPoKG;
    }

    @Override
    public String getByID() {
        if(vrstaCokolade == null){
            return "";
        }
        return " WHERE VC.VRSTACOKOLADEID = " + vrstaCokolade.getVrstaCokoladeID();
    }

    public Long getCokoladaID() {
        return cokoladaID;
    }

    public void setCokoladaID(Long cokoladaID) {
        this.cokoladaID = cokoladaID;
    }

    public String getNazivCokolade() {
        return nazivCokolade;
    }

    public void setNazivCokolade(String nazivCokolade) {
        this.nazivCokolade = nazivCokolade;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCenaPoKG() {
        return cenaPoKG;
    }

    public void setCenaPoKG(double cenaPoKG) {
        this.cenaPoKG = cenaPoKG;
    }

    public VrstaCokolade getVrstaCokolade() {
        return vrstaCokolade;
    }

    public void setVrstaCokolade(VrstaCokolade vrstaCokolade) {
        this.vrstaCokolade = vrstaCokolade;
    }

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public ArrayList<Sastojak> getSastojci() {
        return sastojci;
    }

    public void setSastojci(ArrayList<Sastojak> sastojci) {
        this.sastojci = sastojci;
    }

}
