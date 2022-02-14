@XmlSchema(
        namespace = "http://www.ftn.uns.ac.rs/predicate/",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix="pred", namespaceURI="http://www.ftn.uns.ac.rs/predicate/"),
                @XmlNs(prefix="pot", namespaceURI="http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji")
                        }
                )

package com.example.officialsapplication.model.potvrda;


import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
