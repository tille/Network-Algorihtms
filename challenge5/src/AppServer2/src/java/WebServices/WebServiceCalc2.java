/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Logic.Calc2;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "WebServiceCalc2")
public class WebServiceCalc2 {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Substract")
    public float Substract(@WebParam(name = "nmFirst") float nmFirst, @WebParam(name = "nmSecond") float nmSecond) {
        Calc2 c = new Calc2();
        return c.Substract(nmFirst, nmSecond);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Divide")
    public float Divide(@WebParam(name = "nmFirst") float nmFirst, @WebParam(name = "nmSecond") float nmSecond) {
        Calc2 c = new Calc2();
        return c.Divide(nmFirst, nmSecond);
    }
}
