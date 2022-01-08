
package com.example.officialsapplication.model.types.izvestaj_o_imunizaciji;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TPeriod complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPeriod">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Datum_od" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Datum_do" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPeriod", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", propOrder = {
    "datumOd",
    "datumDo"
})
public class TPeriod {

    public TPeriod(XMLGregorianCalendar datumOd, XMLGregorianCalendar datumDo) {
        this.datumOd = datumOd;
        this.datumDo = datumDo;
    }

    public TPeriod() {
    }

    @XmlElement(name = "Datum_od", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumOd;
    @XmlElement(name = "Datum_do", namespace = "www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumDo;

    /**
     * Gets the value of the datumOd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumOd() {
        return datumOd;
    }

    /**
     * Sets the value of the datumOd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumOd(XMLGregorianCalendar value) {
        this.datumOd = value;
    }

    /**
     * Gets the value of the datumDo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumDo() {
        return datumDo;
    }

    /**
     * Sets the value of the datumDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumDo(XMLGregorianCalendar value) {
        this.datumDo = value;
    }

}
