import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Thread;

// @author emontoya

public class TriquiSocketServer extends Thread {

  Socket c = null, c1 = null;
  DataInputStream dis = null, dis2 = null;
  DataOutputStream dos = null, dos2 = null;
  TriquiGame triqui = null;
  String[] command = null; // variable donde recibe un comando con sus argumentos
  int player = 0, cont = 1;

  public TriquiSocketServer(Socket p1, Socket p2) {
    this.c = p1;
    this.c1 = p2;
    open();
    triqui = new TriquiGame();
    System.out.println("Nueva conexion...");
    triqui.Start();
  }

  public void run(){
    try {
      
      String response;
      //response = Boolean.toString(true);
      //sendResponse(response);
      
      String cmd = recvRequest();
      System.out.println("Comando: "+cmd);

      while (!cmd.equals("QUIT")) {

        //response = Boolean.toString(true);
        //sendResponse(response);

        boolean error = true;
        if (cmd.equals("PLAY")) {
          int pos = Integer.parseInt(command[1])-1;
          boolean res = triqui.Play(pos);
          response = Boolean.toString(res);
          sendResponse(response);
          error = false;
        }else if (cmd.equals("PLAYER")){
          response = (player==0)?"O":"X";
          if(triqui.TestWinner()!="N") response = Boolean.toString(true);;
          sendResponse(response);
          error = false;
        }else if (cmd.equals("BOARD")){
          response = triqui.Board();
          sendResponse(response);
          error = false;
          if(triqui.TestWinner()!="N") error = true;
        }else if (cmd.equals("TESTWINNER")) {
          response = triqui.TestWinner();
          if(response!="N") error = false;
          sendResponse(response);
        }

        if(error){
          //response = Boolean.toString(false);
          //sendResponse(response);
          player = (player==0)?1:0;
        }
        cmd = recvRequest();
        System.out.println("Comando: "+cmd);
      }
      c.close();
      c = null;
              
    } catch (IOException ex) {
      Logger.getLogger(TriquiSocketServer.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private String recvRequest() {
    String msg = null;
    try {
      if(player==0) msg = dis.readUTF();
      else msg = dis2.readUTF();
    } catch (IOException ex) {
      Logger.getLogger(TriquiSocketServer.class.getName()).log(Level.SEVERE, null, ex);
    }
    command = msg.split(",");
    return command[0];
  }

  private void sendResponse(String msg) {
    try {
      if(player==0) dos.writeUTF(msg);
      else dos2.writeUTF(msg);
      //player = (player==0)?1:0;
    } catch (IOException ex) {
      Logger.getLogger(TriquiSocketServer.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void open() {
    try {
      dis = new DataInputStream(c.getInputStream());
      dos = new DataOutputStream(c.getOutputStream());
      dis2 = new DataInputStream(c1.getInputStream());
      dos2 = new DataOutputStream(c1.getOutputStream());
    } catch (UnknownHostException ex) {
      Logger.getLogger(TriquiSocketClient.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(TriquiSocketClient.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
