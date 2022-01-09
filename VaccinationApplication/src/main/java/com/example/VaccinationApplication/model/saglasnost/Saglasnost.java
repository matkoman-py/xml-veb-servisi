
package com.example.VaccinationApplication.model.saglasnost;

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
 *         &lt;element name="Drzavljanstvo" type="{www.ftn.uns.ac.rs/Saglasnost}TDrzavljanstvo"/>
 *         &lt;element name="Podaci_o_pacijentu" type="{www.ftn.uns.ac.rs/Saglasnost}TPacijent"/>
 *         &lt;element name="Evidencija_o_vakcinaciji" type="{www.ftn.uns.ac.rs/Saglasnost}TEvidencija"/>
 *       &lt;/sequence>
 *       &lt;attribute name="about" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:parentTo" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "drzavljanstvo",
    "podaciOPacijentu",
    "evidencijaOVakcinaciji"
})
@XmlRootElement(name = "Saglasnost", namespace = "www.ftn.uns.ac.rs/Saglasnost")
public class Saglasnost {

    @XmlElement(name = "Drzavljanstvo", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected TDrzavljanstvo drzavljanstvo;
    @XmlElement(name = "Podaci_o_pacijentu", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected TPacijent podaciOPacijentu;
    @XmlElement(name = "Evidencija_o_vakcinaciji", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected TEvidencija evidencijaOVakcinaciji;
    @XmlAttribute(name = "about", required = true)
    protected String about;
    @XmlAttribute(name = "href")
    protected String href;
    @XmlAttribute(name = "rel")
    protected String rel;

    /**
     * Gets the value of the drzavljanstvo property.
     * 
     * @return
     *     possible object is
     *     {@link TDrzavljanstvo }
     *     
     */
    public TDrzavljanstvo getDrzavljanstvo() {
        return drzavljanstvo;
    }

    /**
     * Sets the value of the drzavljanstvo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDrzavljanstvo }
     *     
     */
    public void setDrzavljanstvo(TDrzavljanstvo value) {
        this.drzavljanstvo = value;
    }

    /**
     * Gets the value of the podaciOPacijentu property.
     * 
     * @return
     *     possible object is
     *     {@link TPacijent }
     *     
     */
    public TPacijent getPodaciOPacijentu() {
        return podaciOPacijentu;
    }

    /**
     * Sets the value of the podaciOPacijentu property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPacijent }
     *     
     */
    public void setPodaciOPacijentu(TPacijent value) {
        this.podaciOPacijentu = value;
    }

    /**
     * Gets the value of the evidencijaOVakcinaciji property.
     * 
     * @return
     *     possible object is
     *     {@link TEvidencija }
     *     
     */
    public TEvidencija getEvidencijaOVakcinaciji() {
        return evidencijaOVakcinaciji;
    }

    /**
     * Sets the value of the evidencijaOVakcinaciji property.
     * 
     * @param value
     *     allowed object is
     *     {@link TEvidencija }
     *     
     */
    public void setEvidencijaOVakcinaciji(TEvidencija value) {
        this.evidencijaOVakcinaciji = value;
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

}
