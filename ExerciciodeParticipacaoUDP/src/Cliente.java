
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Cliente {
    public static DatagramSocket dgSocket;    
    public static DatagramPacket dgPacket;
    
    public static InetAddress endereco;
    public static DataInputStream entrada;
    public static DataOutputStream saida;
    
    public static void main(String[] args) {
        try {
            // solicitar conexao
            while (true) {
                dgSocket = new DatagramSocket();
                endereco = InetAddress.getByName("localhost");
                
                byte[] msg = new byte[128];
                String frase = JOptionPane.showInputDialog("Digite uma frase");
                msg = frase.getBytes();
                
                
                dgPacket =  new DatagramPacket(msg, msg.length, endereco, 10000);

                dgSocket.send(dgPacket);  

                System.out.println("Mensagem enviada...");

                msg = new byte[128];

                dgPacket = new DatagramPacket(msg, msg.length);

                dgSocket.receive(dgPacket);

                String fraseMaiuscula = new String(dgPacket.getData());
                System.out.println(fraseMaiuscula);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
