/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import domain.StavkaRacuna;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Danica
 */
public class TableModelStavkeRacuna extends AbstractTableModel {

    private ArrayList<StavkaRacuna> lista;
    private String[] kolone = {"Rb", "Cokolada", "Kolicina", "Cena"};
    int rb = 0;

    public TableModelStavkeRacuna() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        StavkaRacuna sr = lista.get(row);

        switch (column) {
            case 0:
                return sr.getRbStavke();
            case 1:
                return sr.getCokolada().getNazivCokolade();
            case 2:
                return sr.getKolicinaStavke() + "kg";
            case 3:
                return sr.getCenaStavke() + "din";

            default:
                return null;
        }
    }

    public void dodajStavku(StavkaRacuna sr) {

        for (StavkaRacuna stavkaRacuna : lista) {
            if (sr.getCokolada().getProizvodjac().getProizvodjacID()
                    .equals(stavkaRacuna.getCokolada().getProizvodjac().getProizvodjacID())
                    && sr.getCokolada().getNazivCokolade()
                            .equals(stavkaRacuna.getCokolada().getNazivCokolade())) 
            
            
            {
                stavkaRacuna.setKolicinaStavke(stavkaRacuna.getKolicinaStavke() + sr.getKolicinaStavke());
                
                stavkaRacuna.setCenaStavke(stavkaRacuna.getCenaStavke() + sr.getCenaStavke());
                fireTableDataChanged();
                return;
            }
        }

        rb = lista.size();

        sr.setRbStavke(++rb);
        lista.add(sr);
        fireTableDataChanged();

    }

    public void obrisiStavku(int row) {

        lista.remove(row);

        rb = 0;
        
        for (StavkaRacuna stavkaRacuna : lista) {
            stavkaRacuna.setRbStavke(++rb);
        }

        fireTableDataChanged();

    }

    public ArrayList<StavkaRacuna> getLista() {
        return lista;
    }

    public StavkaRacuna getStavka(int row) {
        return lista.get(row);
    }

}
