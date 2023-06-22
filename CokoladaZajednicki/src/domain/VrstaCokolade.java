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
public class VrstaCokolade extends AbstractDomainObject implements Serializable {
    
    private Long vrstaCokoladeID;
    private String nazivVrsteCokolade;

    public VrstaCokolade(Long vrstaCokoladeID, String nazivVrsteCokolade) {
        this.vrstaCokoladeID = vrstaCokoladeID;
        this.nazivVrsteCokolade = nazivVrsteCokolade;
    }

    public VrstaCokolade() {
    }

    @Override
    public String toString() {
        return nazivVrsteCokolade;
    }
    
    @Override
    public String nazivTabele() {
        return " vrstaCokolade ";
    }

    @Override
    public String alijas() {
        return " vc ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            VrstaCokolade vc = new VrstaCokolade(rs.getLong("VrstaCokoladeID"),
                    rs.getString("NazivVrsteCokolade"));

            lista.add(vc);
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
        return " VrstaCokoladeID = " + vrstaCokoladeID;
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

    public Long getVrstaCokoladeID() {
        return vrstaCokoladeID;
    }

    public void setVrstaCokoladeID(Long vrstaCokoladeID) {
        this.vrstaCokoladeID = vrstaCokoladeID;
    }

    public String getNazivVrsteCokolade() {
        return nazivVrsteCokolade;
    }

    public void setNazivVrsteCokolade(String nazivVrsteCokolade) {
        this.nazivVrsteCokolade = nazivVrsteCokolade;
    }
}
