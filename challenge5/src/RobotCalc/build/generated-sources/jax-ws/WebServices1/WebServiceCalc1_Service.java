
package WebServices1;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-2b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebServiceCalc1", targetNamespace = "http://WebServices/", wsdlLocation = "http://localhost:8080/AppServer1/WebServiceCalc1?wsdl")
public class WebServiceCalc1_Service
    extends Service
{

    private final static URL WEBSERVICECALC1_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICECALC1_EXCEPTION;
    private final static QName WEBSERVICECALC1_QNAME = new QName("http://WebServices/", "WebServiceCalc1");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/AppServer1/WebServiceCalc1?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICECALC1_WSDL_LOCATION = url;
        WEBSERVICECALC1_EXCEPTION = e;
    }

    public WebServiceCalc1_Service() {
        super(__getWsdlLocation(), WEBSERVICECALC1_QNAME);
    }

    public WebServiceCalc1_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICECALC1_QNAME, features);
    }

    public WebServiceCalc1_Service(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICECALC1_QNAME);
    }

    public WebServiceCalc1_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICECALC1_QNAME, features);
    }

    public WebServiceCalc1_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServiceCalc1_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServiceCalc1
     */
    @WebEndpoint(name = "WebServiceCalc1Port")
    public WebServiceCalc1 getWebServiceCalc1Port() {
        return super.getPort(new QName("http://WebServices/", "WebServiceCalc1Port"), WebServiceCalc1.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServiceCalc1
     */
    @WebEndpoint(name = "WebServiceCalc1Port")
    public WebServiceCalc1 getWebServiceCalc1Port(WebServiceFeature... features) {
        return super.getPort(new QName("http://WebServices/", "WebServiceCalc1Port"), WebServiceCalc1.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICECALC1_EXCEPTION!= null) {
            throw WEBSERVICECALC1_EXCEPTION;
        }
        return WEBSERVICECALC1_WSDL_LOCATION;
    }

}
