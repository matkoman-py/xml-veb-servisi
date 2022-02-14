package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.Termin;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class TerminService {

    private final String naCekanjuFolderId = "/db/vaccination-system/zahtevi-na-cekanju";
    private final String rezervisaniFolderId = "/db/vaccination-system/rezervisani-zahtevi";
    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final MetadataExtractor metadataExtractor;

    public TerminService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper, MetadataExtractor metadataExtractor) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
        this.metadataExtractor = metadataExtractor;
    }

    public void saveZaCekanje(Termin termin){
        dataAccessLayer.saveDocument(termin, naCekanjuFolderId, termin.getJmbg() + "-prva-doza.xml", Termin.class);
    }

    public Termin saveRezervisani(Termin termin) throws Exception {
        termin.setDatumVreme(nadjiPrviSlobodanTermin());
        dataAccessLayer.saveDocument(termin, rezervisaniFolderId, termin.getJmbg() + "-prva-doza.xml", Termin.class);
        dataAccessLayer.saveDocument(termin, rezervisaniFolderId, "poslednji-termin.xml", Termin.class);
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
            if(datum.getHour() >= 16){
                datum.setDay(datum.getDay()+1);
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
            return datum;
        }
    }

    public Termin convertToObjectTermin(String xmlString) throws FileNotFoundException, TransformerException {
        return (Termin) mapper.convertToObject(xmlString, "Termin", Termin.class);
    }
}
