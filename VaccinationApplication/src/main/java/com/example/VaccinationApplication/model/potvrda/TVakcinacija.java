
package com.example.VaccinationApplication.model.potvrda;

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
 *         &lt;element name="Prva_doza" type="{www.ftn.uns.ac.rs/potvrda_o_vakcinaciji}TDozaInfo"/>
 *         &lt;element name="Druga_doza" type="{www.ftn.uns.ac.rs/potvrda_o_vakcinaciji}TDozaInfo" minOccurs="0"/>
 *         &lt;element name="Zdravstvena_ustanova" type="{www.ftn.uns.ac.rs/potvrda_o_vakcinaciji}TZdravstvenaUstanova"/>
 *         &lt;element name="Naziv_vakcine" type="{www.ftn.uns.ac.rs/potvrda_o_vakcinaciji}TNazivVakcine"/>
 *         &lt;element name="Datum_izdavanja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TVakcinacija", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", propOrder = {
    "prvaDoza",
    "drugaDoza",
    "zdravstvenaUstanova",
    "nazivVakcine",
    "datumIzdavanja"
})
public class TVakcinacija {

    @XmlElement(name = "Prva_doza", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected TDozaInfo prvaDoza;
    @XmlElement(name = "Druga_doza", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji")
    protected TDozaInfo drugaDoza;
    @XmlElement(name = "Zdravstvena_ustanova", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected TZdravstvenaUstanova zdravstvenaUstanova;
    @XmlElement(name = "Naziv_vakcine", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected TNazivVakcine nazivVakcine;
    @XmlElement(name = "Datum_izdavanja", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumIzdavanja;

    /**
     * Gets the value of the prvaDoza property.
     * 
     * @return
     *     possible object is
     *     {@link TDozaInfo }
     *     
     */
    public TDozaInfo getPrvaDoza() {
        return prvaDoza;
    }

    /**
     * Sets the value of the prvaDoza property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDozaInfo }
     *     
     */
    public void setPrvaDoza(TDozaInfo value) {
        this.prvaDoza = value;
    }

    /**
     * Gets the value of the drugaDoza property.
     * 
     * @return
     *     possible object is
     *     {@link TDozaInfo }
     *     
     */
    public TDozaInfo getDrugaDoza() {
        return drugaDoza;
    }

    /**
     * Sets the value of the drugaDoza property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDozaInfo }
     *     
     */
    public void setDrugaDoza(TDozaInfo value) {
        this.drugaDoza = value;
    }

    /**
     * Gets the value of the zdravstvenaUstanova property.
     * 
     * @return
     *     possible object is
     *     {@link TZdravstvenaUstanova }
     *     
     */
    public TZdravstvenaUstanova getZdravstvenaUstanova() {
        return zdravstvenaUstanova;
    }

    /**
     * Sets the value of the zdravstvenaUstanova property.
     * 
     * @param value
     *     allowed object is
     *     {@link TZdravstvenaUstanova }
     *     
     */
    public void setZdravstvenaUstanova(TZdravstvenaUstanova value) {
        this.zdravstvenaUstanova = value;
    }

    /**
     * Gets the value of the nazivVakcine property.
     * 
     * @return
     *     possible object is
     *     {@link TNazivVakcine }
     *     
     */
    public TNazivVakcine getNazivVakcine() {
        return nazivVakcine;
    }

    /**
     * Sets the value of the nazivVakcine property.
     * 
     * @param value
     *     allowed object is
     *     {@link TNazivVakcine }
     *     
     */
    public void setNazivVakcine(TNazivVakcine value) {
        this.nazivVakcine = value;
    }

    /**
     * Gets the value of the datumIzdavanja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumIzdavanja() {
        return datumIzdavanja;
    }

    /**
     * Sets the value of the datumIzdavanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumIzdavanja(XMLGregorianCalendar value) {
        this.datumIzdavanja = value;
    }

}
