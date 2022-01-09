
package com.example.officialsapplication.model.users.izvestaj;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TProizvodjaci_info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TProizvodjaci_info">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Broj_doza_Pfizer_BioNTech" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="Broj_doza_Sinopharm" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="Broj_doza_SputnikV" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="Broj_doza_AstraZeneca" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TProizvodjaci_info", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", propOrder = {
    "brojDozaPfizerBioNTech",
    "brojDozaSinopharm",
    "brojDozaSputnikV",
    "brojDozaAstraZeneca"
})
public class TProizvodjaciInfo {

    @XmlElement(name = "Broj_doza_Pfizer_BioNTech", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger brojDozaPfizerBioNTech;
    @XmlElement(name = "Broj_doza_Sinopharm", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger brojDozaSinopharm;
    @XmlElement(name = "Broj_doza_SputnikV", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger brojDozaSputnikV;
    @XmlElement(name = "Broj_doza_AstraZeneca", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger brojDozaAstraZeneca;

    /**
     * Gets the value of the brojDozaPfizerBioNTech property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojDozaPfizerBioNTech() {
        return brojDozaPfizerBioNTech;
    }

    /**
     * Sets the value of the brojDozaPfizerBioNTech property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojDozaPfizerBioNTech(BigInteger value) {
        this.brojDozaPfizerBioNTech = value;
    }

    /**
     * Gets the value of the brojDozaSinopharm property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojDozaSinopharm() {
        return brojDozaSinopharm;
    }

    /**
     * Sets the value of the brojDozaSinopharm property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojDozaSinopharm(BigInteger value) {
        this.brojDozaSinopharm = value;
    }

    /**
     * Gets the value of the brojDozaSputnikV property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojDozaSputnikV() {
        return brojDozaSputnikV;
    }

    /**
     * Sets the value of the brojDozaSputnikV property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojDozaSputnikV(BigInteger value) {
        this.brojDozaSputnikV = value;
    }

    /**
     * Gets the value of the brojDozaAstraZeneca property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojDozaAstraZeneca() {
        return brojDozaAstraZeneca;
    }

    /**
     * Sets the value of the brojDozaAstraZeneca property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojDozaAstraZeneca(BigInteger value) {
        this.brojDozaAstraZeneca = value;
    }

}
