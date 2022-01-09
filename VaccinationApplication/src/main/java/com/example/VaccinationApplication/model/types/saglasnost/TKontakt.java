
package com.example.VaccinationApplication.model.types.saglasnost;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TKontakt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TKontakt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fiksni">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[+]?[0-9]+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Mobilni">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[+]?[0-9]+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Email">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[a-zA-Z0-9_.+\-]+@[a-zA-Z0-9\-]+.[a-zA-Z0-9\-.]+"/>
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
@XmlType(name = "TKontakt", namespace = "www.ftn.uns.ac.rs/Saglasnost", propOrder = {
    "fiksni",
    "mobilni",
    "email"
})
public class TKontakt {

    @XmlElement(name = "Fiksni", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String fiksni;
    @XmlElement(name = "Mobilni", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String mobilni;
    @XmlElement(name = "Email", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String email;

    /**
     * Gets the value of the fiksni property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiksni() {
        return fiksni;
    }

    /**
     * Sets the value of the fiksni property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiksni(String value) {
        this.fiksni = value;
    }

    /**
     * Gets the value of the mobilni property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobilni() {
        return mobilni;
    }

    /**
     * Sets the value of the mobilni property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobilni(String value) {
        this.mobilni = value;
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

}
