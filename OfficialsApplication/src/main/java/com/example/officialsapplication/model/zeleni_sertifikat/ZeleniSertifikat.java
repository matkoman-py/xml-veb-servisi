
package com.example.officialsapplication.model.zeleni_sertifikat;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="qr_kod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="broj_sertifikata" type="{http://www.ftn.uns.ac.rs/zelenisertifikat}TBrojSertifikata"/>
 *         &lt;element name="datum_izdavanja" type="{http://www.ftn.uns.ac.rs/zelenisertifikat}TDatumIzdavanja"/>
 *         &lt;element name="podaci_o_pacijentu" type="{http://www.ftn.uns.ac.rs/zelenisertifikat}TPacijent"/>
 *         &lt;element name="podaci_o_vakcinaciji" type="{http://www.ftn.uns.ac.rs/zelenisertifikat}TVakcinacija" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="about" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rel" type="{http://www.w3.org/2001/XMLSchema}string" fixed="pred:answerTo" />
 *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlRootElement(name = "zeleni_sertifikat", namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat")
public class ZeleniSertifikat {

    @XmlElement(name = "qr_kod", namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected String qrKod;
    @XmlElement(name = "broj_sertifikata", namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected TBrojSertifikata brojSertifikata;
    @XmlElement(name = "datum_izdavanja", namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected TDatumIzdavanja datumIzdavanja;
    @XmlElement(name = "podaci_o_pacijentu", namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected TPacijent podaciOPacijentu;
    @XmlElement(name = "podaci_o_vakcinaciji", namespace = "http://www.ftn.uns.ac.rs/zelenisertifikat", required = true)
    protected List<TVakcinacija> podaciOVakcinaciji;
    @XmlAttribute(name = "about", required = true)
    protected String about;
    @XmlAttribute(name = "rel")
    protected String rel;
    @XmlAttribute(name = "href")
    protected String href;

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
     *     {@link TBrojSertifikata }
     *     
     */
    public TBrojSertifikata getBrojSertifikata() {
        return brojSertifikata;
    }

    /**
     * Sets the value of the brojSertifikata property.
     * 
     * @param value
     *     allowed object is
     *     {@link TBrojSertifikata }
     *     
     */
    public void setBrojSertifikata(TBrojSertifikata value) {
        this.brojSertifikata = value;
    }

    /**
     * Gets the value of the datumIzdavanja property.
     * 
     * @return
     *     possible object is
     *     {@link TDatumIzdavanja }
     *     
     */
    public TDatumIzdavanja getDatumIzdavanja() {
        return datumIzdavanja;
    }

    /**
     * Sets the value of the datumIzdavanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDatumIzdavanja }
     *     
     */
    public void setDatumIzdavanja(TDatumIzdavanja value) {
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
     * Gets the value of the rel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRel() {
        if (rel == null) {
            return "pred:answerTo";
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

}
