/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.sastojak;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Sastojak;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author Danica
 */
public class SODeleteSastojak extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Sastojak)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Sastojak!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        DBBroker.getInstance().delete(ado);
    }

}
