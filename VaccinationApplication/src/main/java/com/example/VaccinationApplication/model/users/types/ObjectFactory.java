
package com.example.VaccinationApplication.model.users.types;


import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the java.com.example.VaccinationApplication package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: java.com.example.VaccinationApplication
     * 
     */
    public ObjectFactory() {
    }

//    /**
//     * Create an instance of {@link Pacijent }
//     *
//     */
//    public Pacijent createPacijent() {
//        return new Pacijent();
//    }

    /**
     * Create an instance of {@link TKontakt }
     * 
     */
    public TKontakt createTKontakt() {
        return new TKontakt();
    }

    /**
     * Create an instance of {@link TLokacija }
     * 
     */
    public TLokacija createTLokacija() {
        return new TLokacija();
    }

    /**
     * Create an instance of {@link TDrzavljanstvo }
     * 
     */
    public TDrzavljanstvo createTDrzavljanstvo() {
        return new TDrzavljanstvo();
    }

}
