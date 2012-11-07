package Logic.XMLProcessing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author HORUS793
 */
public class XMLOperations {

    public Document OpenXMLFile(String filename) {
        Document doc = null;
        SAXBuilder builder = new SAXBuilder(false);
        try {
            doc = builder.build(filename);
        } catch (JDOMException ex) {
            Logger.getLogger(XMLOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc;
    }
    
    public ArrayList<String> getURLsFromFile(String filename) {
        ArrayList<String> result = new ArrayList<String>();
        Document doc = OpenXMLFile(filename);
        Element raiz = doc.getRootElement();
        System.out.println("raiz=" + raiz.getName());
        List wsList = raiz.getChildren();
        for (int i = 0; i < wsList.size(); i++) {
            Element element = (Element) wsList.get(i);
            result.add(element.getText());
        }
        return result;
    }
}
