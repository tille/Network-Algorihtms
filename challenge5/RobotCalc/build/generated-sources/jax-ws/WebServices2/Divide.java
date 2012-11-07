
package WebServices2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Divide complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Divide">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nmFirst" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="nmSecond" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Divide", propOrder = {
    "nmFirst",
    "nmSecond"
})
public class Divide {

    protected float nmFirst;
    protected float nmSecond;

    /**
     * Obtiene el valor de la propiedad nmFirst.
     * 
     */
    public float getNmFirst() {
        return nmFirst;
    }

    /**
     * Define el valor de la propiedad nmFirst.
     * 
     */
    public void setNmFirst(float value) {
        this.nmFirst = value;
    }

    /**
     * Obtiene el valor de la propiedad nmSecond.
     * 
     */
    public float getNmSecond() {
        return nmSecond;
    }

    /**
     * Define el valor de la propiedad nmSecond.
     * 
     */
    public void setNmSecond(float value) {
        this.nmSecond = value;
    }

}
