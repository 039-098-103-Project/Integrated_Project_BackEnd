package int221.project.services;

import int221.project.models.Color;
import int221.project.repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
    @Autowired
    ColorRepository colorRepository;

    //GET
    public List<Color> getAllColors(){
        return colorRepository.findAll();
    }
}
