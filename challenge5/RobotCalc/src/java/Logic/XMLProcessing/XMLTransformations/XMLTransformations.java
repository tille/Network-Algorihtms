package Logic.XMLProcessing.XMLTransformations;

import Logic.XMLProcessing.CalcDTO.WebServices;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author HORUS793
 */
public class XMLTransformations {
    
    private String msgerror;
    
    public String getMsgerror() {
        return msgerror;
    }

    public void setMsgerror(String msgerror) {
        this.msgerror = msgerror;
    }

    public WebServices getWebServices(String strXML){
        if(strXML != null && !strXML.equals("")) {
            return SetUpXML.LoadXML(strXML);
        }
        return null;
    }
    
    public Document getDOMWebServices(WebServices webServices) {
        Document tmpX;
        DocumentBuilder builder;
        String s = SetUpXML.getXML(webServices);
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (javax.xml.parsers.ParserConfigurationException error) {
            msgerror = "Error crando factory String2DOM " + error.getMessage();
            return null;
        }
        try {
            tmpX = builder.parse(new ByteArrayInputStream(s.getBytes()));
        } catch (org.xml.sax.SAXException error) {
            msgerror = "Error parseo SAX String2DOM " + error.getMessage();
            return null;
        } catch (IOException error) {
            msgerror = "Error generando Bytes String2DOM " + error.getMessage();
            return null;
        }
        return tmpX;
    }
}
