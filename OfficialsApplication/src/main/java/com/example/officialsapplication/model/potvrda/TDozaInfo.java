
package com.example.officialsapplication.model.potvrda;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TDozaInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TDozaInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Datum_vakcine" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Serija_vakcine" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDozaInfo", namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", propOrder = {
    "datumVakcine",
    "serijaVakcine"
})
public class TDozaInfo {

    @XmlElement(name = "Datum_vakcine", namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumVakcine;
    @XmlElement(name = "Serija_vakcine", namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected String serijaVakcine;

    /**
     * Gets the value of the datumVakcine property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumVakcine() {
        return datumVakcine;
    }

    /**
     * Sets the value of the datumVakcine property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumVakcine(XMLGregorianCalendar value) {
        this.datumVakcine = value;
    }

    /**
     * Gets the value of the serijaVakcine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerijaVakcine() {
        return serijaVakcine;
    }

    /**
     * Sets the value of the serijaVakcine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerijaVakcine(String value) {
        this.serijaVakcine = value;
    }

}
