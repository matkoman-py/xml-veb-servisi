package com.example.VaccinationApplication.model;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "datumVreme",
        "jmbg",
        "vakcina"
})
@XmlRootElement(name = "Termin", namespace = "http://www.ftn.uns.ac.rs/termin")
public class Termin {

    @XmlElement(name = "datumVreme",  namespace = "http://www.ftn.uns.ac.rs/termin")
    protected XMLGregorianCalendar datumVreme;

    @XmlElement(name = "jmbg", namespace = "http://www.ftn.uns.ac.rs/termin")
    protected String jmbg;

    @XmlElement(name = "vakcina", namespace = "http://www.ftn.uns.ac.rs/termin")
    protected String vakcina;

    public XMLGregorianCalendar getDatumVreme() {
        return datumVreme;
    }

    public String getJmbg() {
        return jmbg;
    }

    public String getVakcina() {
        return vakcina;
    }

    public void setDatumVreme(XMLGregorianCalendar datumVreme) {
        this.datumVreme = datumVreme;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public void setVakcina(String vakcina) {
        this.vakcina = vakcina;
    }
}
