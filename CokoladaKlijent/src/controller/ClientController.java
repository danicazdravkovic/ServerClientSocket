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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Danica
 */
public class ClientController {

    private static ClientController instance;

    public ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        return (Administrator) sendRequest(Operation.LOGIN, administrator);
    }

    public void addCokolada(Cokolada cokolada) throws Exception {
        sendRequest(Operation.ADD_COKOLADA, cokolada);
    }
    
    public void addKupac(Kupac kupac) throws Exception {
        sendRequest(Operation.ADD_KUPAC, kupac);
    }
    
    public void addSastojak(Sastojak sastojak) throws Exception {
        sendRequest(Operation.ADD_SASTOJAK, sastojak);
    }
    
    public void addRacun(Racun racun) throws Exception {
        sendRequest(Operation.ADD_RACUN, racun);
    }
    
    public void addStavkaRacuna(StavkaRacuna stavkaRacuna) throws Exception {
        sendRequest(Operation.ADD_STAVKA_RACUNA, stavkaRacuna);
    }

    public void deleteCokolada(Cokolada cokolada) throws Exception {
        sendRequest(Operation.DELETE_COKOLADA, cokolada);
    }
    
    public void deleteKupac(Kupac kupac) throws Exception {
        sendRequest(Operation.DELETE_KUPAC, kupac);
    }
    
    public void deleteSastojak(Sastojak sastojak) throws Exception {
        sendRequest(Operation.DELETE_SASTOJAK, sastojak);
    }

    public void updateCokolada(Cokolada cokolada) throws Exception {
        sendRequest(Operation.UPDATE_COKOLADA, cokolada);
    }
    
    public void updateKupac(Kupac kupac) throws Exception {
        sendRequest(Operation.UPDATE_KUPAC, kupac);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        return (ArrayList<Administrator>) sendRequest(Operation.GET_ALL_ADMINISTRATOR, null);
    }
    
    public ArrayList<Cokolada> getAllCokolada(VrstaCokolade vc) throws Exception {
        return (ArrayList<Cokolada>) sendRequest(Operation.GET_ALL_COKOLADA, vc);
    }
    
    public ArrayList<Kupac> getAllKupac() throws Exception {
        return (ArrayList<Kupac>) sendRequest(Operation.GET_ALL_KUPAC, null);
    }
    
    public ArrayList<Proizvodjac> getAllProizvodjac() throws Exception {
        return (ArrayList<Proizvodjac>) sendRequest(Operation.GET_ALL_PROIZVODJAC, null);
    }
    
    public ArrayList<Racun> getAllRacun() throws Exception {
        return (ArrayList<Racun>) sendRequest(Operation.GET_ALL_RACUN, null);
    }
    
    public ArrayList<Sastojak> getAllSastojak(Cokolada c) throws Exception {
        return (ArrayList<Sastojak>) sendRequest(Operation.GET_ALL_SASTOJAK, c);
    }
    
    public ArrayList<StavkaRacuna> getAllStavkaRacuna() throws Exception {
        return (ArrayList<StavkaRacuna>) sendRequest(Operation.GET_ALL_STAVKA_RACUNA, null);
    }
    
    public ArrayList<VrstaCokolade> getAllVrstaCokolade() throws Exception {
        return (ArrayList<VrstaCokolade>) sendRequest(Operation.GET_ALL_VRSTA_COKOLADE, null);
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Request req = new Request(operation, data);
        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(req);
        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response res = (Response) in.readObject();
        if (res.getResponseStatus().equals(ResponseStatus.Error)) {
            throw res.getError();
        } else {
            return res.getData();
        }
    }
}
