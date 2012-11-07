package Logic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Calc2 {
    
    public float Substract(float nmFirst, float nmSecond) {
        return nmFirst - nmSecond;
    }
    
    public float Divide(float nmFirst, float nmSecond) {
        return (nmSecond == 0 ? Float.NaN : nmFirst / nmSecond);
    }
}
