
package clienthmac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author tuf68306
 */
public class ClientHMAC {
    
    private static Socket socket;
    //Server
    public static void main(String[] args) throws IOException {
        int port = 6086;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server starting");
        
        while(true){
            //Read from client
            socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String clientMsg = br.readLine();
            System.out.println("Message from Client: " + clientMsg);
            
            String returnMsg = "Message recieved: " + clientMsg;
            //Send return to client
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(returnMsg);
            System.out.println("Message sent to Client");
            bw.flush();
            socket.close();
        }
    }
    
}
