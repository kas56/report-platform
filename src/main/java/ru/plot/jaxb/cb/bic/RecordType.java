
package ru.plot.jaxb.cb.bic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecordType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecordType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShortName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Bic" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RegNum" type="{}RegNumType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DU" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordType", propOrder = {
    "shortName",
    "bic",
    "regNum"
})
public class RecordType {

    @XmlElement(name = "ShortName", required = true)
    protected String shortName;
    @XmlElement(name = "Bic", required = true)
    protected String bic;
    @XmlElement(name = "RegNum", required = true)
    protected RegNumType regNum;
    @XmlAttribute(name = "ID")
    protected String id;
    @XmlAttribute(name = "DU")
    protected String du;

    /**
     * Gets the value of the shortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets the value of the shortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortName(String value) {
        this.shortName = value;
    }

    /**
     * Gets the value of the bic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBic() {
        return bic;
    }

    /**
     * Sets the value of the bic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBic(String value) {
        this.bic = value;
    }

    /**
     * Gets the value of the regNum property.
     * 
     * @return
     *     possible object is
     *     {@link RegNumType }
     *     
     */
    public RegNumType getRegNum() {
        return regNum;
    }

    /**
     * Sets the value of the regNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegNumType }
     *     
     */
    public void setRegNum(RegNumType value) {
        this.regNum = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the du property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDU() {
        return du;
    }

    /**
     * Sets the value of the du property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDU(String value) {
        this.du = value;
    }

}
