
package com.example.VaccinationApplication.model.types.saglasnost;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TDrzavljanstvo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TDrzavljanstvo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="JMBG">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;length value="13"/>
 *               &lt;pattern value="[0-9]{13}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;sequence>
 *           &lt;element name="Naziv" type="{http://www.w3.org/2001/XMLSchema}string" form="qualified"/>
 *           &lt;element name="Broj_pasosa_EBS">
 *             &lt;simpleType>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                 &lt;pattern value="[0-9]+"/>
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *           &lt;/element>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDrzavljanstvo", namespace = "www.ftn.uns.ac.rs/Saglasnost", propOrder = {
    "jmbg",
    "naziv",
    "brojPasosaEBS"
})
public class TDrzavljanstvo {

    @XmlElement(name = "JMBG", namespace = "www.ftn.uns.ac.rs/Saglasnost")
    protected String jmbg;
    @XmlElement(name = "Naziv", namespace = "www.ftn.uns.ac.rs/Saglasnost")
    protected String naziv;
    @XmlElement(name = "Broj_pasosa_EBS", namespace = "www.ftn.uns.ac.rs/Saglasnost")
    protected String brojPasosaEBS;

    /**
     * Gets the value of the jmbg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJMBG() {
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
    public void setJMBG(String value) {
        this.jmbg = value;
    }

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the brojPasosaEBS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojPasosaEBS() {
        return brojPasosaEBS;
    }

    /**
     * Sets the value of the brojPasosaEBS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojPasosaEBS(String value) {
        this.brojPasosaEBS = value;
    }

}
