
package com.example.VaccinationApplication.model.potvrda;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for TJmbg complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TJmbg">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="property" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="pred:jmbg" />
 *       &lt;attribute name="datatype" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="xs:string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TJmbg", namespace = "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji", propOrder = {
    "value"
})
public class TJmbg {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "property", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String property;
    @XmlAttribute(name = "datatype", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String datatype;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the property property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperty() {
        if (property == null) {
            return "pred:jmbg";
        } else {
            return property;
        }
    }

    /**
     * Sets the value of the property property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperty(String value) {
        this.property = value;
    }

    /**
     * Gets the value of the datatype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatatype() {
        if (datatype == null) {
            return "xs:string";
        } else {
            return datatype;
        }
    }

    /**
     * Sets the value of the datatype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatatype(String value) {
        this.datatype = value;
    }

}
