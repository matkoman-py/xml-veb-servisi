
package com.example.VaccinationApplication.model.zeleni_sertifikat;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TVakcinacija complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TVakcinacija">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="doza" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="tip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="proizvodjac_serija" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="zdravstvena_ustanova" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TVakcinacija", namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", propOrder = {
    "doza",
    "tip",
    "proizvodjacSerija",
    "datum",
    "zdravstvenaUstanova"
})
public class TVakcinacija {

    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger doza;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected String tip;
    @XmlElement(name = "proizvodjac_serija", namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected String proizvodjacSerija;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(name = "zdravstvena_ustanova", namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected String zdravstvenaUstanova;

    /**
     * Gets the value of the doza property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDoza() {
        return doza;
    }

    /**
     * Sets the value of the doza property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDoza(BigInteger value) {
        this.doza = value;
    }

    /**
     * Gets the value of the tip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTip() {
        return tip;
    }

    /**
     * Sets the value of the tip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTip(String value) {
        this.tip = value;
    }

    /**
     * Gets the value of the proizvodjacSerija property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProizvodjacSerija() {
        return proizvodjacSerija;
    }

    /**
     * Sets the value of the proizvodjacSerija property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProizvodjacSerija(String value) {
        this.proizvodjacSerija = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the zdravstvenaUstanova property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZdravstvenaUstanova() {
        return zdravstvenaUstanova;
    }

    /**
     * Sets the value of the zdravstvenaUstanova property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZdravstvenaUstanova(String value) {
        this.zdravstvenaUstanova = value;
    }

}
