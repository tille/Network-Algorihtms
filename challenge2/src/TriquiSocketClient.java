import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// @author emontoya

public class TriquiSocketClient {

  Socket s = null;
  DataInputStream dis = null;
  DataOutputStream dos = null;

  public TriquiSocketClient(String host, int port) {
    open(host,port);
  }

  private void open(String host, int port) {
    try {
      s = new Socket(host,port);
      dis = new DataInputStream(s.getInputStream());
      dos = new DataOutputStream(s.getOutputStream());
    } catch (UnknownHostException ex) {
      Logger.getLogger(TriquiSocketClient.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(TriquiSocketClient.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void close() {
    try {
      send("QUIT");
      s.close();
      s = null;
    } catch (IOException ex) {
      Logger.getLogger(TriquiSocketClient.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void send(String msg) {
    try {
      dos.writeUTF(msg);
    } catch (IOException ex) {
      Logger.getLogger(TriquiSocketClient.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public String recv(){
    String msg = null;
    try {
      msg = dis.readUTF();
    } catch (IOException ex) {
      Logger.getLogger(TriquiSocketClient.class.getName()).log(Level.SEVERE, null, ex);
    }
    return msg;
  } 
}
