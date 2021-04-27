package int221.project.controllers;

import int221.project.models.ProductDetail;
import int221.project.repositories.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductDetailController {
    @Autowired
    ProductDetailRepository productDetailRepository;

    @GetMapping("/product")
    public List<ProductDetail> show(){
        return  productDetailRepository.findAll();
    }
}
