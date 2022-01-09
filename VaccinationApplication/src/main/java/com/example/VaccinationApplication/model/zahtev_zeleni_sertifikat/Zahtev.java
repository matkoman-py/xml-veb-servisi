
package com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Podnosilac_zahteva" type="{www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata}TInformacije_o_podnosiocu" form="qualified"/>
 *         &lt;element name="Informacije_o_zahtevu" type="{www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata}TInformacije_o_zahtevu"/>
 *       &lt;/sequence>
 *       &lt;attribute name="about" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:parentTo" />
 *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "podnosilacZahteva",
    "informacijeOZahtevu"
})
@XmlRootElement(name = "zahtev", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata")
public class Zahtev {

    @XmlElement(name = "Podnosilac_zahteva", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected TInformacijeOPodnosiocu podnosilacZahteva;
    @XmlElement(name = "Informacije_o_zahtevu", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected TInformacijeOZahtevu informacijeOZahtevu;
    @XmlAttribute(name = "about", required = true)
    protected String about;
    @XmlAttribute(name = "rel")
    protected String rel;
    @XmlAttribute(name = "href")
    protected String href;

    /**
     * Gets the value of the podnosilacZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link TInformacijeOPodnosiocu }
     *     
     */
    public TInformacijeOPodnosiocu getPodnosilacZahteva() {
        return podnosilacZahteva;
    }

    /**
     * Sets the value of the podnosilacZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link TInformacijeOPodnosiocu }
     *     
     */
    public void setPodnosilacZahteva(TInformacijeOPodnosiocu value) {
        this.podnosilacZahteva = value;
    }

    /**
     * Gets the value of the informacijeOZahtevu property.
     * 
     * @return
     *     possible object is
     *     {@link TInformacijeOZahtevu }
     *     
     */
    public TInformacijeOZahtevu getInformacijeOZahtevu() {
        return informacijeOZahtevu;
    }

    /**
     * Sets the value of the informacijeOZahtevu property.
     * 
     * @param value
     *     allowed object is
     *     {@link TInformacijeOZahtevu }
     *     
     */
    public void setInformacijeOZahtevu(TInformacijeOZahtevu value) {
        this.informacijeOZahtevu = value;
    }

    /**
     * Gets the value of the about property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbout() {
        return about;
    }

    /**
     * Sets the value of the about property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbout(String value) {
        this.about = value;
    }

    /**
     * Gets the value of the rel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRel() {
        if (rel == null) {
            return "pred:parentTo";
        } else {
            return rel;
        }
    }

    /**
     * Sets the value of the rel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRel(String value) {
        this.rel = value;
    }

    /**
     * Gets the value of the href property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

}
