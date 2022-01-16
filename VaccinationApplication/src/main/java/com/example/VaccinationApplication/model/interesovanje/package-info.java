@XmlSchema(
        namespace = "http://www.ftn.uns.ac.rs/predicate/",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix="pred", namespaceURI="http://www.ftn.uns.ac.rs/predicate/"),
                @XmlNs(prefix="int", namespaceURI="http://www.ftn.uns.ac.rs/interesovanje")
                        }
                )

package com.example.VaccinationApplication.model.interesovanje;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
