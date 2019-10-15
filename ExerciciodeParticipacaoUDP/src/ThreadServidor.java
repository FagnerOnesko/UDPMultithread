
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;


public class ThreadServidor  extends Thread{
    DatagramSocket dps;
    
    public ThreadServidor(DatagramSocket dgSocket) {
        dps = dgSocket;
    }

    public void run() {
        try {
            System.out.println("Executando thread...");

            byte[] msg = new byte[128];
            //entrada = new DataInputStream(dps.getInputStream());
            String texto = new String(Servidor.dgPacket.getData());
            texto = texto.toUpperCase();
                
            Servidor.endereco = Servidor.dgPacket.getAddress();
            int porta = Servidor.dgPacket.getPort();

            System.out.println("Porta = "+porta);                

            msg = new byte[128];                
            msg = texto.getBytes();

            Servidor.dgPacket = new DatagramPacket(msg, msg.length, Servidor.endereco, porta);                
            Servidor.dgSocket.send(Servidor.dgPacket);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
