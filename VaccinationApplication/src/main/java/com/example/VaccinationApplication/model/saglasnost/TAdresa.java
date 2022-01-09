
package com.example.VaccinationApplication.model.saglasnost;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TAdresa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAdresa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ulica_i_broj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Opstina" type="{www.ftn.uns.ac.rs/Saglasnost}TOpstina"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAdresa", namespace = "www.ftn.uns.ac.rs/Saglasnost", propOrder = {
    "ulicaIBroj",
    "mesto",
    "opstina"
})
public class TAdresa {

    @XmlElement(name = "Ulica_i_broj", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String ulicaIBroj;
    @XmlElement(name = "Mesto", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String mesto;
    @XmlElement(name = "Opstina", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected TOpstina opstina;

    /**
     * Gets the value of the ulicaIBroj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUlicaIBroj() {
        return ulicaIBroj;
    }

    /**
     * Sets the value of the ulicaIBroj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUlicaIBroj(String value) {
        this.ulicaIBroj = value;
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
     * Gets the value of the opstina property.
     * 
     * @return
     *     possible object is
     *     {@link TOpstina }
     *     
     */
    public TOpstina getOpstina() {
        return opstina;
    }

    /**
     * Sets the value of the opstina property.
     * 
     * @param value
     *     allowed object is
     *     {@link TOpstina }
     *     
     */
    public void setOpstina(TOpstina value) {
        this.opstina = value;
    }

}
