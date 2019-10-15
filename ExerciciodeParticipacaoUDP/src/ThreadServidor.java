
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Socket;


public class ThreadServidor  extends Thread{
    DatagramSocket dps;
    DataInputStream entrada;
    DataOutputStream saida;
    
    public ThreadServidor(DatagramSocket dgSocket) {
        dps = dgSocket;
    }

    public void run() {
        try {
            System.out.println("Executando thread...");

            //entrada = new DataInputStream(dps.getInputStream());
            String dadosUsuario = entrada.readUTF();

            dadosUsuario = dadosUsuario.toUpperCase();

            //saida = new DataOutputStream(cnx.getOutputStream());
            saida.writeUTF(dadosUsuario);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
