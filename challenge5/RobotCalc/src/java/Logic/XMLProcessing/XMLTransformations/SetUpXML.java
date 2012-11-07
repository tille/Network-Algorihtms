package Logic.XMLProcessing.XMLTransformations;

import Logic.XMLProcessing.CalcDTO.WebServices;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 *
 * @author HORUS793
 */
public class SetUpXML {
    //Replacer utilizado para evitar el doble underline
    final static XmlFriendlyNameCoder replacer = new XmlFriendlyNameCoder("", "_");
    public static String getXML(WebServices xmlWebServices) {
        String xml = null;
        XStream xStream = new XStream(new XppDriver() {
            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out, replacer) {
                    @Override
                    protected void writeText(QuickWriter writer, String text) {
//                        writer.write("<![CDATA[");
                        writer.write(text);
//                        writer.write("]]>");
                    }
                };
            }
        });
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer;
        xStream.processAnnotations(WebServices.class); 	
        //Se utiliza para quitar las referencias a objetos iguales dentro del xml
        xStream.setMode(XStream.NO_REFERENCES);
        try {
            writer = new OutputStreamWriter(outputStream, "ISO-8859-1");
            writer.write(getXmlHeader());
            xStream.toXML(xmlWebServices, writer);
            xml = outputStream.toString("ISO-8859-1");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Encoding incorrecto");
        } catch (IOException ex) {
            System.out.println("Problemas agregando el encabezado");
        }
        return xml;
    }
    
    public static WebServices LoadXML(String xml) {
        XStream xStream = LoadDriver();        
        xStream.processAnnotations(WebServices.class);
        return (WebServices) xStream.fromXML(xml);
    }
    
    private static XStream LoadDriver() {
        XStream xStream;
        xStream = new XStream(new DomDriver()) {
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new MapperWrapper(next) {
                    @Override
                    public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                        try {
                            return definedIn != Object.class || realClass(fieldName) != null;
                        } catch (CannotResolveClassException cnrce) {
                            System.out.println("Exception: " + cnrce);
                            return false;
                        }
                    }
                };
            }
        };
        return xStream;
    }
    
    private static String getXmlHeader() {
        return "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>";
    }
}
