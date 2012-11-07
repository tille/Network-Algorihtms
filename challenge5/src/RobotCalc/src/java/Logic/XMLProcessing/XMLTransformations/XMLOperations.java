package Logic.XMLProcessing.XMLTransformations;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Usuario
 */
public class XMLOperations {

    public static Document OpenXMLFile(String strFileName) {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        Document doc = null;
        try {
            docBuilder = docBuilderFactory.newDocumentBuilder();
            doc = docBuilder.parse(new File(strFileName));
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        // normalize text representation
        doc.getDocumentElement().normalize();
        return doc;
    }

    public static void WriteXMLFile(String filename, Document doc) {
        // Prepare the DOM document for writing
        Source source = new DOMSource(doc);
        // Prepare the output file
        File file = new File(filename);
        Result result = new StreamResult(file);
        // Write the DOM document to the file
        Transformer xformer;
        try {
            xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XMLOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getStringFromDocument(org.w3c.dom.Document doc) {
        TransformerFactory tf = TransformerFactory.newInstance();
        StringWriter writer = new StringWriter();
        Transformer transformer;        
        try {
            transformer = tf.newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(SetUpXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(SetUpXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return writer.getBuffer().toString().replaceAll("\n|\r", "");
    }
}
