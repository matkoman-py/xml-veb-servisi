
package com.example.VaccinationApplication.model.saglasnost;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TZanimanje.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TZanimanje">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="zdravstvena_zastita"/>
 *     &lt;enumeration value="socijalna_zastita"/>
 *     &lt;enumeration value="prosveta"/>
 *     &lt;enumeration value="MUP"/>
 *     &lt;enumeration value="vojska_rs"/>
 *     &lt;enumeration value="drugo"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TZanimanje", namespace = "http://www.ftn.uns.ac.rs/Saglasnost")
@XmlEnum
public enum TZanimanje {

    @XmlEnumValue("zdravstvena_zastita")
    ZDRAVSTVENA_ZASTITA("zdravstvena_zastita"),
    @XmlEnumValue("socijalna_zastita")
    SOCIJALNA_ZASTITA("socijalna_zastita"),
    @XmlEnumValue("prosveta")
    PROSVETA("prosveta"),
    MUP("MUP"),
    @XmlEnumValue("vojska_rs")
    VOJSKA_RS("vojska_rs"),
    @XmlEnumValue("drugo")
    DRUGO("drugo");
    private final String value;

    TZanimanje(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TZanimanje fromValue(String v) {
        for (TZanimanje c: TZanimanje.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
