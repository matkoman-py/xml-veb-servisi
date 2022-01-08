
package com.example.VaccinationApplication.model.types.izvestaj_o_imunizaciji;

import com.example.VaccinationApplication.model.documents.IzvestajOImunizaciji;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.VaccinationApplication.model.documents package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and com.example.VaccinationApplication.model
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.VaccinationApplication.model.documents
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IzvestajOImunizaciji }
     * 
     */
    public IzvestajOImunizaciji createIzvestajOImunizaciji() {
        return new IzvestajOImunizaciji();
    }

    /**
     * Create an instance of {@link TPeriod }
     * 
     */
    public TPeriod createTPeriod() {
        return new TPeriod();
    }

    /**
     * Create an instance of {@link TZeleniSertifikat }
     * 
     */
    public TZeleniSertifikat createTZeleniSertifikat() {
        return new TZeleniSertifikat();
    }

    /**
     * Create an instance of {@link TDozaInfo }
     * 
     */
    public TDozaInfo createTDozaInfo() {
        return new TDozaInfo();
    }

    /**
     * Create an instance of {@link TProizvodjaciInfo }
     * 
     */
    public TProizvodjaciInfo createTProizvodjaciInfo() {
        return new TProizvodjaciInfo();
    }

}