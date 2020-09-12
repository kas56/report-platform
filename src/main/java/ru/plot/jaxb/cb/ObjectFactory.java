
package ru.plot.jaxb.cb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.plot.jaxb.cb package. 
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

    private final static QName _ValCurs_QNAME = new QName("", "ValCurs");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.plot.jaxb.cb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValCursType }
     * 
     */
    public ValCursType createValCursType() {
        return new ValCursType();
    }

    /**
     * Create an instance of {@link ValuteType }
     * 
     */
    public ValuteType createValuteType() {
        return new ValuteType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValCursType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ValCurs")
    public JAXBElement<ValCursType> createValCurs(ValCursType value) {
        return new JAXBElement<ValCursType>(_ValCurs_QNAME, ValCursType.class, null, value);
    }

}
