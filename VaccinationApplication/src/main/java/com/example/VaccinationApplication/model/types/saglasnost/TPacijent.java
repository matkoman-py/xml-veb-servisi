
package com.example.VaccinationApplication.model.types.saglasnost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
 * &lt;complexType name="TPacijent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Ime_roditelja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Pol" type="{www.ftn.uns.ac.rs/Saglasnost}TPol"/>
 *         &lt;element name="Datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Mesto_rodjenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Adresa" type="{www.ftn.uns.ac.rs/Saglasnost}TAdresa"/>
 *         &lt;element name="Kontakt" type="{www.ftn.uns.ac.rs/Saglasnost}TKontakt"/>
 *         &lt;element name="Radni_status" type="{www.ftn.uns.ac.rs/Saglasnost}TRadni_status"/>
 *         &lt;element name="Zanimanje" type="{www.ftn.uns.ac.rs/Saglasnost}TZanimanje" minOccurs="0"/>
 *         &lt;element name="Socijalna_zastita_info" type="{www.ftn.uns.ac.rs/Saglasnost}TSocijalna_zastita"/>
 *         &lt;element name="Izjava_saglasnosti" type="{www.ftn.uns.ac.rs/Saglasnost}TIzjava_saglasnosti"/>
 *         &lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPacijent", namespace = "www.ftn.uns.ac.rs/Saglasnost", propOrder = {
    "prezime",
    "ime",
    "imeRoditelja",
    "pol",
    "datumRodjenja",
    "mestoRodjenja",
    "adresa",
    "kontakt",
    "radniStatus",
    "zanimanje",
    "socijalnaZastitaInfo",
    "izjavaSaglasnosti",
    "datum"
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TPacijent {

    @XmlElement(name = "Prezime", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String prezime;
    @XmlElement(name = "Ime", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String ime;
    @XmlElement(name = "Ime_roditelja", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String imeRoditelja;
    @XmlElement(name = "Pol", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    @XmlSchemaType(name = "string")
    protected TPol pol;
    @XmlElement(name = "Datum_rodjenja", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumRodjenja;
    @XmlElement(name = "Mesto_rodjenja", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String mestoRodjenja;
    @XmlElement(name = "Adresa", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected TAdresa adresa;
    @XmlElement(name = "Kontakt", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected TKontakt kontakt;
    @XmlElement(name = "Radni_status", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    @XmlSchemaType(name = "string")
    protected TRadniStatus radniStatus;
    @XmlElement(name = "Zanimanje", namespace = "www.ftn.uns.ac.rs/Saglasnost")
    @XmlSchemaType(name = "string")
    protected TZanimanje zanimanje;
    @XmlElement(name = "Socijalna_zastita_info", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected TSocijalnaZastita socijalnaZastitaInfo;
    @XmlElement(name = "Izjava_saglasnosti", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected TIzjavaSaglasnosti izjavaSaglasnosti;
    @XmlElement(name = "Datum", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;

    /**
     * Gets the value of the prezime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Sets the value of the prezime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrezime(String value) {
        this.prezime = value;
    }

    /**
     * Gets the value of the ime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the imeRoditelja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImeRoditelja() {
        return imeRoditelja;
    }

    /**
     * Sets the value of the imeRoditelja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImeRoditelja(String value) {
        this.imeRoditelja = value;
    }

    /**
     * Gets the value of the pol property.
     * 
     * @return
     *     possible object is
     *     {@link TPol }
     *     
     */
    public TPol getPol() {
        return pol;
    }

    /**
     * Sets the value of the pol property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPol }
     *     
     */
    public void setPol(TPol value) {
        this.pol = value;
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
     * Gets the value of the mestoRodjenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMestoRodjenja() {
        return mestoRodjenja;
    }

    /**
     * Sets the value of the mestoRodjenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMestoRodjenja(String value) {
        this.mestoRodjenja = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link TAdresa }
     *     
     */
    public TAdresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAdresa }
     *     
     */
    public void setAdresa(TAdresa value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the kontakt property.
     * 
     * @return
     *     possible object is
     *     {@link TKontakt }
     *     
     */
    public TKontakt getKontakt() {
        return kontakt;
    }

    /**
     * Sets the value of the kontakt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TKontakt }
     *     
     */
    public void setKontakt(TKontakt value) {
        this.kontakt = value;
    }

    /**
     * Gets the value of the radniStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TRadniStatus }
     *     
     */
    public TRadniStatus getRadniStatus() {
        return radniStatus;
    }

    /**
     * Sets the value of the radniStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRadniStatus }
     *     
     */
    public void setRadniStatus(TRadniStatus value) {
        this.radniStatus = value;
    }

    /**
     * Gets the value of the zanimanje property.
     * 
     * @return
     *     possible object is
     *     {@link TZanimanje }
     *     
     */
    public TZanimanje getZanimanje() {
        return zanimanje;
    }

    /**
     * Sets the value of the zanimanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link TZanimanje }
     *     
     */
    public void setZanimanje(TZanimanje value) {
        this.zanimanje = value;
    }

    /**
     * Gets the value of the socijalnaZastitaInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TSocijalnaZastita }
     *     
     */
    public TSocijalnaZastita getSocijalnaZastitaInfo() {
        return socijalnaZastitaInfo;
    }

    /**
     * Sets the value of the socijalnaZastitaInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TSocijalnaZastita }
     *     
     */
    public void setSocijalnaZastitaInfo(TSocijalnaZastita value) {
        this.socijalnaZastitaInfo = value;
    }

    /**
     * Gets the value of the izjavaSaglasnosti property.
     * 
     * @return
     *     possible object is
     *     {@link TIzjavaSaglasnosti }
     *     
     */
    public TIzjavaSaglasnosti getIzjavaSaglasnosti() {
        return izjavaSaglasnosti;
    }

    /**
     * Sets the value of the izjavaSaglasnosti property.
     * 
     * @param value
     *     allowed object is
     *     {@link TIzjavaSaglasnosti }
     *     
     */
    public void setIzjavaSaglasnosti(TIzjavaSaglasnosti value) {
        this.izjavaSaglasnosti = value;
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

}
