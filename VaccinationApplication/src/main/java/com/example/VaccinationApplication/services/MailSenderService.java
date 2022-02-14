package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.Termin;
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
    public void posaljiRezervisan(String email, Termin termin) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        String emailContent = "Obavestavamo Vas da dodjete u: "+ termin.getDatumVreme() + " radi vakcinacije! " +
                "Molimo Vas da ne kasnite ili promasite termin!";

        helper = new MimeMessageHelper(message, true);
        helper.setFrom("notification@siit-nocu.com");
        helper.setTo(email);
        helper.setSubject("Obavestenje o terminu vakcinacije");
        helper.setText(emailContent, true);

        javaMailSender.send(message);
    }
}
