
package ru.plot.jaxb.rosatom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Contract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Contract">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contractType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contractCreateDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="contractStartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="contractEndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="contractPercent" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="conractCurrency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contractBalance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contract", namespace = "urn:rusatom:report:balance:v1.0", propOrder = {
    "contractType",
    "contractCreateDate",
    "contractStartDate",
    "contractEndDate",
    "contractPercent",
    "conractCurrency",
    "contractBalance"
})
public class Contract {

    @XmlElement(required = true)
    protected String contractType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar contractCreateDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar contractStartDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar contractEndDate;
    protected double contractPercent;
    @XmlElement(required = true)
    protected String conractCurrency;
    protected double contractBalance;

    /**
     * Gets the value of the contractType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractType() {
        return contractType;
    }

    /**
     * Sets the value of the contractType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractType(String value) {
        this.contractType = value;
    }

    /**
     * Gets the value of the contractCreateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getContractCreateDate() {
        return contractCreateDate;
    }

    /**
     * Sets the value of the contractCreateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContractCreateDate(XMLGregorianCalendar value) {
        this.contractCreateDate = value;
    }

    /**
     * Gets the value of the contractStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getContractStartDate() {
        return contractStartDate;
    }

    /**
     * Sets the value of the contractStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContractStartDate(XMLGregorianCalendar value) {
        this.contractStartDate = value;
    }

    /**
     * Gets the value of the contractEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getContractEndDate() {
        return contractEndDate;
    }

    /**
     * Sets the value of the contractEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setContractEndDate(XMLGregorianCalendar value) {
        this.contractEndDate = value;
    }

    /**
     * Gets the value of the contractPercent property.
     * 
     */
    public double getContractPercent() {
        return contractPercent;
    }

    /**
     * Sets the value of the contractPercent property.
     * 
     */
    public void setContractPercent(double value) {
        this.contractPercent = value;
    }

    /**
     * Gets the value of the conractCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConractCurrency() {
        return conractCurrency;
    }

    /**
     * Sets the value of the conractCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConractCurrency(String value) {
        this.conractCurrency = value;
    }

    /**
     * Gets the value of the contractBalance property.
     * 
     */
    public double getContractBalance() {
        return contractBalance;
    }

    /**
     * Sets the value of the contractBalance property.
     * 
     */
    public void setContractBalance(double value) {
        this.contractBalance = value;
    }

}
