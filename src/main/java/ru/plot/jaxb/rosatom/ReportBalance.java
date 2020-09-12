
package ru.plot.jaxb.rosatom;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ReportBalance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportBalance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="onDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="compilerReport" type="{urn:rusatom:report:balance:v1.0}CompilerReport"/>
 *         &lt;element name="responsible" type="{urn:rusatom:report:balance:v1.0}Responsible"/>
 *         &lt;element name="organizations">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="organization" type="{urn:rusatom:report:balance:v1.0}Organization" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportBalance", namespace = "urn:rusatom:report:balance:v1.0", propOrder = {
    "onDate",
    "compilerReport",
    "responsible",
    "organizations"
})
public class ReportBalance {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar onDate;
    @XmlElement(required = true)
    protected CompilerReport compilerReport;
    @XmlElement(required = true)
    protected Responsible responsible;
    @XmlElement(required = true)
    protected ReportBalance.Organizations organizations;

    /**
     * Gets the value of the onDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOnDate() {
        return onDate;
    }

    /**
     * Sets the value of the onDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOnDate(XMLGregorianCalendar value) {
        this.onDate = value;
    }

    /**
     * Gets the value of the compilerReport property.
     * 
     * @return
     *     possible object is
     *     {@link CompilerReport }
     *     
     */
    public CompilerReport getCompilerReport() {
        return compilerReport;
    }

    /**
     * Sets the value of the compilerReport property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompilerReport }
     *     
     */
    public void setCompilerReport(CompilerReport value) {
        this.compilerReport = value;
    }

    /**
     * Gets the value of the responsible property.
     * 
     * @return
     *     possible object is
     *     {@link Responsible }
     *     
     */
    public Responsible getResponsible() {
        return responsible;
    }

    /**
     * Sets the value of the responsible property.
     * 
     * @param value
     *     allowed object is
     *     {@link Responsible }
     *     
     */
    public void setResponsible(Responsible value) {
        this.responsible = value;
    }

    /**
     * Gets the value of the organizations property.
     * 
     * @return
     *     possible object is
     *     {@link ReportBalance.Organizations }
     *     
     */
    public ReportBalance.Organizations getOrganizations() {
        return organizations;
    }

    /**
     * Sets the value of the organizations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportBalance.Organizations }
     *     
     */
    public void setOrganizations(ReportBalance.Organizations value) {
        this.organizations = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="organization" type="{urn:rusatom:report:balance:v1.0}Organization" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "organization"
    })
    public static class Organizations {

        @XmlElement(required = true)
        protected List<Organization> organization;

        /**
         * Gets the value of the organization property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the organization property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOrganization().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Organization }
         * 
         * 
         */
        public List<Organization> getOrganization() {
            if (organization == null) {
                organization = new ArrayList<Organization>();
            }
            return this.organization;
        }

    }

}
