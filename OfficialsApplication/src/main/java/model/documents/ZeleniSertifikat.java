
package model.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.types.zeleni_sertifikat.TPacijent;
import model.types.zeleni_sertifikat.TVakcinacija;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="qr_kod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="broj_sertifikata">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="\d{6,}[/]\d{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="datum_izdavanja" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="podaci_o_pacijentu" type="{www.ftn.uns.ac.rs/zelenisertifikat}TPacijent"/>
 *         &lt;element name="podaci_o_vakcinaciji" type="{www.ftn.uns.ac.rs/zelenisertifikat}TVakcinacija" maxOccurs="unbounded"/>
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
    "qrKod",
    "brojSertifikata",
    "datumIzdavanja",
    "podaciOPacijentu",
    "podaciOVakcinaciji"
})
@XmlRootElement(name = "zeleni_sertifikat", namespace = "www.ftn.uns.ac.rs/zelenisertifikat")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ZeleniSertifikat {

    @XmlElement(name = "qr_kod", namespace = "www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected String qrKod;
    @XmlElement(name = "broj_sertifikata", namespace = "www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected String brojSertifikata;
    @XmlElement(name = "datum_izdavanja", namespace = "www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumIzdavanja;
    @XmlElement(name = "podaci_o_pacijentu", namespace = "www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected TPacijent podaciOPacijentu;
    @XmlElement(name = "podaci_o_vakcinaciji", namespace = "www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected List<TVakcinacija> podaciOVakcinaciji;

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
     * Gets the value of the brojSertifikata property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojSertifikata() {
        return brojSertifikata;
    }

    /**
     * Sets the value of the brojSertifikata property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojSertifikata(String value) {
        this.brojSertifikata = value;
    }

    /**
     * Gets the value of the datumIzdavanja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumIzdavanja() {
        return datumIzdavanja;
    }

    /**
     * Sets the value of the datumIzdavanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumIzdavanja(XMLGregorianCalendar value) {
        this.datumIzdavanja = value;
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
     * Gets the value of the podaciOVakcinaciji property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the podaciOVakcinaciji property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPodaciOVakcinaciji().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TVakcinacija }
     * 
     * 
     */
    public List<TVakcinacija> getPodaciOVakcinaciji() {
        if (podaciOVakcinaciji == null) {
            podaciOVakcinaciji = new ArrayList<TVakcinacija>();
        }
        return this.podaciOVakcinaciji;
    }

}
