
package com.example.VaccinationApplication.model.documents;

import com.example.VaccinationApplication.model.types.zahtev_zelenog_sertifikata.TInformacijeOPodnosiocu;
import com.example.VaccinationApplication.model.types.zahtev_zelenog_sertifikata.TInformacijeOZahtevu;
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
 *         &lt;element name="Podnosilac_zahteva" type="{www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata}TInformacije_o_podnosiocu" form="qualified"/>
 *         &lt;element name="Informacije_o_zahtevu" type="{www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata}TInformacije_o_zahtevu"/>
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
    "podnosilacZahteva",
    "informacijeOZahtevu"
})
@XmlRootElement(name = "zahtev", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata")
public class Zahtev {

    public Zahtev(TInformacijeOPodnosiocu podnosilacZahteva, TInformacijeOZahtevu informacijeOZahtevu) {
        this.podnosilacZahteva = podnosilacZahteva;
        this.informacijeOZahtevu = informacijeOZahtevu;
    }

    public Zahtev() {
    }

    @XmlElement(name = "Podnosilac_zahteva", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected TInformacijeOPodnosiocu podnosilacZahteva;
    @XmlElement(name = "Informacije_o_zahtevu", namespace = "www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata", required = true)
    protected TInformacijeOZahtevu informacijeOZahtevu;

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

}
