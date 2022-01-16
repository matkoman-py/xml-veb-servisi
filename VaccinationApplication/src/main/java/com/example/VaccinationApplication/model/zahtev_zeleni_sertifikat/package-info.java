@XmlSchema(
        namespace = "http://www.ftn.uns.ac.rs/predicate/",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix="pred", namespaceURI="http://www.ftn.uns.ac.rs/predicate/"),
                @XmlNs(prefix="zzs", namespaceURI="http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata")
                        }
                )

package com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
