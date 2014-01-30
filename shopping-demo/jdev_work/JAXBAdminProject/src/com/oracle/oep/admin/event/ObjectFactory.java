
package com.oracle.oep.admin.event;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.oracle.oep.admin.event package.
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

    private final static QName _JMXAdminRequest_QNAME = new QName("http://xmlns.oracle.com/ns/oep", "JMXAdminRequest");
    private final static QName _SMSQuery_QNAME = new QName("http://xmlns.oracle.com/ns/oep", "SMSQuery");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.oep.admin.event
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JMXAdminRequest }
     *
     */
    public JMXAdminRequest createJMXAdminRequest() {
        return new JMXAdminRequest();
    }

    /**
     * Create an instance of {@link SMSQuery }
     *
     */
    public SMSQuery createSMSQuery() {
        return new SMSQuery();
    }

    /**
     * Create an instance of {@link CEPConnection }
     *
     */
    public CEPConnection createCEPConnection() {
        return new CEPConnection();
    }

    /**
     * Create an instance of {@link IndustryQuery }
     *
     */
    public IndustryQuery createIndustryQuery() {
        return new IndustryQuery();
    }

    /**
     * Create an instance of {@link CEPQuery }
     *
     */
    public CEPQuery createCEPQuery() {
        return new CEPQuery();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JMXAdminRequest }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/ns/oep", name = "JMXAdminRequest")
    public JAXBElement<JMXAdminRequest> createJMXAdminRequest(JMXAdminRequest value) {
        return new JAXBElement<JMXAdminRequest>(_JMXAdminRequest_QNAME, JMXAdminRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SMSQuery }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/ns/oep", name = "SMSQuery")
    public JAXBElement<SMSQuery> createSMSQuery(SMSQuery value) {
        return new JAXBElement<SMSQuery>(_SMSQuery_QNAME, SMSQuery.class, null, value);
    }

}
