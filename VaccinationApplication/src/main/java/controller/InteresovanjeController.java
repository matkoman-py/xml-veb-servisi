package controller;

import dao.InteresovanjeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interesovanja")
public class InteresovanjeController {

    @Autowired
    private InteresovanjeDAO interesovanjeDAO;

    @GetMapping("/nesto")
    public ResponseEntity<String> get() {
        String retval = interesovanjeDAO.get("1010998800070");
        return ResponseEntity.ok(retval);
    }
}
