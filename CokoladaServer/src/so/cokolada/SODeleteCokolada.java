/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.cokolada;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Cokolada;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author Danica
 */
public class SODeleteCokolada extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Cokolada)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Cokolada!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        // zbog ON DELETE CASCADE u bazi, ovom naredbom se obrise cokolada
        // i svi njeni slabi objekti odnosno SASTOJCI
        DBBroker.getInstance().delete(ado);
    }

}
