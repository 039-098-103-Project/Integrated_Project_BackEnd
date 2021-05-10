package int221.project.controllers;

import int221.project.models.BagType;
import int221.project.services.BagTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BagTypeController {
    @Autowired
    BagTypeService bagTypeService;

    @GetMapping("/bagtypes")
    public List<BagType> getAll(){
        return bagTypeService.getAllBagType();
    }
}
