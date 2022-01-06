package dao;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import model.documents.Interesovanje;

@Component
@RequiredArgsConstructor
public class InteresovanjeDAO {
	
	private final String collectionId = "/db/vaccination-application/interesovanja";
    private final DaoUtils daoUtils;
    
    
    public String save() {
        String documentId =  interesovanje.getPodaciOPrimaocu().getJMBG()+ ".xml";
        Interesovanje interesovanje = new Interesovanje();
        daoUtils.createResource(collectionId, interesovanje, documentId, Interesovanje.class);
        return interesovanje.getPodaciOPrimaocu().getJMBG();
    }
}

