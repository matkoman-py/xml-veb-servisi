
package model.types.interesovanje;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TKontakt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TKontakt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Adresa_elektronske_poste">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9\-.]+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Broj_mobilnog_telefona">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="06\d{8}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Broj_fiksnog_telefona">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="0[1-2]{1}\d{7}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TKontakt", namespace = "www.ftn.uns.ac.rs/interesovanje", propOrder = {
    "adresaElektronskePoste",
    "brojMobilnogTelefona",
    "brojFiksnogTelefona"
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TKontakt {

    @XmlElement(name = "Adresa_elektronske_poste", namespace = "www.ftn.uns.ac.rs/interesovanje", required = true)
    protected String adresaElektronskePoste;
    @XmlElement(name = "Broj_mobilnog_telefona", namespace = "www.ftn.uns.ac.rs/interesovanje", required = true)
    protected String brojMobilnogTelefona;
    @XmlElement(name = "Broj_fiksnog_telefona", namespace = "www.ftn.uns.ac.rs/interesovanje", required = true)
    protected String brojFiksnogTelefona;

    /**
     * Gets the value of the adresaElektronskePoste property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresaElektronskePoste() {
        return adresaElektronskePoste;
    }

    /**
     * Sets the value of the adresaElektronskePoste property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresaElektronskePoste(String value) {
        this.adresaElektronskePoste = value;
    }

    /**
     * Gets the value of the brojMobilnogTelefona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojMobilnogTelefona() {
        return brojMobilnogTelefona;
    }

    /**
     * Sets the value of the brojMobilnogTelefona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojMobilnogTelefona(String value) {
        this.brojMobilnogTelefona = value;
    }

    /**
     * Gets the value of the brojFiksnogTelefona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojFiksnogTelefona() {
        return brojFiksnogTelefona;
    }

    /**
     * Sets the value of the brojFiksnogTelefona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojFiksnogTelefona(String value) {
        this.brojFiksnogTelefona = value;
    }

}
