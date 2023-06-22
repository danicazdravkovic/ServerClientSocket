/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.proizovdjac;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Proizvodjac;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Danica
 */
public class SOGetAllProizvodjac extends AbstractSO {

    private ArrayList<Proizvodjac> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Proizvodjac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Proizvodjac!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> proizvodjaci = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Proizvodjac>) (ArrayList<?>) proizvodjaci;
    }

    public ArrayList<Proizvodjac> getLista() {
        return lista;
    }

}
