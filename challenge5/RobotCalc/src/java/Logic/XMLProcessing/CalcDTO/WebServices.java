/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.XMLProcessing.CalcDTO;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.List;

/**
 *
 * @author HORUS793
 */
@XStreamAlias("webservices")
public class WebServices {
    @XStreamImplicit List<WebService> webServices;
    
    public List<WebService> getWebServices() {
        return webServices;
    }

    public void setWebServices(List<WebService> webServices) {
        this.webServices = webServices;
    }
}
