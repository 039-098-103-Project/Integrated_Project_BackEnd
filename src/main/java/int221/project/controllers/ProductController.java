package int221.project.controllers;

import int221.project.exceptions.ProductNotFoundException;
import int221.project.models.Product;
import int221.project.services.FileStorageService;
import int221.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    FileStorageService fileStorageService;

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

    @GetMapping("/img/{filename:.+}")
    public ResponseEntity<Resource> getImg(@PathVariable String filename){
        Resource file = fileStorageService.load(filename);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+ file.getFilename() + "\"").body(file);
    }

    @PutMapping("/product/edit/{id}")
    public Optional<Product> edit(@RequestParam("file") MultipartFile file,@RequestPart Product newProduct, @PathVariable int id) {
        try {
            fileStorageService.delete(productService.getProduct(id).get().getImageName());
            fileStorageService.store(file);
            return productService.editProduct(newProduct, id);
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found.", e);
        }
    }

    @PostMapping("/addProduct")
    public void add(@RequestParam("file") MultipartFile file, @RequestPart Product newProduct) {
        fileStorageService.store(file);
        productService.addProduct(newProduct);
    }

    @Transactional
    @DeleteMapping("/product/delete/{id}")
    public void delete(@PathVariable int id) {
        try {
            fileStorageService.delete(productService.getProduct(id).get().getImageName());
            productService.deleteProduct(id);
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found.", e);
        }
    }


}
