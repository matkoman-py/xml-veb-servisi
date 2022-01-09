
package com.example.officialsapplication.model.users.izvestaj;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="Period" type="{www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji}TPeriod"/>
 *         &lt;element name="Broj_podnetih_interesovanja" type="{www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji}TBrojPodnetihInteresovanja"/>
 *         &lt;element name="Zeleni_sertifikat_info" type="{www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji}TZeleni_sertifikat"/>
 *         &lt;element name="Doza_info" type="{www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji}TDoza_info"/>
 *         &lt;element name="Proizvodjaci_info" type="{www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji}TProizvodjaci_info"/>
 *         &lt;element name="Datum_izdavanja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *       &lt;attribute name="about" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "period",
    "brojPodnetihInteresovanja",
    "zeleniSertifikatInfo",
    "dozaInfo",
    "proizvodjaciInfo",
    "datumIzdavanja"
})
@XmlRootElement(name = "Izvestaj_o_imunizaciji", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji")
public class IzvestajOImunizaciji {

    @XmlElement(name = "Period", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    protected TPeriod period;
    @XmlElement(name = "Broj_podnetih_interesovanja", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    protected TBrojPodnetihInteresovanja brojPodnetihInteresovanja;
    @XmlElement(name = "Zeleni_sertifikat_info", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    protected TZeleniSertifikat zeleniSertifikatInfo;
    @XmlElement(name = "Doza_info", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    protected TDozaInfo dozaInfo;
    @XmlElement(name = "Proizvodjaci_info", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    protected TProizvodjaciInfo proizvodjaciInfo;
    @XmlElement(name = "Datum_izdavanja", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumIzdavanja;
    @XmlAttribute(name = "about", required = true)
    protected String about;
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger id;

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link TPeriod }
     *     
     */
    public TPeriod getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPeriod }
     *     
     */
    public void setPeriod(TPeriod value) {
        this.period = value;
    }

    /**
     * Gets the value of the brojPodnetihInteresovanja property.
     * 
     * @return
     *     possible object is
     *     {@link TBrojPodnetihInteresovanja }
     *     
     */
    public TBrojPodnetihInteresovanja getBrojPodnetihInteresovanja() {
        return brojPodnetihInteresovanja;
    }

    /**
     * Sets the value of the brojPodnetihInteresovanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link TBrojPodnetihInteresovanja }
     *     
     */
    public void setBrojPodnetihInteresovanja(TBrojPodnetihInteresovanja value) {
        this.brojPodnetihInteresovanja = value;
    }

    /**
     * Gets the value of the zeleniSertifikatInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TZeleniSertifikat }
     *     
     */
    public TZeleniSertifikat getZeleniSertifikatInfo() {
        return zeleniSertifikatInfo;
    }

    /**
     * Sets the value of the zeleniSertifikatInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TZeleniSertifikat }
     *     
     */
    public void setZeleniSertifikatInfo(TZeleniSertifikat value) {
        this.zeleniSertifikatInfo = value;
    }

    /**
     * Gets the value of the dozaInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TDozaInfo }
     *     
     */
    public TDozaInfo getDozaInfo() {
        return dozaInfo;
    }

    /**
     * Sets the value of the dozaInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDozaInfo }
     *     
     */
    public void setDozaInfo(TDozaInfo value) {
        this.dozaInfo = value;
    }

    /**
     * Gets the value of the proizvodjaciInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TProizvodjaciInfo }
     *     
     */
    public TProizvodjaciInfo getProizvodjaciInfo() {
        return proizvodjaciInfo;
    }

    /**
     * Sets the value of the proizvodjaciInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TProizvodjaciInfo }
     *     
     */
    public void setProizvodjaciInfo(TProizvodjaciInfo value) {
        this.proizvodjaciInfo = value;
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
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

}
