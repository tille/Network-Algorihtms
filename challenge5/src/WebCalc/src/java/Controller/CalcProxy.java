package Controller;

import WebServices1.WebServiceCalc1;
import WebServices1.WebServiceCalc1_Service;
import WebServices2.WebServiceCalc2;
import WebServices2.WebServiceCalc2_Service;
import Logic.XMLProcessing.XMLReadingSingleton;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HORUS793
 */
public class CalcProxy {
    ArrayList<String> urlList;
    WebServiceCalc1_Service s1;
    WebServiceCalc1 c1;
    XMLReadingSingleton xmlRead;
    WebServiceCalc2_Service s2 = null;
    WebServiceCalc2 c2;
    
    public CalcProxy () {
        try {
            // TO-DO Control with if.
            xmlRead = XMLReadingSingleton.getInstance();
            urlList = xmlRead.getURLs("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\WebCalc\\CalcServer.xml");
            s1 = new WebServiceCalc1_Service(new URL(urlList.get(0)));
            s2 = new WebServiceCalc2_Service(new URL(urlList.get(1)));
            c1 = s1.getWebServiceCalc1Port(); //proxy
            c2 = s2.getWebServiceCalc2Port(); //proxy
        } catch (MalformedURLException ex) {
            Logger.getLogger(CalcProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public float Add(float nmFirst, float nmSecond){
        return c1.add(nmFirst, nmSecond);
    }
    
    public float Multiply(float nmFirst, float nmSecond){
        return c1.multiply(nmFirst, nmSecond);
    }
    
    public float Substract(float nmFirst, float nmSecond){
        return c2.substract(nmFirst, nmSecond);
    }
    
    public float Divide(float nmFirst, float nmSecond){
        return c2.divide(nmFirst, nmSecond);
    }
}
