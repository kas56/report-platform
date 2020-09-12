
package ru.plot.jaxb.rosatom;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.plot.jaxb.rosatom package. 
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

    private final static QName _ReportBalance_QNAME = new QName("urn:rusatom:report:balance:v1.0", "reportBalance");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.plot.jaxb.rosatom
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Balance }
     * 
     */
    public Balance createBalance() {
        return new Balance();
    }

    /**
     * Create an instance of {@link Bank }
     * 
     */
    public Bank createBank() {
        return new Bank();
    }

    /**
     * Create an instance of {@link Organization }
     * 
     */
    public Organization createOrganization() {
        return new Organization();
    }

    /**
     * Create an instance of {@link ReportBalance }
     * 
     */
    public ReportBalance createReportBalance() {
        return new ReportBalance();
    }

    /**
     * Create an instance of {@link CompilerReport }
     * 
     */
    public CompilerReport createCompilerReport() {
        return new CompilerReport();
    }

    /**
     * Create an instance of {@link Responsible }
     * 
     */
    public Responsible createResponsible() {
        return new Responsible();
    }

    /**
     * Create an instance of {@link Contract }
     * 
     */
    public Contract createContract() {
        return new Contract();
    }

    /**
     * Create an instance of {@link Balance.Contracts }
     * 
     */
    public Balance.Contracts createBalanceContracts() {
        return new Balance.Contracts();
    }

    /**
     * Create an instance of {@link Bank.Balances }
     * 
     */
    public Bank.Balances createBankBalances() {
        return new Bank.Balances();
    }

    /**
     * Create an instance of {@link Organization.Banks }
     * 
     */
    public Organization.Banks createOrganizationBanks() {
        return new Organization.Banks();
    }

    /**
     * Create an instance of {@link ReportBalance.Organizations }
     * 
     */
    public ReportBalance.Organizations createReportBalanceOrganizations() {
        return new ReportBalance.Organizations();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:rusatom:report:balance:v1.0", name = "reportBalance")
    public JAXBElement<ReportBalance> createReportBalance(ReportBalance value) {
        return new JAXBElement<ReportBalance>(_ReportBalance_QNAME, ReportBalance.class, null, value);
    }

}
