
package com.oracle.oep.admin.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CEPQuery complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CEPQuery">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="application" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="queryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="queryString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CEPQuery", propOrder = { "application", "processor", "queryName", "queryString" })
public class CEPQuery {

    @XmlElement(required = true)
    protected String application;
    @XmlElement(required = true)
    protected String processor;
    @XmlElement(required = true)
    protected String queryName;
    @XmlElement(required = true)
    protected String queryString;

    /**
     * Gets the value of the application property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getApplication() {
        return application;
    }

    /**
     * Sets the value of the application property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setApplication(String value) {
        this.application = value;
    }

    /**
     * Gets the value of the processor property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProcessor() {
        return processor;
    }

    /**
     * Sets the value of the processor property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProcessor(String value) {
        this.processor = value;
    }

    /**
     * Gets the value of the queryName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getQueryName() {
        return queryName;
    }

    /**
     * Sets the value of the queryName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setQueryName(String value) {
        this.queryName = value;
    }

    /**
     * Gets the value of the queryString property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getQueryString() {
        return queryString;
    }

    /**
     * Sets the value of the queryString property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setQueryString(String value) {
        this.queryString = value;
    }

}
