
package com.example.VaccinationApplication.model.types.saglasnost;

import com.example.VaccinationApplication.model.documents.Saglasnost;

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
     * Create an instance of {@link Saglasnost }
     * 
     */
    public Saglasnost createSaglasnost() {
        return new Saglasnost();
    }

    /**
     * Create an instance of {@link TDrzavljanstvo }
     * 
     */
    public TDrzavljanstvo createTDrzavljanstvo() {
        return new TDrzavljanstvo();
    }

    /**
     * Create an instance of {@link TPacijent }
     * 
     */
    public TPacijent createTPacijent() {
        return new TPacijent();
    }

    /**
     * Create an instance of {@link TEvidencija }
     * 
     */
    public TEvidencija createTEvidencija() {
        return new TEvidencija();
    }

    /**
     * Create an instance of {@link TSocijalnaZastita }
     * 
     */
    public TSocijalnaZastita createTSocijalnaZastita() {
        return new TSocijalnaZastita();
    }

    /**
     * Create an instance of {@link TAdresa }
     * 
     */
    public TAdresa createTAdresa() {
        return new TAdresa();
    }

    /**
     * Create an instance of {@link TIzjavaSaglasnosti }
     * 
     */
    public TIzjavaSaglasnosti createTIzjavaSaglasnosti() {
        return new TIzjavaSaglasnosti();
    }

    /**
     * Create an instance of {@link TKontakt }
     * 
     */
    public TKontakt createTKontakt() {
        return new TKontakt();
    }

    /**
     * Create an instance of {@link TVakcinacija }
     * 
     */
    public TVakcinacija createTVakcinacija() {
        return new TVakcinacija();
    }

}
