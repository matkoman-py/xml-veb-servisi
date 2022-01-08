
package com.example.VaccinationApplication.model.types.zahtev_zelenog_sertifikata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TInformacije_o_podnosiocu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TInformacije_o_podnosiocu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ime_i_prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Pol">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Musko"/>
 *               &lt;enumeration value="Zensko"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Jedinstveni_maticni_broj_gradjana">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="13"/>
 *               &lt;pattern value="\d{13}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Broj_pasosa">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="\d{10}"/>
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
@XmlType(name = "TInformacije_o_podnosiocu", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", propOrder = {
    "imeIPrezime",
    "datumRodjenja",
    "pol",
    "jedinstveniMaticniBrojGradjana",
    "brojPasosa"
})
public class TInformacijeOPodnosiocu {

    public TInformacijeOPodnosiocu(String imeIPrezime, XMLGregorianCalendar datumRodjenja, String pol, String jedinstveniMaticniBrojGradjana, String brojPasosa) {
        this.imeIPrezime = imeIPrezime;
        this.datumRodjenja = datumRodjenja;
        this.pol = pol;
        this.jedinstveniMaticniBrojGradjana = jedinstveniMaticniBrojGradjana;
        this.brojPasosa = brojPasosa;
    }

    public TInformacijeOPodnosiocu() {
    }

    @XmlElement(name = "Ime_i_prezime", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected String imeIPrezime;
    @XmlElement(name = "Datum_rodjenja", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumRodjenja;
    @XmlElement(name = "Pol", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected String pol;
    @XmlElement(name = "Jedinstveni_maticni_broj_gradjana", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected String jedinstveniMaticniBrojGradjana;
    @XmlElement(name = "Broj_pasosa", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected String brojPasosa;

    /**
     * Gets the value of the imeIPrezime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImeIPrezime() {
        return imeIPrezime;
    }

    /**
     * Sets the value of the imeIPrezime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImeIPrezime(String value) {
        this.imeIPrezime = value;
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
     * Gets the value of the jedinstveniMaticniBrojGradjana property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJedinstveniMaticniBrojGradjana() {
        return jedinstveniMaticniBrojGradjana;
    }

    /**
     * Sets the value of the jedinstveniMaticniBrojGradjana property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJedinstveniMaticniBrojGradjana(String value) {
        this.jedinstveniMaticniBrojGradjana = value;
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

}