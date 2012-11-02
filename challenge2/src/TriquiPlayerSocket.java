import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// @author emontoya

public class TriquiPlayerSocket {

  TriquiSocketClient triqui = null;

  public TriquiPlayerSocket(String host, int port) {
    triqui = new TriquiSocketClient(host,port);
  }

  private String keyboard() {
    String cadena = null;
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    try {
      cadena = br.readLine();
    } catch (IOException ex) {
      Logger.getLogger(TriquiPlayerSocket.class.getName()).log(Level.SEVERE, null, ex);
    }
    return cadena;
  }

  private void play() {
    //triqui.send("START,");
    String winner = "N";
    int contplay = 0;
    boolean valid = false;
    String player = null;
    String board = null;

    while (winner.equals("N") && contplay < 9) {
      System.out.println("Espere su turno.");
      
      //boolean begin = Boolean.parseBoolean(triqui.recv());
      //if(!begin) continue;
      
      triqui.send("PLAYER,");
      player = triqui.recv();

      if(Boolean.parseBoolean(player)){ 
        triqui.send("TESTWINNER,");
        winner = triqui.recv();
        break;
      }

      triqui.send("BOARD,");
      board = triqui.recv();

      System.out.println("\nTURNO: " + player);
      System.out.println(board);

      do {
        System.out.print("Posicion = ");
        String pos = keyboard();
        System.out.println(pos);

        triqui.send("PLAY,"+pos);
        valid = Boolean.parseBoolean(triqui.recv());
        
        triqui.send("BOARD,");
        board = triqui.recv();
        System.out.println(board);

        if (!valid) System.out.println(">>> Jugada invalida");
      }while (!valid);

      triqui.send("TESTWINNER,");
      winner = triqui.recv();
      contplay++;
    }

    triqui.send("BOARD,");
    board = triqui.recv();

    System.out.println(board);
    System.out.println("Ganador: " + winner);
    //System.out.print("Continuar? (y/n) = ");
  }

  public void run() {
    String input = "y";
    while (input.equals("y")) {
      play();
      //input = keyboard();
      System.out.print("Gracias por Jugar.");
      input = "n";
    }
  }

  public static void main(String[] args) {
    TriquiPlayerSocket t = new TriquiPlayerSocket(args[0], Integer.parseInt(args[1]));
    t.run();
  }
}