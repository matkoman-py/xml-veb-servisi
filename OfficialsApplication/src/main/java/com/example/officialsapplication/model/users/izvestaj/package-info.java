@XmlSchema(
        namespace = "http://www.ftn.uns.ac.rs/predicate/",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix="pred", namespaceURI="http://www.ftn.uns.ac.rs/predicate"),
                @XmlNs(prefix="izv", namespaceURI="http://www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji")
                        }
                )

package com.example.officialsapplication.model.users.izvestaj;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
