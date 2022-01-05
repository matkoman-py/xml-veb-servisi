
package model.types.izvestaj_o_imunizaciji;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TZeleni_sertifikat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TZeleni_sertifikat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Broj_primljenih_zahteva" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="Broj_izdatih_sertifikata" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TZeleni_sertifikat", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", propOrder = {
    "brojPrimljenihZahteva",
    "brojIzdatihSertifikata"
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TZeleniSertifikat {

    @XmlElement(name = "Broj_primljenih_zahteva", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger brojPrimljenihZahteva;
    @XmlElement(name = "Broj_izdatih_sertifikata", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger brojIzdatihSertifikata;

    /**
     * Gets the value of the brojPrimljenihZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojPrimljenihZahteva() {
        return brojPrimljenihZahteva;
    }

    /**
     * Sets the value of the brojPrimljenihZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojPrimljenihZahteva(BigInteger value) {
        this.brojPrimljenihZahteva = value;
    }

    /**
     * Gets the value of the brojIzdatihSertifikata property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojIzdatihSertifikata() {
        return brojIzdatihSertifikata;
    }

    /**
     * Sets the value of the brojIzdatihSertifikata property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojIzdatihSertifikata(BigInteger value) {
        this.brojIzdatihSertifikata = value;
    }

}
