
package com.example.VaccinationApplication.model.documents;

import com.example.VaccinationApplication.model.types.potvrda_o_vakcinaciji.TPacijent;
import com.example.VaccinationApplication.model.types.potvrda_o_vakcinaciji.TVakcinacija;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="Sifra_potvrde" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pacijent" type="{www.ftn.uns.ac.rs/potvrda_o_vakcinaciji}TPacijent"/>
 *         &lt;element name="Vakcinacija_info" type="{www.ftn.uns.ac.rs/potvrda_o_vakcinaciji}TVakcinacija"/>
 *         &lt;element name="Qr_kod" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "sifraPotvrde",
    "pacijent",
    "vakcinacijaInfo",
    "qrKod"
})
@XmlRootElement(name = "Potvrda", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji")
public class Potvrda {

    public Potvrda(String sifraPotvrde, TPacijent pacijent, TVakcinacija vakcinacijaInfo, String qrKod) {
        this.sifraPotvrde = sifraPotvrde;
        this.pacijent = pacijent;
        this.vakcinacijaInfo = vakcinacijaInfo;
        this.qrKod = qrKod;
    }

    public Potvrda() {
    }

    @XmlElement(name = "Sifra_potvrde", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected String sifraPotvrde;
    @XmlElement(namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected TPacijent pacijent;
    @XmlElement(name = "Vakcinacija_info", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected TVakcinacija vakcinacijaInfo;
    @XmlElement(name = "Qr_kod", namespace = "www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", required = true)
    protected String qrKod;

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

}
