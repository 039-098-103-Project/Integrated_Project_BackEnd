package int221.project.controllers;

import int221.project.models.Product;
import int221.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public List<Product> showAll(){
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> show(@PathVariable int id){
        return productService.getProduct(id);
    }

    @PutMapping("/product/edit/{id}")
    public Optional<Product> edit(@RequestBody Product newProduct, @PathVariable int id){
        return productService.editProduct(newProduct,id);
    }

//    @PostMapping("/addProduct")
//    public void add(@RequestBody Product newProduct){
//        productService.addProduct(newProduct);
//    }

    @DeleteMapping("/product/delete/{id}")
    public void delete(@PathVariable int id){
        productService.deleteProduct(id);
    }


}
