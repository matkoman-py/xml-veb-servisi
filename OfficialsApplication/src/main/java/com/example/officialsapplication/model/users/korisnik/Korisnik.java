
package com.example.officialsapplication.model.users.korisnik;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="drzavljanstvo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jmbg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="broj_pasosa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ime_roditelja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pol">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="muski"/>
 *               &lt;enumeration value="zenski"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="mesto_rodjenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="adresa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="grad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fiksni_telefon" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mobilni_telefon" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sifra" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rola">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="gradjanin"/>
 *               &lt;enumeration value="sluzbenik"/>
 *               &lt;enumeration value="zdravstveni_radnik"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
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
@XmlType(name = "", propOrder = {
    "drzavljanstvo",
    "jmbg",
    "brojPasosa",
    "ime",
    "prezime",
    "imeRoditelja",
    "pol",
    "datumRodjenja",
    "mestoRodjenja",
    "adresa",
    "mesto",
    "grad",
    "fiksniTelefon",
    "mobilniTelefon",
    "email",
    "sifra",
    "rola"
})
@XmlRootElement(name = "korisnik", namespace = "http://www.ftn.uns.ac.rs/korisnik")
public class Korisnik {

    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String drzavljanstvo;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String jmbg;
    @XmlElement(name = "broj_pasosa", namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String brojPasosa;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String ime;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String prezime;
    @XmlElement(name = "ime_roditelja", namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String imeRoditelja;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String pol;
    @XmlElement(name = "datum_rodjenja", namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumRodjenja;
    @XmlElement(name = "mesto_rodjenja", namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String mestoRodjenja;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String adresa;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String mesto;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String grad;
    @XmlElement(name = "fiksni_telefon", namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String fiksniTelefon;
    @XmlElement(name = "mobilni_telefon", namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String mobilniTelefon;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String email;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String sifra;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnik", required = true)
    protected String rola;

    /**
     * Gets the value of the drzavljanstvo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    /**
     * Sets the value of the drzavljanstvo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrzavljanstvo(String value) {
        this.drzavljanstvo = value;
    }

    /**
     * Gets the value of the jmbg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJmbg() {
        return jmbg;
    }

    /**
     * Sets the value of the jmbg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJmbg(String value) {
        this.jmbg = value;
    }

    /**
     * Gets the value of the brojPasosa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojPasosa() {
        return brojPasosa;
    }

    /**
     * Sets the value of the brojPasosa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojPasosa(String value) {
        this.brojPasosa = value;
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
     *     {@link String }
     *     
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresa(String value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the mesto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesto(String value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the grad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrad() {
        return grad;
    }

    /**
     * Sets the value of the grad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrad(String value) {
        this.grad = value;
    }

    /**
     * Gets the value of the fiksniTelefon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiksniTelefon() {
        return fiksniTelefon;
    }

    /**
     * Sets the value of the fiksniTelefon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiksniTelefon(String value) {
        this.fiksniTelefon = value;
    }

    /**
     * Gets the value of the mobilniTelefon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobilniTelefon() {
        return mobilniTelefon;
    }

    /**
     * Sets the value of the mobilniTelefon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobilniTelefon(String value) {
        this.mobilniTelefon = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the sifra property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSifra() {
        return sifra;
    }

    /**
     * Sets the value of the sifra property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSifra(String value) {
        this.sifra = value;
    }

    /**
     * Gets the value of the rola property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRola() {
        return rola;
    }

    /**
     * Sets the value of the rola property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRola(String value) {
        this.rola = value;
    }

}
