/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.XMLProcessing;

import Logic.XMLProcessing.CalcDTO.Params;
import Logic.XMLProcessing.CalcDTO.WebService;
import Logic.XMLProcessing.CalcDTO.WebServices;
import Logic.XMLProcessing.XMLTransformations.XMLOperations;
import Logic.XMLProcessing.XMLTransformations.XMLTransformations;
import java.util.List;
import org.w3c.dom.Document;

/**
 *
 * @author Usuario
 */
public class XMLOperationsSingleton {

    private static XMLOperationsSingleton instance = null;

    protected XMLOperationsSingleton() {
        // Exists only to defeat instantiation.
    }

    public static XMLOperationsSingleton getInstance() {
        if (instance == null) {
            instance = new XMLOperationsSingleton();
        }
        return instance;
    }

    public WebServices getWebServices(String strFileName) {
        XMLTransformations xmlTrans = new XMLTransformations();
        String strXML = XMLOperations.getStringFromDocument(XMLOperations.OpenXMLFile(strFileName));
        return xmlTrans.getWebServices(strXML);
    }

    public Document getDOMWebServices(WebServices webServices) {
        XMLTransformations xmlTrans = new XMLTransformations();
        return xmlTrans.getDOMWebServices(webServices);
    }
    
    public static void main(String[] args) {
        XMLOperationsSingleton xMLReadingSingleton = XMLOperationsSingleton.getInstance();
        WebServices ws = xMLReadingSingleton.getWebServices("calc.xml");
        List<WebService> webServices = ws.getWebServices();
        for (int i = 0; i < webServices.size(); i++) {
            WebService webService = webServices.get(i);
            System.out.println(String.format("url %d: %s", i, webService.getURL()));
            System.out.println(String.format("method %d: %s", i, webService.getMethod()));
            System.out.println(String.format("resultado %d: %s", i, webService.getResultado()));
            Params params = webService.getParams();
            System.out.println(String.format("p1: %s", params.getP1()));
            System.out.println(String.format("p2: %s", params.getP2()));
        }
    }
}
