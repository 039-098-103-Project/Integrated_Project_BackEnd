package int221.project.services;

import int221.project.models.Color;
import int221.project.models.Product;
import int221.project.repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ColorService {
    @Autowired
    ColorRepository colorRepository;

    //POST
    public void setProduct(Product newProduct, Set<Color> color) {
        for (Color c : color){
            c.getProducts().add(newProduct);
        };
    }
}
