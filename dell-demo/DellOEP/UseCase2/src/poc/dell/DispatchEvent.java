//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.14-hudson-jaxb-ri-2.1-60--SNAPSHOT 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.01.31 at 11:02:50 AM MST 
//


package poc.dell;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DispatchEventType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DispatchEventType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dispatchId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceHours" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispatchEventType", propOrder = {
    "dispatchId",
    "serviceHours",
    "serviceLevel",
    "serviceTag",
    "statusCode"
})
@XmlRootElement(name = "DispatchEvent")
public class DispatchEvent implements java.io.Serializable {

    protected String dispatchId;
    protected String serviceHours;
    protected String serviceLevel;
    protected String serviceTag;
    protected String statusCode;

    /**
     * Gets the value of the dispatchId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispatchId() {
        return dispatchId;
    }

    /**
     * Sets the value of the dispatchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispatchId(String value) {
        this.dispatchId = value;
    }

    /**
     * Gets the value of the serviceHours property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceHours() {
        return serviceHours;
    }

    /**
     * Sets the value of the serviceHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceHours(String value) {
        this.serviceHours = value;
    }

    /**
     * Gets the value of the serviceLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceLevel() {
        return serviceLevel;
    }

    /**
     * Sets the value of the serviceLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceLevel(String value) {
        this.serviceLevel = value;
    }

    /**
     * Gets the value of the serviceTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceTag() {
        return serviceTag;
    }

    /**
     * Sets the value of the serviceTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceTag(String value) {
        this.serviceTag = value;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

	@Override
	public String toString() {
		return "DispatchEvent [dispatchId=" + dispatchId + ", serviceHours="
				+ serviceHours + ", serviceLevel=" + serviceLevel
				+ ", serviceTag=" + serviceTag + ", statusCode=" + statusCode
				+ "]";
	}

}
