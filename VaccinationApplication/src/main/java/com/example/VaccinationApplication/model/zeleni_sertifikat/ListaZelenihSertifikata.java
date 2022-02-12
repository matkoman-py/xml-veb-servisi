package com.example.VaccinationApplication.model.zeleni_sertifikat;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ZeleniSertifikati"
})
@XmlRootElement(name = "ListaZelenihSertifikata")
public class ListaZelenihSertifikata {

	@XmlElement(name = "ZeleniSertifikati")
	protected List<ZeleniSertifikat> ZeleniSertifikati;
	
	public List<ZeleniSertifikat> getZeleniSertifikati() {
        if (ZeleniSertifikati == null) {
        	ZeleniSertifikati = new ArrayList<ZeleniSertifikat>();
        }
        return this.ZeleniSertifikati;
    }

    public void setIzvestaj(List<ZeleniSertifikat> ZeleniSertifikati) {
        this.ZeleniSertifikati = ZeleniSertifikati;
    }
}

