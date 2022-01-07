
package com.example.VaccinationApplication.model.types.pacijent;

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
 *         &lt;element name="fiksni_telefon" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mobilni_telefon" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TKontakt", propOrder = {
    "fiksniTelefon",
    "mobilniTelefon",
    "email"
})
public class TKontakt {

    @XmlElement(name = "fiksni_telefon", required = true)
    protected String fiksniTelefon;
    @XmlElement(name = "mobilni_telefon", required = true)
    protected String mobilniTelefon;
    @XmlElement(required = true)
    protected String email;

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

}
