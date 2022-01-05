
package model.types.saglasnost;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TPol.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TPol">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="muski"/>
 *     &lt;enumeration value="zenski"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TPol", namespace = "www.ftn.uns.ac.rs/Saglasnost")
@XmlEnum
public enum TPol {

    @XmlEnumValue("muski")
    MUSKI("muski"),
    @XmlEnumValue("zenski")
    ZENSKI("zenski");
    private final String value;

    TPol(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TPol fromValue(String v) {
        for (TPol c: TPol.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
