
package com.example.VaccinationApplication.model.zeleni_sertifikat;

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
 *         &lt;element name="ime_prezime" type="{http://www.ftn.uns.ac.rs/zelenisertifikat}TImeIPrezime"/>
 *         &lt;element name="pol">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Musko"/>
 *               &lt;enumeration value="Zensko"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="jmbg" type="{http://www.ftn.uns.ac.rs/zelenisertifikat}TJmbg"/>
 *         &lt;element name="broj_pasosa">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="13"/>
 *               &lt;pattern value="\d+"/>
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
@XmlType(name = "TPacijent", namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", propOrder = {
    "imePrezime",
    "pol",
    "datumRodjenja",
    "jmbg",
    "brojPasosa"
})
public class TPacijent {

    @XmlElement(name = "ime_prezime", namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected TImeIPrezime imePrezime;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected String pol;
    @XmlElement(name = "datum_rodjenja", namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumRodjenja;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected TJmbg jmbg;
    @XmlElement(name = "broj_pasosa", namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected String brojPasosa;

    /**
     * Gets the value of the imePrezime property.
     * 
     * @return
     *     possible object is
     *     {@link TImeIPrezime }
     *     
     */
    public TImeIPrezime getImePrezime() {
        return imePrezime;
    }

    /**
     * Sets the value of the imePrezime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TImeIPrezime }
     *     
     */
    public void setImePrezime(TImeIPrezime value) {
        this.imePrezime = value;
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
