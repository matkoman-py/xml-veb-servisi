
package com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TInformacije_o_zahtevu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TInformacije_o_zahtevu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Razlog">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="300"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Datum_izdavanja" type="{http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata}TDatumIzdavanja"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TInformacije_o_zahtevu", namespace = "http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", propOrder = {
    "razlog",
    "mesto",
    "datumIzdavanja"
})
public class TInformacijeOZahtevu {

    @XmlElement(name = "Razlog", namespace = "http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected String razlog;
    @XmlElement(name = "Mesto", namespace = "http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected String mesto;
    @XmlElement(name = "Datum_izdavanja", namespace = "http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected TDatumIzdavanja datumIzdavanja;

    /**
     * Gets the value of the razlog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazlog() {
        return razlog;
    }

    /**
     * Sets the value of the razlog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazlog(String value) {
        this.razlog = value;
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
     * Gets the value of the datumIzdavanja property.
     * 
     * @return
     *     possible object is
     *     {@link TDatumIzdavanja }
     *     
     */
    public TDatumIzdavanja getDatumIzdavanja() {
        return datumIzdavanja;
    }

    /**
     * Sets the value of the datumIzdavanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDatumIzdavanja }
     *     
     */
    public void setDatumIzdavanja(TDatumIzdavanja value) {
        this.datumIzdavanja = value;
    }

}
