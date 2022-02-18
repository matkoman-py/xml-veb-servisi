
package com.example.VaccinationApplication.model.potvrda;

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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Sifra_potvrde" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pacijent" type="{http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji}TPacijent"/&gt;
 *         &lt;element name="Vakcinacija_info" type="{http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji}TVakcinacija"/&gt;
 *         &lt;element name="Qr_kod" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="about" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:parentTo" /&gt;
 *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sifraPotvrde",
    "pacijent",
    "vakcinacijaInfo",
    "qrKod"
})
@XmlRootElement(name = "Potvrda", namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji")
public class Potvrda {

    @XmlElement(name = "Sifra_potvrde", namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected String sifraPotvrde;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected TPacijent pacijent;
    @XmlElement(name = "Vakcinacija_info", namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected TVakcinacija vakcinacijaInfo;
    @XmlElement(name = "Qr_kod", namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected String qrKod;
    @XmlAttribute(name = "about", required = true)
    protected String about;
    @XmlAttribute(name = "rel")
    protected String rel;
    @XmlAttribute(name = "href")
    protected String href;

    /**
     * Gets the value of the sifraPotvrde property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSifraPotvrde() {
        return sifraPotvrde;
    }

    /**
     * Sets the value of the sifraPotvrde property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSifraPotvrde(String value) {
        this.sifraPotvrde = value;
    }

    /**
     * Gets the value of the pacijent property.
     * 
     * @return
     *     possible object is
     *     {@link TPacijent }
     *     
     */
    public TPacijent getPacijent() {
        return pacijent;
    }

    /**
     * Sets the value of the pacijent property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPacijent }
     *     
     */
    public void setPacijent(TPacijent value) {
        this.pacijent = value;
    }

    /**
     * Gets the value of the vakcinacijaInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TVakcinacija }
     *     
     */
    public TVakcinacija getVakcinacijaInfo() {
        return vakcinacijaInfo;
    }

    /**
     * Sets the value of the vakcinacijaInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TVakcinacija }
     *     
     */
    public void setVakcinacijaInfo(TVakcinacija value) {
        this.vakcinacijaInfo = value;
    }

    /**
     * Gets the value of the qrKod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQrKod() {
        return qrKod;
    }

    /**
     * Sets the value of the qrKod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQrKod(String value) {
        this.qrKod = value;
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
