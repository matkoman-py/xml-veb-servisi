package com.example.VaccinationApplication.model.interesovanje;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "Interesovanje"
})
@XmlRootElement(name = "ListaInteresovanja")
public class ListaInteresovanja {

	@XmlElement(name = "Interesovanje")
	protected List<Interesovanje> Interesovanje;
	
	public List<Interesovanje> getIzvestaj() {
        if (Interesovanje == null) {
        	Interesovanje = new ArrayList<Interesovanje>();
        }
        return this.Interesovanje;
    }

    public void setIzvestaj(List<Interesovanje> Interesovanje) {
        this.Interesovanje = Interesovanje;
    }
}
