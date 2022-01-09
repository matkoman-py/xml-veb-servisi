
package com.example.officialsapplication.model.users.izvestaj;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TDoza_info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TDoza_info">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Broj_datih_doza" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="Broj_date_prve_doze" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="Broj_date_druge_doze" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="Broj_date_trece_doze" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDoza_info", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", propOrder = {
    "brojDatihDoza",
    "brojDatePrveDoze",
    "brojDateDrugeDoze",
    "brojDateTreceDoze"
})
public class TDozaInfo {

    @XmlElement(name = "Broj_datih_doza", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger brojDatihDoza;
    @XmlElement(name = "Broj_date_prve_doze", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger brojDatePrveDoze;
    @XmlElement(name = "Broj_date_druge_doze", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger brojDateDrugeDoze;
    @XmlElement(name = "Broj_date_trece_doze", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger brojDateTreceDoze;

    /**
     * Gets the value of the brojDatihDoza property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojDatihDoza() {
        return brojDatihDoza;
    }

    /**
     * Sets the value of the brojDatihDoza property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojDatihDoza(BigInteger value) {
        this.brojDatihDoza = value;
    }

    /**
     * Gets the value of the brojDatePrveDoze property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojDatePrveDoze() {
        return brojDatePrveDoze;
    }

    /**
     * Sets the value of the brojDatePrveDoze property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojDatePrveDoze(BigInteger value) {
        this.brojDatePrveDoze = value;
    }

    /**
     * Gets the value of the brojDateDrugeDoze property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojDateDrugeDoze() {
        return brojDateDrugeDoze;
    }

    /**
     * Sets the value of the brojDateDrugeDoze property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojDateDrugeDoze(BigInteger value) {
        this.brojDateDrugeDoze = value;
    }

    /**
     * Gets the value of the brojDateTreceDoze property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojDateTreceDoze() {
        return brojDateTreceDoze;
    }

    /**
     * Sets the value of the brojDateTreceDoze property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojDateTreceDoze(BigInteger value) {
        this.brojDateTreceDoze = value;
    }

}
