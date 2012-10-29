import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

public class TriquiServer {

  ServerSocket ss = null;
  Socket c = null, ant_c = null;
  int port = 0, ind = 0;

  public TriquiServer() {
    init(5555);
  }

  public TriquiServer(int port) {
    init(port);
  }

  private void init(int port) {
    try {
      this.port = port;
      ss = new ServerSocket(port);
    } catch (IOException ex) {
      Logger.getLogger(TriquiServer.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void run() {
    TriquiSocketServer tss = null;
    System.out.println("TriquiServer.run().listening..." + port);
    while (true) {
      try {
        c = ss.accept();
        TriquiSocketServer h = new TriquiSocketServer(c);
        Thread t1 = new Thread(h);
        t1.start();
        //c.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    TriquiServer ts = null;
    if (args.length < 1) ts = new TriquiServer();
    else ts = new TriquiServer(Integer.parseInt(args[0]));
    ts.run();
  }
}