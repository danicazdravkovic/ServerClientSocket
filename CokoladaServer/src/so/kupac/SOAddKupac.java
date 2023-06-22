/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kupac;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Kupac;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Danica
 */
public class SOAddKupac extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Kupac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Kupac!");
        }
        
        Kupac k = (Kupac) ado;
        
        ArrayList<Kupac> kupci = (ArrayList<Kupac>)(ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (Kupac kupac : kupci) {
            if(k.getEmail().equals(kupac.getEmail())){
                throw new Exception("Vec postoji kupac sa tim emailom!");
            }
            if(k.getBrojTelefona().equals(kupac.getBrojTelefona())){
                throw new Exception("Vec postoji kupac sa tim brojem telefona!");
            }
        }
        
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().insert(ado);
    }

}
