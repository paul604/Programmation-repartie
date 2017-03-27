package serveur;

import interfaces.IRank;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


/**
 * Created by paul on 13/03/17.
 */
public class testSRVTPrmi {

    public static void main(String ... arg)throws RemoteException, MalformedURLException, UnknownHostException {
        try {
            LocateRegistry.createRegistry(1099);
            IRank rank = new Rank(); // creation de l'obj
            Naming.rebind("rmi://" + InetAddress.getLocalHost().getHostAddress() + ":1099" + "/rank", rank);
            System.out.println("obj rank ok");
        }catch (MalformedURLException ee){
            throw new MalformedURLException("Pbm de url");
        } catch (RemoteException | UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
