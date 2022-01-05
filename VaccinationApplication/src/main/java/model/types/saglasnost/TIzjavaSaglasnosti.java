
package model.types.saglasnost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TIzjava_saglasnosti complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TIzjava_saglasnosti">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Saglasan">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="saglasan sam"/>
 *               &lt;enumeration value="nisam saglasan"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Naziv_leka" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIzjava_saglasnosti", namespace = "www.ftn.uns.ac.rs/Saglasnost", propOrder = {
    "saglasan",
    "nazivLeka"
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TIzjavaSaglasnosti {

    @XmlElement(name = "Saglasan", namespace = "www.ftn.uns.ac.rs/Saglasnost", required = true)
    protected String saglasan;
    @XmlElementRef(name = "Naziv_leka", namespace = "www.ftn.uns.ac.rs/Saglasnost", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nazivLeka;

    /**
     * Gets the value of the saglasan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaglasan() {
        return saglasan;
    }

    /**
     * Sets the value of the saglasan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaglasan(String value) {
        this.saglasan = value;
    }

    /**
     * Gets the value of the nazivLeka property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNazivLeka() {
        return nazivLeka;
    }

    /**
     * Sets the value of the nazivLeka property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNazivLeka(JAXBElement<String> value) {
        this.nazivLeka = value;
    }

}
