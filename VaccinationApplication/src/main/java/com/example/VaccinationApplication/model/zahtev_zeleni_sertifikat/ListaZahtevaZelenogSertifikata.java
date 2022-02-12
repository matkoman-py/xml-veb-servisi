package com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "Zahtev"
})
@XmlRootElement(name = "ListaZahtevaZelenogSertifikata")
public class ListaZahtevaZelenogSertifikata {

	@XmlElement(name = "Zahtev")
	protected List<Zahtev> Zahtev;
	
	public List<Zahtev> getZahtev() {
        if (Zahtev == null) {
        	Zahtev = new ArrayList<Zahtev>();
        }
        return this.Zahtev;
    }

    public void setZahtev(List<Zahtev> Zahtev) {
        this.Zahtev = Zahtev;
    }
}
