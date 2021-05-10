package int221.project.controllers;

import int221.project.exceptions.ExceptionResponse;
import int221.project.exceptions.ProductException;
import int221.project.models.Product;
import int221.project.services.FileStorageService;
import int221.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    FileStorageService fileStorageService;

    @GetMapping("/products")
    public List<Product> showAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> show(@PathVariable int id) {
        if (productService.getProduct(id).isEmpty()) {
            throw new ProductException(ExceptionResponse.ERROR_CODE.ITEM_DOES_NOT_EXIST, "Product {" + id + "} Not Found.");
        }
        return productService.getProduct(id);
    }

    @GetMapping("/img/{filename:.+}")
    public ResponseEntity<Resource> getImg(@PathVariable String filename) {
        Resource file = fileStorageService.load(filename);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @Transactional
    @PutMapping("/products/edit/{id}")
    public Optional<Product> edit(@RequestParam("file") MultipartFile file, @RequestPart Product newProduct, @PathVariable int id) {
        if (file.equals(null) || newProduct.equals(null)) {
            throw new ProductException(ExceptionResponse.ERROR_CODE.FILE_EMPTY, "File or Product is Empty");
        }
        if (productService.getProduct(id).isEmpty()) {
            throw new ProductException(ExceptionResponse.ERROR_CODE.ITEM_DOES_NOT_EXIST, "Product id {" + id + "} Not Found.");
        }
        if (productService.searchDuplicateName(newProduct.getProductName(), newProduct.getProductId())){
            throw new ProductException(ExceptionResponse.ERROR_CODE.ITEM_ALREADY_EXIST, "This Product Name already exist.");
        }
        if (productService.searchDuplicateImage(newProduct.getImageName(), newProduct.getProductId())){
            throw new ProductException(ExceptionResponse.ERROR_CODE.ITEM_ALREADY_EXIST, "Duplicate Image Name.");
        }
        fileStorageService.delete(productService.getProduct(id).get().getImageName());
        fileStorageService.store(file);
        return productService.editProduct(newProduct, id);
    }

    @Transactional
    @PostMapping("/addProduct")
    public void add(@RequestParam("file") MultipartFile file, @RequestPart Product newProduct) {
        if (file.equals(null) || newProduct.equals(null)) {
            throw new ProductException(ExceptionResponse.ERROR_CODE.FILE_EMPTY, "File or Product is Empty");
        }
        if (!productService.searchProduct(newProduct.getProductName()).isEmpty()) {
            throw new ProductException(ExceptionResponse.ERROR_CODE.ITEM_ALREADY_EXIST, "This Product Name already exist.");
        }
        if (!productService.searchImage(newProduct.getImageName()).isEmpty()) {
            throw new ProductException(ExceptionResponse.ERROR_CODE.ITEM_ALREADY_EXIST, "Duplicate Image Name.");
        }
        fileStorageService.store(file);
        productService.addProduct(newProduct);

    }

    @Transactional
    @DeleteMapping("/products/delete/{id}")
    public void delete(@PathVariable int id) {
        if (productService.getProduct(id).isEmpty()) {
            throw new ProductException(ExceptionResponse.ERROR_CODE.ITEM_DOES_NOT_EXIST, "Product id{" + id + "} Not Found.");
        }
        fileStorageService.delete(productService.getProduct(id).get().getImageName());
        productService.deleteProduct(id);
    }
}
