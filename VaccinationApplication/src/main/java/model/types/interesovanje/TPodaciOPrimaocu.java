
package model.types.interesovanje;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TPodaci_o_primaocu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPodaci_o_primaocu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Drzavljanstvo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Drzavljanin Republike Srbije "/>
 *               &lt;enumeration value="Strani drzavljanin sa boravkom u RS"/>
 *               &lt;enumeration value="Strani drzavljanin bez boravka u RS"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="JMBG">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="13"/>
 *               &lt;pattern value="\d{13}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Kontakt" type="{www.ftn.uns.ac.rs/interesovanje}TKontakt"/>
 *         &lt;element name="Davalac_krvi">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Da"/>
 *               &lt;enumeration value="Ne"/>
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
@XmlType(name = "TPodaci_o_primaocu", namespace = "www.ftn.uns.ac.rs/interesovanje", propOrder = {
    "drzavljanstvo",
    "jmbg",
    "ime",
    "prezime",
    "kontakt",
    "davalacKrvi"
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TPodaciOPrimaocu {

    @XmlElement(name = "Drzavljanstvo", namespace = "www.ftn.uns.ac.rs/interesovanje", required = true)
    protected String drzavljanstvo;
    @XmlElement(name = "JMBG", namespace = "www.ftn.uns.ac.rs/interesovanje", required = true)
    protected String jmbg;
    @XmlElement(name = "Ime", namespace = "www.ftn.uns.ac.rs/interesovanje", required = true)
    protected String ime;
    @XmlElement(name = "Prezime", namespace = "www.ftn.uns.ac.rs/interesovanje", required = true)
    protected String prezime;
    @XmlElement(name = "Kontakt", namespace = "www.ftn.uns.ac.rs/interesovanje", required = true)
    protected TKontakt kontakt;
    @XmlElement(name = "Davalac_krvi", namespace = "www.ftn.uns.ac.rs/interesovanje", required = true)
    protected String davalacKrvi;

    /**
     * Gets the value of the drzavljanstvo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    /**
     * Sets the value of the drzavljanstvo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrzavljanstvo(String value) {
        this.drzavljanstvo = value;
    }

    /**
     * Gets the value of the jmbg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJMBG() {
        return jmbg;
    }

    /**
     * Sets the value of the jmbg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJMBG(String value) {
        this.jmbg = value;
    }

    /**
     * Gets the value of the ime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the prezime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Sets the value of the prezime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrezime(String value) {
        this.prezime = value;
    }

    /**
     * Gets the value of the kontakt property.
     * 
     * @return
     *     possible object is
     *     {@link TKontakt }
     *     
     */
    public TKontakt getKontakt() {
        return kontakt;
    }

    /**
     * Sets the value of the kontakt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TKontakt }
     *     
     */
    public void setKontakt(TKontakt value) {
        this.kontakt = value;
    }

    /**
     * Gets the value of the davalacKrvi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDavalacKrvi() {
        return davalacKrvi;
    }

    /**
     * Sets the value of the davalacKrvi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDavalacKrvi(String value) {
        this.davalacKrvi = value;
    }

}
