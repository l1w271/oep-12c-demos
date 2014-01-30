
package com.oracle.oep.admin.event;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IndustryQuery complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IndustryQuery">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="industryID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="totalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndustryQuery", propOrder = { "industryID", "totalAmount" })
public class IndustryQuery {

    @XmlElement(required = true)
    protected String industryID;
    @XmlElement(required = true)
    protected BigDecimal totalAmount;

    /**
     * Gets the value of the industryID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIndustryID() {
        return industryID;
    }

    /**
     * Sets the value of the industryID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIndustryID(String value) {
        this.industryID = value;
    }

    /**
     * Gets the value of the totalAmount property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setTotalAmount(BigDecimal value) {
        this.totalAmount = value;
    }

}
