
package com.example.VaccinationApplication.model.types.saglasnost;

import com.example.VaccinationApplication.model.documents.Saglasnost;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


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

    private final static QName _TVakcinacijaNezeljenaReakcija_QNAME = new QName("www.ftn.uns.ac.rs/Saglasnost", "Nezeljena_reakcija");
    private final static QName _TIzjavaSaglasnostiNazivLeka_QNAME = new QName("www.ftn.uns.ac.rs/Saglasnost", "Naziv_leka");
    private final static QName _TSocijalnaZastitaNazivOpstinaSedista_QNAME = new QName("www.ftn.uns.ac.rs/Saglasnost", "Naziv_opstina_sedista");
    private final static QName _TEvidencijaOdlukaKomisije_QNAME = new QName("www.ftn.uns.ac.rs/Saglasnost", "Odluka_komisije");
    private final static QName _TEvidencijaPrivremeneKontraindikacije_QNAME = new QName("www.ftn.uns.ac.rs/Saglasnost", "Privremene_kontraindikacije");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.VaccinationApplication.model.documents
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.ftn.uns.ac.rs/Saglasnost", name = "Nezeljena_reakcija", scope = TVakcinacija.class)
    public JAXBElement<String> createTVakcinacijaNezeljenaReakcija(String value) {
        return new JAXBElement<String>(_TVakcinacijaNezeljenaReakcija_QNAME, String.class, TVakcinacija.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.ftn.uns.ac.rs/Saglasnost", name = "Naziv_leka", scope = TIzjavaSaglasnosti.class)
    public JAXBElement<String> createTIzjavaSaglasnostiNazivLeka(String value) {
        return new JAXBElement<String>(_TIzjavaSaglasnostiNazivLeka_QNAME, String.class, TIzjavaSaglasnosti.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.ftn.uns.ac.rs/Saglasnost", name = "Naziv_opstina_sedista", scope = TSocijalnaZastita.class)
    public JAXBElement<String> createTSocijalnaZastitaNazivOpstinaSedista(String value) {
        return new JAXBElement<String>(_TSocijalnaZastitaNazivOpstinaSedista_QNAME, String.class, TSocijalnaZastita.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.ftn.uns.ac.rs/Saglasnost", name = "Odluka_komisije", scope = TEvidencija.class)
    public JAXBElement<String> createTEvidencijaOdlukaKomisije(String value) {
        return new JAXBElement<String>(_TEvidencijaOdlukaKomisije_QNAME, String.class, TEvidencija.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "www.ftn.uns.ac.rs/Saglasnost", name = "Privremene_kontraindikacije", scope = TEvidencija.class)
    public JAXBElement<String> createTEvidencijaPrivremeneKontraindikacije(String value) {
        return new JAXBElement<String>(_TEvidencijaPrivremeneKontraindikacije_QNAME, String.class, TEvidencija.class, value);
    }

}
