package int221.project.controllers;

import int221.project.models.Color;
import int221.project.services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ColorController {
    @Autowired
    ColorService colorService;

    @GetMapping("/colors")
    public List<Color> getAll(){
        return colorService.getAllColors();
    }
}
