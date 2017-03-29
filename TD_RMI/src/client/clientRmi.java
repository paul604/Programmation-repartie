package client;

import interfaces.IRank;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by paul on 13/03/17.
 */
public class clientRmi {

    public static void main(String ... arg) throws NotBoundException {
        try {
	
	    //conection au serveur et recupération de l'objet
            Remote monStub = Naming.lookup("rmi://" + InetAddress.getLocalHost().getHostAddress() + ":1099" + "/rank");
            System.out.println("ok");//debug

            if (monStub instanceof IRank) {
                IRank rank = ((IRank) monStub);

                //get de toute les equipe.
                List<String> equip = rank.getEquipe();

                Scanner sc = new Scanner(System.in);
                String choix;

		//menu
                System.out.print("les equipes dispo: ");
                equip.forEach(e -> System.out.print(e+", "));
                System.out.println("\ntout les equipes => all");
                System.out.println("pour fin => fin");

                do {//main loop
                    choix = sc.nextLine();

                    if(choix.equalsIgnoreCase("all")){
                        System.out.println(rank.getAllScors());

                    }else if (!choix.equalsIgnoreCase("fin")){
                        System.out.println(rank.getScor(choix.toUpperCase()));

                    }

                }while (!choix.equalsIgnoreCase("fin"));
            }
        } catch (NotBoundException ee) {
            ee.printStackTrace();
            throw new NotBoundException("Pbm de liaison" );
        } catch (RemoteException | UnknownHostException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
