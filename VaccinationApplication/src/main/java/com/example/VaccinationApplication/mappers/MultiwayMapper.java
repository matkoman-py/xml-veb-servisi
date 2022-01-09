package com.example.VaccinationApplication.mappers;

import com.example.VaccinationApplication.eventhandler.VaccinationEventHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

@Component
public class MultiwayMapper {

    public Object convertToObject(String xmlString, String xsdFileName, Class<?> classOfObject) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(classOfObject);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            
            File file = ResourceUtils.getFile("src/main/resources/static/xsd/" + xsdFileName + ".xsd");
            if(!file.exists()) {
            	file = ResourceUtils.getFile("classpath:static/xsd/" + xsdFileName + ".xsd");
            }
            Schema schema = schemaFactory.newSchema(file);
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new VaccinationEventHandler());

            return  unmarshaller.unmarshal(new StringReader(xmlString));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String convertToXml(Object object, Class<?> classOfObject) {
        StringWriter sw = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(classOfObject);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, sw);
        } catch (Exception ignored) {
        }
        return sw.toString();
    }
}
