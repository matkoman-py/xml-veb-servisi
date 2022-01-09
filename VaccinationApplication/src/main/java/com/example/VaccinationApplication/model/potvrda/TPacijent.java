
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
 * &lt;complexType name="TPacijent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ime_i_prezime" type="{www.ftn.uns.ac.rs/potvrda_o_vakcinaciji}TImeIPrezime"/>
 *         &lt;element name="Datum_rodjenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Pol">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Musko"/>
 *               &lt;enumeration value="Zensko"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Jmbg" type="{www.ftn.uns.ac.rs/potvrda_o_vakcinaciji}TJmbg"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPacijent", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", propOrder = {
    "imeIPrezime",
    "datumRodjenja",
    "pol",
    "jmbg"
})
public class TPacijent {

    @XmlElement(name = "Ime_i_prezime", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected TImeIPrezime imeIPrezime;
    @XmlElement(name = "Datum_rodjenja", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumRodjenja;
    @XmlElement(name = "Pol", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected String pol;
    @XmlElement(name = "Jmbg", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected TJmbg jmbg;

    /**
     * Gets the value of the imeIPrezime property.
     * 
     * @return
     *     possible object is
     *     {@link TImeIPrezime }
     *     
     */
    public TImeIPrezime getImeIPrezime() {
        return imeIPrezime;
    }

    /**
     * Sets the value of the imeIPrezime property.
     * 
     * @param value
     *     allowed object is
     *     {@link TImeIPrezime }
     *     
     */
    public void setImeIPrezime(TImeIPrezime value) {
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
