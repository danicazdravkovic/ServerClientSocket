/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Cokolada;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Danica
 */
public class TableModelCokolade extends AbstractTableModel implements Runnable {

    private ArrayList<Cokolada> lista;
    private String[] kolone = {"ID", "Proizvodjac", "Vrsta cokolade", "Naziv", "Cena"};
    private String parametar = "";

    public TableModelCokolade() {
        try {
            lista = ClientController.getInstance().getAllCokolada(null);
        } catch (Exception ex) {
            Logger.getLogger(TableModelCokolade.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        Cokolada c = lista.get(row);

        switch (column) {
            case 0:
                return c.getCokoladaID();
            case 1:
                return c.getProizvodjac();
            case 2:
                return c.getVrstaCokolade();
            case 3:
                return c.getNazivCokolade();
            case 4:
                return c.getCenaPoKG();

            default:
                return null;
        }
    }

    public Cokolada getSelectedCokolada(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(5000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelCokolade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllCokolada(null);
            if (!parametar.equals("")) {
                ArrayList<Cokolada> novaLista = new ArrayList<>();
                for (Cokolada c : lista) {
                    if (c.getNazivCokolade().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(c);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
