package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by E155441H on 13/03/17.
 */
public interface IRank extends Remote {

    HashMap<String, Integer> getAllScors() throws RemoteException;

    int getScor(String name) throws RemoteException;

    List<String> getEquipe() throws RemoteException;
}
