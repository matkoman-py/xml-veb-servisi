
package com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat;

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
 *         &lt;element name="Ime_i_prezime" type="{www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata}TImePrezime"/>
 *         &lt;element name="Datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Pol">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Musko"/>
 *               &lt;enumeration value="Zensko"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Jedinstveni_maticni_broj_gradjana" type="{www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata}TJmbg"/>
 *         &lt;element name="Broj_pasosa" type="{www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata}TBrojPasosa"/>
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

    @XmlElement(name = "Ime_i_prezime", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected TImePrezime imeIPrezime;
    @XmlElement(name = "Datum_rodjenja", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumRodjenja;
    @XmlElement(name = "Pol", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected String pol;
    @XmlElement(name = "Jedinstveni_maticni_broj_gradjana", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected TJmbg jedinstveniMaticniBrojGradjana;
    @XmlElement(name = "Broj_pasosa", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected TBrojPasosa brojPasosa;

    /**
     * Gets the value of the imeIPrezime property.
     * 
     * @return
     *     possible object is
     *     {@link TImePrezime }
     *     
     */
    public TImePrezime getImeIPrezime() {
        return imeIPrezime;
    }

    /**
     * Sets the value of the imeIPrezime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TImePrezime }
     *     
     */
    public void setImeIPrezime(TImePrezime value) {
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
     *     {@link TJmbg }
     *     
     */
    public TJmbg getJedinstveniMaticniBrojGradjana() {
        return jedinstveniMaticniBrojGradjana;
    }

    /**
     * Sets the value of the jedinstveniMaticniBrojGradjana property.
     * 
     * @param value
     *     allowed object is
     *     {@link TJmbg }
     *     
     */
    public void setJedinstveniMaticniBrojGradjana(TJmbg value) {
        this.jedinstveniMaticniBrojGradjana = value;
    }

    /**
     * Gets the value of the brojPasosa property.
     * 
     * @return
     *     possible object is
     *     {@link TBrojPasosa }
     *     
     */
    public TBrojPasosa getBrojPasosa() {
        return brojPasosa;
    }

    /**
     * Sets the value of the brojPasosa property.
     * 
     * @param value
     *     allowed object is
     *     {@link TBrojPasosa }
     *     
     */
    public void setBrojPasosa(TBrojPasosa value) {
        this.brojPasosa = value;
    }

}
