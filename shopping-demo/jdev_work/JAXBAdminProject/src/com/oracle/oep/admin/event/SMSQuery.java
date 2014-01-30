
package com.oracle.oep.admin.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SMSQuery complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SMSQuery">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="request" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subscriberType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="paymentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tariff" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subsegment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="weeklySMS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="monthlySMS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="refillAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SMSQuery", propOrder = {
         "requestID", "request", "subscriberType", "paymentType", "tariff", "subsegment", "weeklySMS", "monthlySMS",
         "refillAmount"
    })
public class SMSQuery {

    @XmlElement(required = true)
    protected String requestID;
    @XmlElement(required = true)
    protected String request;
    @XmlElement(required = true)
    protected String subscriberType;
    @XmlElement(required = true)
    protected String paymentType;
    @XmlElement(required = true)
    protected String tariff;
    @XmlElement(required = true)
    protected String subsegment;
    @XmlElement(required = true)
    protected String weeklySMS;
    @XmlElement(required = true)
    protected String monthlySMS;
    @XmlElement(required = true)
    protected String refillAmount;

    /**
     * Gets the value of the requestID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRequestID() {
        return requestID;
    }

    /**
     * Sets the value of the requestID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRequestID(String value) {
        this.requestID = value;
    }

    /**
     * Gets the value of the request property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRequest(String value) {
        this.request = value;
    }

    /**
     * Gets the value of the subscriberType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSubscriberType() {
        return subscriberType;
    }

    /**
     * Sets the value of the subscriberType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSubscriberType(String value) {
        this.subscriberType = value;
    }

    /**
     * Gets the value of the paymentType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the value of the paymentType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaymentType(String value) {
        this.paymentType = value;
    }

    /**
     * Gets the value of the tariff property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTariff() {
        return tariff;
    }

    /**
     * Sets the value of the tariff property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTariff(String value) {
        this.tariff = value;
    }

    /**
     * Gets the value of the subsegment property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSubsegment() {
        return subsegment;
    }

    /**
     * Sets the value of the subsegment property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSubsegment(String value) {
        this.subsegment = value;
    }

    /**
     * Gets the value of the weeklySMS property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWeeklySMS() {
        return weeklySMS;
    }

    /**
     * Sets the value of the weeklySMS property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWeeklySMS(String value) {
        this.weeklySMS = value;
    }

    /**
     * Gets the value of the monthlySMS property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMonthlySMS() {
        return monthlySMS;
    }

    /**
     * Sets the value of the monthlySMS property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMonthlySMS(String value) {
        this.monthlySMS = value;
    }

    /**
     * Gets the value of the refillAmount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRefillAmount() {
        return refillAmount;
    }

    /**
     * Sets the value of the refillAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRefillAmount(String value) {
        this.refillAmount = value;
    }

}
