package serveur;

import interfaces.IRank;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by E155441H on 13/03/17.
 */
public class Rank extends UnicastRemoteObject implements IRank {

    private HashMap<String, Integer> scors=null;

    public Rank() throws RemoteException {
        super();
        this.scors = new HashMap<>();
        this.scors.put("E1",0);
        this.scors.put("E2",10);
        this.scors.put("E3",5);
    }

    @Override
    public HashMap<String, Integer> getAllScors() {
        return this.scors;
    }

    @Override
    public int getScor(String name) {
        return this.scors.get(name);
    }

    @Override
    public List<String> getEquipe(){
        return this.scors.keySet().stream().collect(Collectors.toList());
    }
}
