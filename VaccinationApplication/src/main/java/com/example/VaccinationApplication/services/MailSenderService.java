package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.Termin;
import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void posaljiDaJeNaCekanju(String email) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        String emailContent = "Nazalost, nema dovoljno vakcina trenutno. Cim stigne nova nabavka, bicete obavesteni!";

        helper = new MimeMessageHelper(message, true);
        helper.setFrom("notification@siit-nocu.com");
        helper.setTo(email);
        helper.setSubject("Obavestenje o terminu vakcinacije");
        helper.setText(emailContent, true);

        javaMailSender.send(message);
    }

    @Async
    public void posaljiRezervisan(String email, Termin termin, Interesovanje interesovanje) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        String emailContent = "Obavestavamo Vas da dodjete " +
                                termin.getDatumVreme().getDay()+"."+
                                termin.getDatumVreme().getMonth()+"."+
                                termin.getDatumVreme().getYear()+"."+
                                " u: " + termin.getDatumVreme().getHour() + ":" + termin.getDatumVreme().getMinute()
                                + " radi vakcinacije! " +
                                "Molimo Vas da ne kasnite ili promasite termin!\n"
                                +"Drzavljanstvo: " + interesovanje.getPodaciOPrimaocu().getDrzavljanstvo() + "\n"
                                +"Ime: " + interesovanje.getPodaciOPrimaocu().getIme().getValue() + "\n"
                                +"Prezime: " + interesovanje.getPodaciOPrimaocu().getPrezime().getValue() + "\n"
                                +"E-mail: " + interesovanje.getPodaciOPrimaocu().getKontakt().getAdresaElektronskePoste() + "\n"
                                +"Odabir vakcine: " + interesovanje.getOdabirVakcine() + "\n"
                                +"Molimo Vas podnesite dokument o saglasnosti pre navedenog termina, u suprotnom necete" +
                                "moci da se vakcinisete";

        helper = new MimeMessageHelper(message, true);
        helper.setFrom("notification@siit-nocu.com");
        helper.setTo(email);
        helper.setSubject("Obavestenje o terminu vakcinacije");
        helper.setText(emailContent, true);

        javaMailSender.send(message);
    }
}
