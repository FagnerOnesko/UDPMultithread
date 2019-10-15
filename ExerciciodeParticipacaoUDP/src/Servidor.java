
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
        
            dgSocket = new DatagramSocket(10000);
        
            byte[] msg = new byte[128];
            
            dgPacket = new DatagramPacket(msg, msg.length);
            
            System.out.println("Servidor pronto...");
            
            dgSocket.receive(dgPacket);
            
            String texto = new String(dgPacket.getData());
            texto = texto.toUpperCase();
                
            endereco = dgPacket.getAddress();
            int porta = dgPacket.getPort();

            System.out.println("Porta = "+porta);                

            msg = new byte[128];                
            msg = texto.getBytes();

            dgPacket = new DatagramPacket(msg, msg.length, endereco, porta);                
            dgSocket.send(dgPacket);
               
            
        } catch(Exception e) {
            
        }
    }
}
