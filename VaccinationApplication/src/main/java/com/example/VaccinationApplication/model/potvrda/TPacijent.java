
package com.example.VaccinationApplication.model.potvrda;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TPacijent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPacijent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ime" type="{http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji}TIme"/&gt;
 *         &lt;element name="prezime" type="{http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji}TPrezime"/&gt;
 *         &lt;element name="Datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="Pol" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Jmbg" type="{http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji}TJmbg"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPacijent", namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", propOrder = {
    "ime",
    "prezime",
    "datumRodjenja",
    "pol",
    "jmbg"
})
public class TPacijent {

    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected TIme ime;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected TPrezime prezime;
    @XmlElement(name = "Datum_rodjenja", namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumRodjenja;
    @XmlElement(name = "Pol", namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected String pol;
    @XmlElement(name = "Jmbg", namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected TJmbg jmbg;

    /**
     * Gets the value of the ime property.
     * 
     * @return
     *     possible object is
     *     {@link TIme }
     *     
     */
    public TIme getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TIme }
     *     
     */
    public void setIme(TIme value) {
        this.ime = value;
    }

    /**
     * Gets the value of the prezime property.
     * 
     * @return
     *     possible object is
     *     {@link TPrezime }
     *     
     */
    public TPrezime getPrezime() {
        return prezime;
    }

    /**
     * Sets the value of the prezime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPrezime }
     *     
     */
    public void setPrezime(TPrezime value) {
        this.prezime = value;
    }

    /**
     * Gets the value of the datumRodjenja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumRodjenja() {
        return datumRodjenja;
    }

    /**
     * Sets the value of the datumRodjenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumRodjenja(XMLGregorianCalendar value) {
        this.datumRodjenja = value;
    }

    /**
     * Gets the value of the pol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPol() {
        return pol;
    }

    /**
     * Sets the value of the pol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPol(String value) {
        this.pol = value;
    }

    /**
     * Gets the value of the jmbg property.
     * 
     * @return
     *     possible object is
     *     {@link TJmbg }
     *     
     */
    public TJmbg getJmbg() {
        return jmbg;
    }

    /**
     * Sets the value of the jmbg property.
     * 
     * @param value
     *     allowed object is
     *     {@link TJmbg }
     *     
     */
    public void setJmbg(TJmbg value) {
        this.jmbg = value;
    }

}
