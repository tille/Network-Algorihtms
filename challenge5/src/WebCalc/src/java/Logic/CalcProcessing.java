/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Controller.CalcProxy;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class CalcProcessing {
    
    public static float ExecuteOperation(float nmFirst, float nmSecond, String strOperator) {
        float result;
        CalcProxy proxy = new CalcProxy();
        char opch = strOperator.charAt(0);
        switch(opch){
            case '+':
                result = proxy.Add(nmFirst,nmSecond);
                break;
            case '-':
                result = proxy.Substract(nmFirst, nmSecond);
                break;
            case '*':
                result = proxy.Multiply(nmFirst, nmSecond);
                break;
            case '/':
                result = proxy.Divide(nmFirst, nmSecond);
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
    
    public static void PrintResultHTML(float result, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalcServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Result: " + result + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }
}
