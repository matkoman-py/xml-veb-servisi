
package com.example.officialsapplication.model.users.izvestaj;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Datum_od" type="{http://www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji}TDatumOd"/>
 *         &lt;element name="Datum_do" type="{http://www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji}TDatumDo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPeriod", namespace = "http://www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", propOrder = {
    "datumOd",
    "datumDo"
})
public class TPeriod {

    @XmlElement(name = "Datum_od", namespace = "http://www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    protected TDatumOd datumOd;
    @XmlElement(name = "Datum_do", namespace = "http://www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji", required = true)
    protected TDatumDo datumDo;

    /**
     * Gets the value of the datumOd property.
     * 
     * @return
     *     possible object is
     *     {@link TDatumOd }
     *     
     */
    public TDatumOd getDatumOd() {
        return datumOd;
    }

    /**
     * Sets the value of the datumOd property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDatumOd }
     *     
     */
    public void setDatumOd(TDatumOd value) {
        this.datumOd = value;
    }

    /**
     * Gets the value of the datumDo property.
     * 
     * @return
     *     possible object is
     *     {@link TDatumDo }
     *     
     */
    public TDatumDo getDatumDo() {
        return datumDo;
    }

    /**
     * Sets the value of the datumDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDatumDo }
     *     
     */
    public void setDatumDo(TDatumDo value) {
        this.datumDo = value;
    }

}
