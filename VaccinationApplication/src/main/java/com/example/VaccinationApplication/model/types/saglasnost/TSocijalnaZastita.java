
package com.example.VaccinationApplication.model.types.saglasnost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TSocijalna_zastita complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TSocijalna_zastita">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Koristi_zastitu">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="da"/>
 *               &lt;enumeration value="ne"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Naziv_opstina_sedista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TSocijalna_zastita", namespace = "www.ftn.uns.ac.rs/Saglasnost", propOrder = {
    "koristiZastitu",
    "nazivOpstinaSedista"
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TSocijalnaZastita {

    @XmlElement(name = "Koristi_zastitu", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String koristiZastitu;
    @XmlElementRef(name = "Naziv_opstina_sedista", namespace = "www.ftn.uns.ac.rs/Saglasnost", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazivOpstinaSedista;

    /**
     * Gets the value of the koristiZastitu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKoristiZastitu() {
        return koristiZastitu;
    }

    /**
     * Sets the value of the koristiZastitu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKoristiZastitu(String value) {
        this.koristiZastitu = value;
    }

    /**
     * Gets the value of the nazivOpstinaSedista property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazivOpstinaSedista() {
        return nazivOpstinaSedista;
    }

    /**
     * Sets the value of the nazivOpstinaSedista property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazivOpstinaSedista(JAXBElement<String> value) {
        this.nazivOpstinaSedista = value;
    }

}
