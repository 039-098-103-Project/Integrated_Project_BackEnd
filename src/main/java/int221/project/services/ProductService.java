package int221.project.services;

import int221.project.models.Color;
import int221.project.models.Product;
import int221.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    //GET
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //GET
    public Optional<Product> getProduct(int id) {
        return productRepository.findById(id);
    }

    //PUT
    public Optional<Product> editProduct(Product newProduct, int id) {
        return productRepository.findById(id).map(product -> productRepository.save(newProduct));
    }

    //POST
    public void addProduct(Product newProduct) {
        for (Color color : newProduct.getColors()) {
            newProduct.getColors().add(color);
        }
        productRepository.save(newProduct);
    }

    //DELETE
    public void deleteProduct(int id) {
        productRepository.deleteProductDetailById(id);
        productRepository.deleteProductById(id);

    }

    public List<Product> searchProduct(String productName) {
        return productRepository.searchProductByName(productName);
    }

    public List<Product> searchImage(String imageName) {
        return productRepository.searchProductByImageName(imageName);
    }

    public Boolean searchDuplicateName(String productName, int id) {
        List<Product> products = productRepository.findAll();
        for (Product p : products) {
            if (p.getProductName().equals(productName) && p.getProductId() != id) {
                return true;
            }
        }
        return false;
    }

    public Boolean searchDuplicateImage(String imageName, int id){
        List<Product> products = productRepository.findAll();
        for (Product p : products) {
            if (p.getImageName().equals(imageName) && p.getProductId() != id) {
                return true;
            }
        }
        return false;
    }
}
