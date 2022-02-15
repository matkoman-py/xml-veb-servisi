package com.example.officialsapplication.model.users;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "broj",
        "vakcina"
})
@XmlRootElement(name = "BrojVakcina", namespace = "http://www.ftn.uns.ac.rs/broj-vakcina")
public class BrojVakcina {

    @XmlElement(name = "broj", namespace = "http://www.ftn.uns.ac.rs/broj-vakcina")
    protected int broj;

    @XmlElement(name = "vakcina", namespace = "http://www.ftn.uns.ac.rs/broj-vakcina")
    protected String vakcina;

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public String getVakcina() {
        return vakcina;
    }

    public void setVakcina(String vakcina) {
        this.vakcina = vakcina;
    }
}
