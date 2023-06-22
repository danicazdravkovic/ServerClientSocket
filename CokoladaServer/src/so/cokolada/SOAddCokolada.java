/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.cokolada;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Cokolada;
import domain.Sastojak;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Danica
 */
public class SOAddCokolada extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Cokolada)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Cokolada!");
        }
        
        Cokolada c = (Cokolada) ado;
        
        if(c.getSastojci().size() < 3){
            throw new Exception("Cokolada mora imati barem 3 sastojka!");
        }
        
        ArrayList<Cokolada> cokolade = (ArrayList<Cokolada>)(ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (Cokolada cokolada : cokolade) {
            if(c.getNazivCokolade().equals(cokolada.getNazivCokolade())
                    && c.getProizvodjac().getProizvodjacID().equals(cokolada.getProizvodjac().getProizvodjacID())){
                throw new Exception("Taj proizvodjac vec ima cokoladu sa tim nazivom!");
            }
        }
        
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        PreparedStatement ps = DBBroker.getInstance().insert(ado);
        
   
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long cokoladaID = tableKeys.getLong(1);
        
        Cokolada c = (Cokolada) ado;
        c.setCokoladaID(cokoladaID);
        
        
        for (Sastojak sastojak : c.getSastojci()) {
            sastojak.setCokolada(c);
            DBBroker.getInstance().insert(sastojak);
        }
        
    }

}
