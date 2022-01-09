
package com.example.VaccinationApplication.model.saglasnost;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TRadni_status.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TRadni_status">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="zaposlen"/>
 *     &lt;enumeration value="nezaposlen"/>
 *     &lt;enumeration value="penzioner"/>
 *     &lt;enumeration value="ucenik"/>
 *     &lt;enumeration value="student"/>
 *     &lt;enumeration value="dete"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TRadni_status", namespace = "www.ftn.uns.ac.rs/Saglasnost")
@XmlEnum
public enum TRadniStatus {

    @XmlEnumValue("zaposlen")
    ZAPOSLEN("zaposlen"),
    @XmlEnumValue("nezaposlen")
    NEZAPOSLEN("nezaposlen"),
    @XmlEnumValue("penzioner")
    PENZIONER("penzioner"),
    @XmlEnumValue("ucenik")
    UCENIK("ucenik"),
    @XmlEnumValue("student")
    STUDENT("student"),
    @XmlEnumValue("dete")
    DETE("dete");
    private final String value;

    TRadniStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TRadniStatus fromValue(String v) {
        for (TRadniStatus c: TRadniStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
