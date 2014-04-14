//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.14-hudson-jaxb-ri-2.1-60--SNAPSHOT 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.01.30 at 01:00:44 PM MST 
//


package dsp.dell_services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ArrayOfLogisticDetailDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfLogisticDetailDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PartStatus" type="{dsp:dell.services.dispatch}PartStatusDataType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TransportStatus" type="{dsp:dell.services.dispatch}TransportStatusDataType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DlpDefferalDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfLogisticDetailDataType", propOrder = {
    "partStatuses",
    "transportStatuses",
    "dlpDefferalDate"
})
public class ArrayOfLogisticDetailDataType {

    @XmlElement(name = "PartStatus")
    protected List<PartStatusDataType> partStatuses;
    @XmlElement(name = "TransportStatus")
    protected List<TransportStatusDataType> transportStatuses;
    @XmlElement(name = "DlpDefferalDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dlpDefferalDate;

    /**
     * Gets the value of the partStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartStatusDataType }
     * 
     * 
     */
    public List<PartStatusDataType> getPartStatuses() {
        if (partStatuses == null) {
            partStatuses = new ArrayList<PartStatusDataType>();
        }
        return this.partStatuses;
    }

    /**
     * Gets the value of the transportStatuses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transportStatuses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransportStatuses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportStatusDataType }
     * 
     * 
     */
    public List<TransportStatusDataType> getTransportStatuses() {
        if (transportStatuses == null) {
            transportStatuses = new ArrayList<TransportStatusDataType>();
        }
        return this.transportStatuses;
    }

    /**
     * Gets the value of the dlpDefferalDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDlpDefferalDate() {
        return dlpDefferalDate;
    }

    /**
     * Sets the value of the dlpDefferalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDlpDefferalDate(XMLGregorianCalendar value) {
        this.dlpDefferalDate = value;
    }

}
