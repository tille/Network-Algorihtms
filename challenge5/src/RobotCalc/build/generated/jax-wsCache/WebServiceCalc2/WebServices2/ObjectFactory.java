
package WebServices2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the WebServices2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SubstractResponse_QNAME = new QName("http://WebServices/", "SubstractResponse");
    private final static QName _Substract_QNAME = new QName("http://WebServices/", "Substract");
    private final static QName _DivideResponse_QNAME = new QName("http://WebServices/", "DivideResponse");
    private final static QName _Divide_QNAME = new QName("http://WebServices/", "Divide");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: WebServices2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SubstractResponse }
     * 
     */
    public SubstractResponse createSubstractResponse() {
        return new SubstractResponse();
    }

    /**
     * Create an instance of {@link Substract }
     * 
     */
    public Substract createSubstract() {
        return new Substract();
    }

    /**
     * Create an instance of {@link DivideResponse }
     * 
     */
    public DivideResponse createDivideResponse() {
        return new DivideResponse();
    }

    /**
     * Create an instance of {@link Divide }
     * 
     */
    public Divide createDivide() {
        return new Divide();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubstractResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "SubstractResponse")
    public JAXBElement<SubstractResponse> createSubstractResponse(SubstractResponse value) {
        return new JAXBElement<SubstractResponse>(_SubstractResponse_QNAME, SubstractResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Substract }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "Substract")
    public JAXBElement<Substract> createSubstract(Substract value) {
        return new JAXBElement<Substract>(_Substract_QNAME, Substract.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DivideResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "DivideResponse")
    public JAXBElement<DivideResponse> createDivideResponse(DivideResponse value) {
        return new JAXBElement<DivideResponse>(_DivideResponse_QNAME, DivideResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Divide }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WebServices/", name = "Divide")
    public JAXBElement<Divide> createDivide(Divide value) {
        return new JAXBElement<Divide>(_Divide_QNAME, Divide.class, null, value);
    }

}
