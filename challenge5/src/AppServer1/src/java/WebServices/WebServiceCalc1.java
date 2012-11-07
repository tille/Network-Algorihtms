/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Logic.Calc1;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "WebServiceCalc1")
public class WebServiceCalc1 {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Add")
    public float Add(@WebParam(name = "nmFirst") float nmFirst, @WebParam(name = "nmSecond") float nmSecond) {
        Calc1 c = new Calc1();
        return c.Add(nmFirst, nmSecond);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Multiply")
    public float Multiply(@WebParam(name = "nmFirst") float nmFirst, @WebParam(name = "nmSecond") float nmSecond) {
        Calc1 c = new Calc1();
        return c.Multiply(nmFirst, nmSecond);
    }
}
