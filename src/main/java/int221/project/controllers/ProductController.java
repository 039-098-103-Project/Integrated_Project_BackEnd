package int221.project.controllers;

import int221.project.exceptions.ProductNotFoundException;
import int221.project.models.Product;
import int221.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public List<Product> showAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> show(@PathVariable int id) {
        try {
            return productService.getProduct(id);
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found.", e);
        }
    }

    @PutMapping("/product/edit/{id}")
    public Optional<Product> edit(@RequestBody Product newProduct, @PathVariable int id) {
        try {
            return productService.editProduct(newProduct, id);
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found.", e);
        }
    }

    @PostMapping("/addProduct")
    public void add(@RequestBody Product newProduct) {
        productService.addProduct(newProduct);
    }

    @Transactional
    @DeleteMapping("/product/delete/{id}")
    public void delete(@PathVariable int id) {
        try {
            productService.deleteProduct(id);
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found.", e);
        }
    }


}
