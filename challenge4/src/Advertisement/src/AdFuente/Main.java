package AdFuente;

/**
 *
 * @author Usuario 
 */

public class Main { 
    
    public Main() {
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SenderInterface().setVisible(true);
            }
        });
    }
}