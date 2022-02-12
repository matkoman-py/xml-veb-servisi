package com.example.VaccinationApplication.model.saglasnost;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "Saglasnost"
})
@XmlRootElement(name = "ListaSaglasnosti")
public class ListaSaglasnosti {

	@XmlElement(name = "Saglasnost")
	protected List<Saglasnost> Saglasnost;
	
	public List<Saglasnost> getSaglasnost() {
        if (Saglasnost == null) {
        	Saglasnost = new ArrayList<Saglasnost>();
        }
        return this.Saglasnost;
    }

    public void setSaglasnost(List<Saglasnost> Saglasnost) {
        this.Saglasnost = Saglasnost;
    }
}
