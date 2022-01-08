
package com.example.VaccinationApplication.model.types.saglasnost;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TVakcinacija complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TVakcinacija">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Naziv_vakcine" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Datum_vakcinacije" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Ekstremitet">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="lr"/>
 *               &lt;enumeration value="dr"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Lot" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Proizvodjac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Nezeljena_reakcija" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TVakcinacija", namespace = "www.ftn.uns.ac.rs/Saglasnost", propOrder = {
    "nazivVakcine",
    "datumVakcinacije",
    "ekstremitet",
    "lot",
    "proizvodjac",
    "nezeljenaReakcija"
})
public class TVakcinacija {

    public TVakcinacija(String nazivVakcine, XMLGregorianCalendar datumVakcinacije, String ekstremitet, String lot, String proizvodjac, JAXBElement<String> nezeljenaReakcija) {
        this.nazivVakcine = nazivVakcine;
        this.datumVakcinacije = datumVakcinacije;
        this.ekstremitet = ekstremitet;
        this.lot = lot;
        this.proizvodjac = proizvodjac;
        this.nezeljenaReakcija = nezeljenaReakcija;
    }

    public TVakcinacija() {
    }

    @XmlElement(name = "Naziv_vakcine", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String nazivVakcine;
    @XmlElement(name = "Datum_vakcinacije", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumVakcinacije;
    @XmlElement(name = "Ekstremitet", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String ekstremitet;
    @XmlElement(name = "Lot", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String lot;
    @XmlElement(name = "Proizvodjac", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String proizvodjac;
    @XmlElementRef(name = "Nezeljena_reakcija", namespace = "www.ftn.uns.ac.rs/Saglasnost", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nezeljenaReakcija;

    /**
     * Gets the value of the nazivVakcine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivVakcine() {
        return nazivVakcine;
    }

    /**
     * Sets the value of the nazivVakcine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivVakcine(String value) {
        this.nazivVakcine = value;
    }

    /**
     * Gets the value of the datumVakcinacije property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumVakcinacije() {
        return datumVakcinacije;
    }

    /**
     * Sets the value of the datumVakcinacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumVakcinacije(XMLGregorianCalendar value) {
        this.datumVakcinacije = value;
    }

    /**
     * Gets the value of the ekstremitet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEkstremitet() {
        return ekstremitet;
    }

    /**
     * Sets the value of the ekstremitet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEkstremitet(String value) {
        this.ekstremitet = value;
    }

    /**
     * Gets the value of the lot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLot() {
        return lot;
    }

    /**
     * Sets the value of the lot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLot(String value) {
        this.lot = value;
    }

    /**
     * Gets the value of the proizvodjac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProizvodjac() {
        return proizvodjac;
    }

    /**
     * Sets the value of the proizvodjac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProizvodjac(String value) {
        this.proizvodjac = value;
    }

    /**
     * Gets the value of the nezeljenaReakcija property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNezeljenaReakcija() {
        return nezeljenaReakcija;
    }

    /**
     * Sets the value of the nezeljenaReakcija property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNezeljenaReakcija(JAXBElement<String> value) {
        this.nezeljenaReakcija = value;
    }

}
