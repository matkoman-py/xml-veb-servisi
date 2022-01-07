
package com.example.VaccinationApplication.model.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.VaccinationApplication.model.types.interesovanje.TPodaciOPrimaocu;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Podaci_o_primaocu" type="{www.ftn.uns.ac.rs/interesovanje}TPodaci_o_primaocu"/>
 *         &lt;element name="Odabir_vakcine">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Pfizer-BioNTech "/>
 *               &lt;enumeration value="Sinopharm"/>
 *               &lt;enumeration value="Sputnik V"/>
 *               &lt;enumeration value="AstraZeneca"/>
 *               &lt;enumeration value="Moderna"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "podaciOPrimaocu",
    "odabirVakcine",
    "datum"
})
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement(name = "interesovanje", namespace = "www.ftn.uns.ac.rs/interesovanje")
public class Interesovanje {
    @XmlElement(name = "Podaci_o_primaocu", namespace = "www.ftn.uns.ac.rs/interesovanje", required = true)
    protected TPodaciOPrimaocu podaciOPrimaocu;
    @XmlElement(name = "Odabir_vakcine", namespace = "www.ftn.uns.ac.rs/interesovanje", required = true)
    protected String odabirVakcine;
    @XmlElement(name = "Datum", namespace = "www.ftn.uns.ac.rs/interesovanje", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;

    /**
     * Gets the value of the podaciOPrimaocu property.
     * 
     * @return
     *     possible object is
     *     {@link TPodaciOPrimaocu }
     *     
     */
    public TPodaciOPrimaocu getPodaciOPrimaocu() {
        return podaciOPrimaocu;
    }

    /**
     * Sets the value of the podaciOPrimaocu property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPodaciOPrimaocu }
     *     
     */
    public void setPodaciOPrimaocu(TPodaciOPrimaocu value) {
        this.podaciOPrimaocu = value;
    }

    /**
     * Gets the value of the odabirVakcine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOdabirVakcine() {
        return odabirVakcine;
    }

    /**
     * Sets the value of the odabirVakcine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOdabirVakcine(String value) {
        this.odabirVakcine = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

}
