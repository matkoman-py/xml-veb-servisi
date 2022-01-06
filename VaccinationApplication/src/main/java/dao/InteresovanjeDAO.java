package dao;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import model.documents.Interesovanje;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InteresovanjeDAO {
	
	private final String collectionId = "/db/vaccination-application/interesovanja";
    private final DaoUtils daoUtils;
    
    
//    public String save() {
//        String documentId = interesovanje.getPodaciOPrimaocu().getJMBG()+ ".xml";
//        Interesovanje interesovanje = new Interesovanje();
//        daoUtils.createResource(collectionId, interesovanje, documentId, Interesovanje.class);
//        return interesovanje.getPodaciOPrimaocu().getJMBG();
//    }

    public String get(String id) {
        String resourceContent = daoUtils.getResource(collectionId, id);
//        if (resourceContent.equals(""))
//            return Optional.empty();
//        Interesovanje interesovanje = mapper.convertToObject(resourceContent);
//        if (interesovanje == null)
//            return Optional.empty();
        return resourceContent;
    }
}

