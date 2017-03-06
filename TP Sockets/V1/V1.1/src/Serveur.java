import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by E155441H on 06/03/17.
 */
public class Serveur {

    public static void main(String ... args){

        ServerSocket socketserver; // socket in
        Socket socketduserveur; // socket interne

        try {
            socketserver = new ServerSocket(50007);
            System.out.println("Le serveur est à l'écoute du port " + socketserver.getLocalPort());

            socketduserveur = socketserver.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socketduserveur.getInputStream()));
            System.out.println(in.readLine()+"--");
            in.close();
            System.out.println("-----");


            socketserver.close();
            socketduserveur.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
