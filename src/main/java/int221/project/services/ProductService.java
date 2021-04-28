package int221.project.services;

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
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //GET
    public Optional<Product> getProduct(int id){
        return productRepository.findById(id);
    }

    //PUT
    public Optional<Product> editProduct(Product newProduct, int id) {
        return productRepository.findById(id).map(product -> {
            product.setProductName(newProduct.getProductName());
            product.setProductDescrip(newProduct.getProductDescrip());
            product.setPrice(newProduct.getPrice());
            product.setInStockDate(newProduct.getInStockDate());
            product.setImageName(newProduct.getImageName());
            product.setBagType(newProduct.getBagType());
            product.setColors(newProduct.getColors());
            return productRepository.save(newProduct);
        });
    }

    //POST
//    public void addProduct(Product newProduct) {
//        productRepository.save(newProduct);
//    }

    //DELETE
    public void deleteProduct(int id) {
        productRepository.deleteProductDetailById(id);
        productRepository.deleteProductById(id);

    }
}
