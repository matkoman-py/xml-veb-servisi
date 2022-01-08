
package com.example.VaccinationApplication.model.types.saglasnost;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TEvidencija complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TEvidencija">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Naziv_ustanove" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Vakcinacijski_punkt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Podaci_lekar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Vakcinacija" type="{www.ftn.uns.ac.rs/Saglasnost}TVakcinacija"/>
 *         &lt;element name="Revakcinacija" type="{www.ftn.uns.ac.rs/Saglasnost}TVakcinacija"/>
 *         &lt;element name="Privremene_kontraindikacije" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Odluka_komisije" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEvidencija", namespace = "www.ftn.uns.ac.rs/Saglasnost", propOrder = {
    "nazivUstanove",
    "vakcinacijskiPunkt",
    "podaciLekar",
    "vakcinacija",
    "revakcinacija",
    "privremeneKontraindikacije",
    "odlukaKomisije"
})
public class TEvidencija {

    public TEvidencija(String nazivUstanove, String vakcinacijskiPunkt, String podaciLekar, TVakcinacija vakcinacija, TVakcinacija revakcinacija, JAXBElement<String> privremeneKontraindikacije, JAXBElement<String> odlukaKomisije) {
        this.nazivUstanove = nazivUstanove;
        this.vakcinacijskiPunkt = vakcinacijskiPunkt;
        this.podaciLekar = podaciLekar;
        this.vakcinacija = vakcinacija;
        this.revakcinacija = revakcinacija;
        this.privremeneKontraindikacije = privremeneKontraindikacije;
        this.odlukaKomisije = odlukaKomisije;
    }

    public TEvidencija() {
    }

    @XmlElement(name = "Naziv_ustanove", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String nazivUstanove;
    @XmlElement(name = "Vakcinacijski_punkt", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String vakcinacijskiPunkt;
    @XmlElement(name = "Podaci_lekar", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String podaciLekar;
    @XmlElement(name = "Vakcinacija", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected TVakcinacija vakcinacija;
    @XmlElement(name = "Revakcinacija", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected TVakcinacija revakcinacija;
    @XmlElementRef(name = "Privremene_kontraindikacije", namespace = "www.ftn.uns.ac.rs/Saglasnost", type = JAXBElement.class, required = false)
    protected JAXBElement<String> privremeneKontraindikacije;
    @XmlElementRef(name = "Odluka_komisije", namespace = "www.ftn.uns.ac.rs/Saglasnost", type = JAXBElement.class, required = false)
    protected JAXBElement<String> odlukaKomisije;

    /**
     * Gets the value of the nazivUstanove property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivUstanove() {
        return nazivUstanove;
    }

    /**
     * Sets the value of the nazivUstanove property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivUstanove(String value) {
        this.nazivUstanove = value;
    }

    /**
     * Gets the value of the vakcinacijskiPunkt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVakcinacijskiPunkt() {
        return vakcinacijskiPunkt;
    }

    /**
     * Sets the value of the vakcinacijskiPunkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVakcinacijskiPunkt(String value) {
        this.vakcinacijskiPunkt = value;
    }

    /**
     * Gets the value of the podaciLekar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPodaciLekar() {
        return podaciLekar;
    }

    /**
     * Sets the value of the podaciLekar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPodaciLekar(String value) {
        this.podaciLekar = value;
    }

    /**
     * Gets the value of the vakcinacija property.
     * 
     * @return
     *     possible object is
     *     {@link TVakcinacija }
     *     
     */
    public TVakcinacija getVakcinacija() {
        return vakcinacija;
    }

    /**
     * Sets the value of the vakcinacija property.
     * 
     * @param value
     *     allowed object is
     *     {@link TVakcinacija }
     *     
     */
    public void setVakcinacija(TVakcinacija value) {
        this.vakcinacija = value;
    }

    /**
     * Gets the value of the revakcinacija property.
     * 
     * @return
     *     possible object is
     *     {@link TVakcinacija }
     *     
     */
    public TVakcinacija getRevakcinacija() {
        return revakcinacija;
    }

    /**
     * Sets the value of the revakcinacija property.
     * 
     * @param value
     *     allowed object is
     *     {@link TVakcinacija }
     *     
     */
    public void setRevakcinacija(TVakcinacija value) {
        this.revakcinacija = value;
    }

    /**
     * Gets the value of the privremeneKontraindikacije property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrivremeneKontraindikacije() {
        return privremeneKontraindikacije;
    }

    /**
     * Sets the value of the privremeneKontraindikacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrivremeneKontraindikacije(JAXBElement<String> value) {
        this.privremeneKontraindikacije = value;
    }

    /**
     * Gets the value of the odlukaKomisije property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOdlukaKomisije() {
        return odlukaKomisije;
    }

    /**
     * Sets the value of the odlukaKomisije property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOdlukaKomisije(JAXBElement<String> value) {
        this.odlukaKomisije = value;
    }

}
