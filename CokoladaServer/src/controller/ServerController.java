/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Administrator;
import domain.Cokolada;
import domain.Kupac;
import domain.Proizvodjac;
import domain.Racun;
import domain.Sastojak;
import domain.StavkaRacuna;
import domain.VrstaCokolade;
import java.util.ArrayList;
import so.AbstractSO;
import so.administrator.SOGetAllAdministrator;
import so.cokolada.SOAddCokolada;
import so.cokolada.SODeleteCokolada;
import so.cokolada.SOGetAllCokolada;
import so.cokolada.SOUpdateCokolada;
import so.kupac.SOAddKupac;
import so.kupac.SODeleteKupac;
import so.kupac.SOGetAllKupac;
import so.kupac.SOUpdateKupac;
import so.proizovdjac.SOGetAllProizvodjac;
import so.racun.SOAddRacun;
import so.racun.SOGetAllRacun;
import so.sastojak.SOAddSastojak;
import so.sastojak.SODeleteSastojak;
import so.sastojak.SOGetAllSastojak;
import so.stavkaRacuna.SOAddStavkaRacuna;
import so.stavkaRacuna.SOGetAllStavkaRacuna;
import so.vrstaCokolade.SOGetAllVrstaCokolade;

/**
 *
 * @author Danica
 */
public class ServerController {

    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public void addCokolada(Cokolada cokolada) throws Exception {
        AbstractSO aso = new SOAddCokolada();
        aso.templateExecute(cokolada);
    }
    
    public void addKupac(Kupac kupac) throws Exception {
        AbstractSO aso = new SOAddKupac();
        aso.templateExecute(kupac);
    }
    
    public void addRacun(Racun racun) throws Exception {
        AbstractSO aso = new SOAddRacun();
        aso.templateExecute(racun);
    }
    public void addSastojak(Sastojak sastojak) throws Exception {
        AbstractSO aso = new SOAddSastojak();
        aso.templateExecute(sastojak);
    }
    
    public void addStavkaRacuna(StavkaRacuna stavkaRacuna) throws Exception {
        AbstractSO aso = new SOAddStavkaRacuna();
        aso.templateExecute(stavkaRacuna);
    }

    public void deleteCokolada(Cokolada cokolada) throws Exception {
        AbstractSO aso = new SODeleteCokolada();
        aso.templateExecute(cokolada);
    }
    
    public void deleteKupac(Kupac kupac) throws Exception {
        AbstractSO aso = new SODeleteKupac();
        aso.templateExecute(kupac);
    }
    
    public void deleteSastojak(Sastojak sastojak) throws Exception {
        AbstractSO aso = new SODeleteSastojak();
        aso.templateExecute(sastojak);
    }

    public void updateCokolada(Cokolada cokolada) throws Exception {
        AbstractSO aso = new SOUpdateCokolada();
        aso.templateExecute(cokolada);
    }
    
    public void updateKupac(Kupac kupac) throws Exception {
        AbstractSO aso = new SOUpdateKupac();
        aso.templateExecute(kupac);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        SOGetAllAdministrator so = new SOGetAllAdministrator();
        so.templateExecute(new Administrator());
        return so.getLista();
    }
    
    public ArrayList<Cokolada> getAllCokolada(VrstaCokolade vc) throws Exception {
        SOGetAllCokolada so = new SOGetAllCokolada();
        
        Cokolada c = new Cokolada();
        c.setVrstaCokolade(vc);
        
        so.templateExecute(c);
        return so.getLista();
    }
    
    public ArrayList<Kupac> getAllKupac() throws Exception {
        SOGetAllKupac so = new SOGetAllKupac();
        so.templateExecute(new Kupac());
        return so.getLista();
    }
    
    public ArrayList<Proizvodjac> getAllProizvodjac() throws Exception {
        SOGetAllProizvodjac so = new SOGetAllProizvodjac();
        so.templateExecute(new Proizvodjac());
        return so.getLista();
    }
    
    public ArrayList<Racun> getAllRacun() throws Exception {
        SOGetAllRacun so = new SOGetAllRacun();
        so.templateExecute(new Racun());
        return so.getLista();
    }
    
    public ArrayList<Sastojak> getAllSastojak(Cokolada c) throws Exception {
        SOGetAllSastojak so = new SOGetAllSastojak();
        
        Sastojak s = new Sastojak();
        s.setCokolada(c);
        
        so.templateExecute(s);
        return so.getLista();
    }
    
    public ArrayList<StavkaRacuna> getAllStavkaRacuna() throws Exception {
        SOGetAllStavkaRacuna so = new SOGetAllStavkaRacuna();
        so.templateExecute(new StavkaRacuna());
        return so.getLista();
    }
    
    public ArrayList<VrstaCokolade> getAllVrstaCokolade() throws Exception {
        SOGetAllVrstaCokolade so = new SOGetAllVrstaCokolade();
        so.templateExecute(new VrstaCokolade());
        return so.getLista();
    }

}
