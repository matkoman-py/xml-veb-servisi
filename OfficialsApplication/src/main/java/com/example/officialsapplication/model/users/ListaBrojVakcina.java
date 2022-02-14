package com.example.officialsapplication.model.users;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "BrojVakcina"
})
@XmlRootElement(name = "ListaBrojVakcina")
public class ListaBrojVakcina {
    @XmlElement(name = "BrojVakcina")
    protected List<BrojVakcina> BrojVakcina;

    public List<BrojVakcina> getBrojVakcina() {
        return BrojVakcina;
    }

    public void setBrojVakcina(List<BrojVakcina> brojVakcina) {
        BrojVakcina = brojVakcina;
    }
}
