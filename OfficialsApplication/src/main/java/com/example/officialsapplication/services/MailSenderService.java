package com.example.officialsapplication.services;

import com.example.officialsapplication.dao.DataAccessLayer;
import com.example.officialsapplication.extractor.MetadataExtractor;
import com.example.officialsapplication.mappers.MultiwayMapper;
import com.example.officialsapplication.model.users.korisnik.Korisnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;


    @Async
    public void odobrenZeleni(Korisnik k) throws MessagingException, IOException {

        MimeMessage message = javaMailSender.createMimeMessage();
        Multipart multipart = new MimeMultipart();

    	MimeBodyPart messageBodyPart = new MimeBodyPart();
    	messageBodyPart.setContent("Postovani " + k.getIme() + " " + k.getPrezime() + ",<br><br>Vas zahtev za zeleni sertifikat je odobren. U attachment-u se nalaze dokumenti u PDF i HTML formatu.<br><br>Srdacan pozdrav,<br>Siit nocu", "text/html");
    	
    	MimeBodyPart attachPart = new MimeBodyPart();
    	attachPart.attachFile("gen/itext/zelenisertifikat.pdf");
    	MimeBodyPart attachPart1 = new MimeBodyPart();
    	attachPart1.attachFile("gen/itext/zelenisertifikat.html");
    	multipart.addBodyPart(messageBodyPart);
    	multipart.addBodyPart(attachPart);
    	multipart.addBodyPart(attachPart1);
    	message.setRecipients(RecipientType.TO,k.getEmail());
    	message.setSubject("Odgovor na zahtev za odobrenje");
    	message.setContent(multipart);
    	javaMailSender.send(message);
    }
}
