@XmlSchema(
        namespace = "http://www.ftn.uns.ac.rs/predicate/",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix="pred", namespaceURI="http://www.ftn.uns.ac.rs/predicate/"),
                @XmlNs(prefix="sag", namespaceURI="http://www.ftn.uns.ac.rs/Saglasnost")
                        }
                )

package com.example.VaccinationApplication.model.saglasnost;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
