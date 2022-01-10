
package com.example.VaccinationApplication.model.interesovanje;

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

    /**
     * Create an instance of {@link Interesovanje }
     * 
     */
    public Interesovanje createInteresovanje() {
        return new Interesovanje();
    }

    /**
     * Create an instance of {@link TPodaciOPrimaocu }
     * 
     */
    public TPodaciOPrimaocu createTPodaciOPrimaocu() {
        return new TPodaciOPrimaocu();
    }

    /**
     * Create an instance of {@link TDatumIzdavanja }
     * 
     */
    public TDatumIzdavanja createTDatumIzdavanja() {
        return new TDatumIzdavanja();
    }

    /**
     * Create an instance of {@link TPrezime }
     * 
     */
    public TPrezime createTPrezime() {
        return new TPrezime();
    }

    /**
     * Create an instance of {@link TKontakt }
     * 
     */
    public TKontakt createTKontakt() {
        return new TKontakt();
    }

    /**
     * Create an instance of {@link TIme }
     * 
     */
    public TIme createTIme() {
        return new TIme();
    }

    /**
     * Create an instance of {@link TJmbg }
     * 
     */
    public TJmbg createTJmbg() {
        return new TJmbg();
    }

}
