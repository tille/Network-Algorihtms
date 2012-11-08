package AdCliente;

/**
 *
 * @author Usuario
 */

public class Main {

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectInterface().setVisible(true);
            }
        });
    }
}