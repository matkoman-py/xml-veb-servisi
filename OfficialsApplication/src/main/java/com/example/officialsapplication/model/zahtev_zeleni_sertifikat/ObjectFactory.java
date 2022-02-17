
package com.example.officialsapplication.model.zahtev_zeleni_sertifikat;

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
     * Create an instance of {@link Zahtev }
     * 
     */
    public Zahtev createZahtev() {
        return new Zahtev();
    }

    /**
     * Create an instance of {@link TInformacijeOPodnosiocu }
     * 
     */
    public TInformacijeOPodnosiocu createTInformacijeOPodnosiocu() {
        return new TInformacijeOPodnosiocu();
    }

    /**
     * Create an instance of {@link TInformacijeOZahtevu }
     * 
     */
    public TInformacijeOZahtevu createTInformacijeOZahtevu() {
        return new TInformacijeOZahtevu();
    }

    /**
     * Create an instance of {@link TBrojPasosa }
     * 
     */
    public TBrojPasosa createTBrojPasosa() {
        return new TBrojPasosa();
    }

    /**
     * Create an instance of {@link TImePrezime }
     * 
     */
    public TImePrezime createTImePrezime() {
        return new TImePrezime();
    }

    /**
     * Create an instance of {@link TDatumIzdavanja }
     * 
     */
    public TDatumIzdavanja createTDatumIzdavanja() {
        return new TDatumIzdavanja();
    }

    /**
     * Create an instance of {@link TJmbg }
     * 
     */
    public TJmbg createTJmbg() {
        return new TJmbg();
    }

}
