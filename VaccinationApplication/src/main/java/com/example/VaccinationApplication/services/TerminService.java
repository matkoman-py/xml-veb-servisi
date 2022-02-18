package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.Termin;
import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import com.example.VaccinationApplication.model.potvrda.Potvrda;
import com.example.VaccinationApplication.model.potvrda.TVakcinacija;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class TerminService {

    private final String naCekanjuFolderId = "/db/vaccination-system/zahtevi-na-cekanju";
    private final String rezervisaniFolderId = "/db/vaccination-system/rezervisani-zahtevi";
    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final MetadataExtractor metadataExtractor;
    private RestTemplate restTemplate = new RestTemplate();
    private final MailSenderService mailSenderService;

    public TerminService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper, MetadataExtractor metadataExtractor,
                          MailSenderService mailSenderService) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
        this.metadataExtractor = metadataExtractor;
        this.mailSenderService = mailSenderService;
    }

    public void saveZaCekanje(Termin termin) throws DatatypeConfigurationException {
        Date dt = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dt);
        termin.setDatumVreme(DatatypeFactory.newInstance().newXMLGregorianCalendar(gc));
        dataAccessLayer.saveDocument(termin, naCekanjuFolderId, termin.getJmbg() + "-prva-doza.xml", Termin.class);
    }

    public Termin saveRezervisani(Termin termin) throws Exception {
        termin.setDatumVreme(nadjiPrviSlobodanTermin());
        dataAccessLayer.saveDocument(termin, rezervisaniFolderId, termin.getJmbg() + "-prva-doza.xml", Termin.class);
        dataAccessLayer.saveDocument(termin, rezervisaniFolderId, "poslednji-termin.xml", Termin.class);

        GregorianCalendar calendar = termin.getDatumVreme().toGregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, 21);
        termin.setDatumVreme(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
        dataAccessLayer.saveDocument(termin, rezervisaniFolderId, termin.getJmbg() + "-druga-doza.xml", Termin.class);
        calendar.add(Calendar.DAY_OF_MONTH, -21);
        termin.setDatumVreme(DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar));
        return termin;
    }

    private XMLGregorianCalendar nadjiPrviSlobodanTermin() throws Exception {
        String xPath = "//Termin";
        List<String> rezultat = dataAccessLayer
                .izvrsiXPathIzraz("/db/vaccination-system/rezervisani-zahtevi", xPath, "http://www.ftn.uns.ac.rs/termin");

        if(rezultat.size() == 0){
            Date dt = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.DATE, 1);
            c.set(Calendar.HOUR_OF_DAY, 8);
            c.set(Calendar.MINUTE, 0);
            dt = c.getTime();
            GregorianCalendar gc = new GregorianCalendar();

            // giving current date and time to gc
            gc.setTime(dt);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        }
        else{
            String poslednjiString = dataAccessLayer.getDocument(rezervisaniFolderId, "poslednji-termin").get();
            Termin poslednjiTermin = convertToObjectTermin(poslednjiString);
            XMLGregorianCalendar datum = poslednjiTermin.getDatumVreme();

            Date dt = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(dt);
            int result = datum.toGregorianCalendar().compareTo(gc);

            if(result <= 0) {
                gc.add(Calendar.DAY_OF_MONTH, 1);
                datum = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
                datum.setHour(8);
                datum.setMinute(0);
            }
            else if(datum.getHour() >= 16){
                GregorianCalendar calendar = datum.toGregorianCalendar();
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                datum = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
                datum.setHour(8);
                datum.setMinute(0);
            }
            else{
                if(datum.getMinute() + 15 == 60){
                    datum.setMinute(0);
                    datum.setHour(datum.getHour()+1);
                }
                else{
                    datum.setMinute(datum.getMinute() + 15);
                }
            }

            while(!daLiJeDatumSlobodan(datum)){
                if(datum.getHour() >= 16){
                    GregorianCalendar calendar = datum.toGregorianCalendar();
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                    datum = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
                    datum.setHour(8);
                    datum.setMinute(0);
                }
                else{
                    if(datum.getMinute() + 15 == 60){
                        datum.setMinute(0);
                        datum.setHour(datum.getHour()+1);
                    }
                    else{
                        datum.setMinute(datum.getMinute() + 15);
                    }
                }
            }
            return datum;
        }
    }

    public boolean daLiJeDatumSlobodan(XMLGregorianCalendar datum) throws Exception {
        String substring = datum.getYear()+"-"+format(datum.getMonth())+"-"+format(datum.getDay())+"T"+format(datum.getHour())+":"+
                format(datum.getMinute())+":"+format(datum.getSecond());
        String xPath = "//Termin[substring-before(datumVreme, '.') = '" + substring + "']";
        List<String> rezultat = dataAccessLayer
                .izvrsiXPathIzraz(rezervisaniFolderId, xPath, "http://www.ftn.uns.ac.rs/termin");
        if(rezultat.size()>0){
            return false;
        }
        return true;
    }

    private String format(int value) {
        if(value >= 10){
            return String.valueOf(value);
        }
        return "0"+value;
    }

    public Termin convertToObjectTermin(String xmlString) throws FileNotFoundException, TransformerException {
        return (Termin) mapper.convertToObject(xmlString, "Termin", Termin.class);
    }

    public boolean proveriBrojVakcina(String vakcina) {
        ResponseEntity<Integer> broj
                = restTemplate.getForEntity("http://localhost:8088/api/broj-vakcina/getBrojVakcina/"+vakcina, Integer.class);
        if(broj.getBody() > 1){
            return true;
        }
        return false;
    }

    public void smanjiBrojVakcina(String vakcina) {
        ResponseEntity<String> response = restTemplate
                .exchange("http://localhost:8088/api/broj-vakcina/smanjiBrojVakcina/"+vakcina,
                        HttpMethod.PUT,
                        null, String.class);
    }

    public String upisiNaCekanju(String vakcina) throws Exception {
        String xPath = "//Termin[vakcina = '" + vakcina + "']";
        List<String> rezultat = dataAccessLayer
                .izvrsiXPathIzraz(naCekanjuFolderId, xPath, "http://www.ftn.uns.ac.rs/termin");
        for(String terminString : rezultat){
            Termin termin = convertToObjectTermin(terminString);
            if (!proveriBrojVakcina(termin.getVakcina())) {
                break;
            } else {
                Termin sacuvani = saveRezervisani(termin);
                //delete na cekanju
                dataAccessLayer.deleteDocument(termin, naCekanjuFolderId, termin.getJmbg() + "-prva-doza.xml", Termin.class);
                Interesovanje interesovanje = getOneForUser(sacuvani.getJmbg());
                mailSenderService.posaljiRezervisan(interesovanje.getPodaciOPrimaocu().getKontakt().getAdresaElektronskePoste(),
                        sacuvani, interesovanje);
                smanjiBrojVakcina(termin.getVakcina());
                smanjiBrojVakcina(termin.getVakcina());
            }
        }
        return "Success";
    }

    public String proveriTermin(String id) throws Exception {
        Optional<String> prvaDoza = dataAccessLayer.getDocument(rezervisaniFolderId, id+"-prva-doza");
        Optional<String> drugaDoza = dataAccessLayer.getDocument(rezervisaniFolderId, id+"-druga-doza");

        if(drugaDoza.isPresent()){
            Termin terminPrve = convertToObjectTermin(prvaDoza.get());
            Termin terminDruge = convertToObjectTermin(drugaDoza.get());
            Date dt = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(dt);
            int result = terminPrve.getDatumVreme().toGregorianCalendar().compareTo(gc);
            if(result > 0){
                return "-prva-doza";
            }
            return "-druga-doza";
        }


        return "";
    }

    public Interesovanje getOneForUser(String id) throws Exception {
        String xPath = "//interesovanje[Podaci_o_primaocu/JMBG = '" + id + "']";
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/interesovanja", xPath, "http://www.ftn.uns.ac.rs/interesovanje");
        return convertToObject(rezultat.get(0));
    }

    public Interesovanje convertToObject(String xmlString) throws FileNotFoundException, TransformerException {
        return (Interesovanje) mapper.convertToObject(xmlString, "Interesovanje", Interesovanje.class);
    }

    public String proveriVakcinu(String jmbg) throws FileNotFoundException, TransformerException {
        Optional<String> prvaDoza = dataAccessLayer.getDocument(rezervisaniFolderId, jmbg+"-prva-doza");
        Optional<String> drugaDoza = dataAccessLayer.getDocument(rezervisaniFolderId, jmbg+"-druga-doza");

        if(drugaDoza.isPresent()){
            Termin terminPrve = convertToObjectTermin(prvaDoza.get());
            return terminPrve.getVakcina();
        }
        return "";
    }

    public void posaljiMejlZaDrugiTermin(String jmbg) throws FileNotFoundException, TransformerException, MessagingException {
        Optional<String> drugaDoza = dataAccessLayer.getDocument(rezervisaniFolderId, jmbg+"-druga-doza");
        Optional<String> interesovanjeString = dataAccessLayer.getDocument("/db/vaccination-system/interesovanja", jmbg);
        Interesovanje interesovanje = convertToObject(interesovanjeString.get());
        Termin terminDruge = convertToObjectTermin(drugaDoza.get());
        mailSenderService.posaljiRezervisan(interesovanje.getPodaciOPrimaocu().getKontakt().getAdresaElektronskePoste(), terminDruge,interesovanje);
    }
}
