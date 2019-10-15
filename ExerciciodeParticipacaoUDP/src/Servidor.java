
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor {
    public static DatagramSocket dgSocket;
    public static DatagramPacket dgPacket;
    
    public static InetAddress endereco;
    
    public static void main(String[] args) {
            
        try {
            while (true) {
                dgSocket = new DatagramSocket(10000);
                System.out.println("Aguardando requisições...");
                // instanciar thread
                new ThreadServidor(dgSocket).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
