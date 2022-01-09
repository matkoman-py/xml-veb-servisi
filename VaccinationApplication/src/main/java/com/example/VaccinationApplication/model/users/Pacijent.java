//
//package com.example.VaccinationApplication.model.users;
//
//import com.example.VaccinationApplication.model.users.types.TDrzavljanstvo;
//import com.example.VaccinationApplication.model.users.types.TKontakt;
//import com.example.VaccinationApplication.model.users.types.TLokacija;
//
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlSchemaType;
//import javax.xml.bind.annotation.XmlType;
//import javax.xml.datatype.XMLGregorianCalendar;
//
//
///**
// * <p>Java class for anonymous complex type.
// *
// * <p>The following schema fragment specifies the expected content contained within this class.
// *
// * <pre>
// * &lt;complexType>
// *   &lt;complexContent>
// *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
// *       &lt;sequence>
// *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
// *         &lt;element name="sifra" type="{http://www.w3.org/2001/XMLSchema}string"/>
// *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
// *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
// *         &lt;element name="rodjendan" type="{http://www.w3.org/2001/XMLSchema}date"/>
// *         &lt;element name="pol">
// *           &lt;simpleType>
// *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
// *               &lt;enumeration value="Musko"/>
// *               &lt;enumeration value="Zensko"/>
// *             &lt;/restriction>
// *           &lt;/simpleType>
// *         &lt;/element>
// *         &lt;element name="kontakt" type="{}TKontakt"/>
// *         &lt;element name="lokacija" type="{}TLokacija"/>
// *         &lt;element name="drzavljanstvo" type="{}TDrzavljanstvo"/>
// *       &lt;/sequence>
// *     &lt;/restriction>
// *   &lt;/complexContent>
// * &lt;/complexType>
// * </pre>
// *
// *
// */
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "", propOrder = {
//    "email",
//    "sifra",
//    "ime",
//    "prezime",
//    "rodjendan",
//    "pol",
//    "kontakt",
//    "lokacija",
//    "drzavljanstvo"
//})
//@XmlRootElement(name = "Pacijent")
//public class Pacijent {
//
//    public Pacijent(String email, String sifra, String ime, String prezime, XMLGregorianCalendar rodjendan, String pol, TKontakt kontakt, TLokacija lokacija, TDrzavljanstvo drzavljanstvo) {
//        this.email = email;
//        this.sifra = sifra;
//        this.ime = ime;
//        this.prezime = prezime;
//        this.rodjendan = rodjendan;
//        this.pol = pol;
//        this.kontakt = kontakt;
//        this.lokacija = lokacija;
//        this.drzavljanstvo = drzavljanstvo;
//    }
//
//    public Pacijent() {
//    }
//
//    @XmlElement(required = true)
//    protected String email;
//    @XmlElement(required = true)
//    protected String sifra;
//    @XmlElement(required = true)
//    protected String ime;
//    @XmlElement(required = true)
//    protected String prezime;
//    @XmlElement(required = true)
//    @XmlSchemaType(name = "date")
//    protected XMLGregorianCalendar rodjendan;
//    @XmlElement(required = true)
//    protected String pol;
//    @XmlElement(required = true)
//    protected TKontakt kontakt;
//    @XmlElement(required = true)
//    protected TLokacija lokacija;
//    @XmlElement(required = true)
//    protected TDrzavljanstvo drzavljanstvo;
//
//    /**
//     * Gets the value of the email property.
//     *
//     * @return
//     *     possible object is
//     *     {@link String }
//     *
//     */
//    public String getEmail() {
//        return email;
//    }
//
//    /**
//     * Sets the value of the email property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *
//     */
//    public void setEmail(String value) {
//        this.email = value;
//    }
//
//    /**
//     * Gets the value of the sifra property.
//     *
//     * @return
//     *     possible object is
//     *     {@link String }
//     *
//     */
//    public String getSifra() {
//        return sifra;
//    }
//
//    /**
//     * Sets the value of the sifra property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *
//     */
//    public void setSifra(String value) {
//        this.sifra = value;
//    }
//
//    /**
//     * Gets the value of the ime property.
//     *
//     * @return
//     *     possible object is
//     *     {@link String }
//     *
//     */
//    public String getIme() {
//        return ime;
//    }
//
//    /**
//     * Sets the value of the ime property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *
//     */
//    public void setIme(String value) {
//        this.ime = value;
//    }
//
//    /**
//     * Gets the value of the prezime property.
//     *
//     * @return
//     *     possible object is
//     *     {@link String }
//     *
//     */
//    public String getPrezime() {
//        return prezime;
//    }
//
//    /**
//     * Sets the value of the prezime property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *
//     */
//    public void setPrezime(String value) {
//        this.prezime = value;
//    }
//
//    /**
//     * Gets the value of the rodjendan property.
//     *
//     * @return
//     *     possible object is
//     *     {@link XMLGregorianCalendar }
//     *
//     */
//    public XMLGregorianCalendar getRodjendan() {
//        return rodjendan;
//    }
//
//    /**
//     * Sets the value of the rodjendan property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link XMLGregorianCalendar }
//     *
//     */
//    public void setRodjendan(XMLGregorianCalendar value) {
//        this.rodjendan = value;
//    }
//
//    /**
//     * Gets the value of the pol property.
//     *
//     * @return
//     *     possible object is
//     *     {@link String }
//     *
//     */
//    public String getPol() {
//        return pol;
//    }
//
//    /**
//     * Sets the value of the pol property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link String }
//     *
//     */
//    public void setPol(String value) {
//        this.pol = value;
//    }
//
//    /**
//     * Gets the value of the kontakt property.
//     *
//     * @return
//     *     possible object is
//     *     {@link TKontakt }
//     *
//     */
//    public TKontakt getKontakt() {
//        return kontakt;
//    }
//
//    /**
//     * Sets the value of the kontakt property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link TKontakt }
//     *
//     */
//    public void setKontakt(TKontakt value) {
//        this.kontakt = value;
//    }
//
//    /**
//     * Gets the value of the lokacija property.
//     *
//     * @return
//     *     possible object is
//     *     {@link TLokacija }
//     *
//     */
//    public TLokacija getLokacija() {
//        return lokacija;
//    }
//
//    /**
//     * Sets the value of the lokacija property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link TLokacija }
//     *
//     */
//    public void setLokacija(TLokacija value) {
//        this.lokacija = value;
//    }
//
//    /**
//     * Gets the value of the drzavljanstvo property.
//     *
//     * @return
//     *     possible object is
//     *     {@link TDrzavljanstvo }
//     *
//     */
//    public TDrzavljanstvo getDrzavljanstvo() {
//        return drzavljanstvo;
//    }
//
//    /**
//     * Sets the value of the drzavljanstvo property.
//     *
//     * @param value
//     *     allowed object is
//     *     {@link TDrzavljanstvo }
//     *
//     */
//    public void setDrzavljanstvo(TDrzavljanstvo value) {
//        this.drzavljanstvo = value;
//    }
//
//}
