package Logic.XMLProcessing;

import java.util.ArrayList;

/**
 *
 * @author HORUS793
 */
public class XMLReadingSingleton {

    private static XMLReadingSingleton instance = null;

    protected XMLReadingSingleton() {
        // Exists only to defeat instantiation.
    }

    public static XMLReadingSingleton getInstance() {
        if (instance == null) {
            instance = new XMLReadingSingleton();
        }
        return instance;
    }
    
    public ArrayList<String> getURLs(String strFileName) {
        XMLOperations xmlOps = new XMLOperations();
        return xmlOps.getURLsFromFile(strFileName);
    }
}
