
package model.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.types.saglasnost.TDrzavljanstvo;
import model.types.saglasnost.TEvidencija;
import model.types.saglasnost.TPacijent;

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
 *         &lt;element name="Drzavljanstvo" type="{www.ftn.uns.ac.rs/Saglasnost}TDrzavljanstvo"/>
 *         &lt;element name="Podaci_o_pacijentu" type="{www.ftn.uns.ac.rs/Saglasnost}TPacijent"/>
 *         &lt;element name="Evidencija_o_vakcinaciji" type="{www.ftn.uns.ac.rs/Saglasnost}TEvidencija"/>
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
    "drzavljanstvo",
    "podaciOPacijentu",
    "evidencijaOVakcinaciji"
})
@XmlRootElement(name = "Saglasnost", namespace = "www.ftn.uns.ac.rs/Saglasnost")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Saglasnost {

    @XmlElement(name = "Drzavljanstvo", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected TDrzavljanstvo drzavljanstvo;
    @XmlElement(name = "Podaci_o_pacijentu", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected TPacijent podaciOPacijentu;
    @XmlElement(name = "Evidencija_o_vakcinaciji", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected TEvidencija evidencijaOVakcinaciji;

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

}
