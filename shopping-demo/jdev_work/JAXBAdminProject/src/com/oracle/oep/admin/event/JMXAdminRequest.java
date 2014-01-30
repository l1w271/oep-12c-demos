
package com.oracle.oep.admin.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JMXAdminRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="JMXAdminRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Connection" type="{http://xmlns.oracle.com/ns/oep}CEPConnection"/>
 *         &lt;element name="Query" type="{http://xmlns.oracle.com/ns/oep}CEPQuery"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JMXAdminRequest", propOrder = { "requestType", "connection", "query" })
public class JMXAdminRequest {

    @XmlElement(name = "RequestType", required = true)
    protected String requestType;
    @XmlElement(name = "Connection", required = true)
    protected CEPConnection connection;
    @XmlElement(name = "Query", required = true)
    protected CEPQuery query;

    /**
     * Gets the value of the requestType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * Sets the value of the requestType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRequestType(String value) {
        this.requestType = value;
    }

    /**
     * Gets the value of the connection property.
     *
     * @return
     *     possible object is
     *     {@link CEPConnection }
     *
     */
    public CEPConnection getConnection() {
        return connection;
    }

    /**
     * Sets the value of the connection property.
     *
     * @param value
     *     allowed object is
     *     {@link CEPConnection }
     *
     */
    public void setConnection(CEPConnection value) {
        this.connection = value;
    }

    /**
     * Gets the value of the query property.
     *
     * @return
     *     possible object is
     *     {@link CEPQuery }
     *
     */
    public CEPQuery getQuery() {
        return query;
    }

    /**
     * Sets the value of the query property.
     *
     * @param value
     *     allowed object is
     *     {@link CEPQuery }
     *
     */
    public void setQuery(CEPQuery value) {
        this.query = value;
    }

}
