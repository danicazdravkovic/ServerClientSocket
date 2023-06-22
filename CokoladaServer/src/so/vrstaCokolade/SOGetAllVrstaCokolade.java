/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vrstaCokolade;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.VrstaCokolade;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Danica
 */
public class SOGetAllVrstaCokolade extends AbstractSO {

    private ArrayList<VrstaCokolade> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof VrstaCokolade)) {
            throw new Exception("Prosledjeni objekat nije instanca klase VrstaCokolade!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> vrsteCokolada = DBBroker.getInstance().select(ado);
        lista = (ArrayList<VrstaCokolade>) (ArrayList<?>) vrsteCokolada;
    }

    public ArrayList<VrstaCokolade> getLista() {
        return lista;
    }

}
