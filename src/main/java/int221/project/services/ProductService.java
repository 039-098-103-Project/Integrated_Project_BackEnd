package int221.project.services;

import int221.project.models.Product;
import int221.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends UUIDGenerator {
    @Autowired
    ProductRepository productRepository;

    //PUT
    public Product editProduct(Product newProduct, String id) {
        return productRepository.findById(id).map(product -> {
            product.setProductName(newProduct.getProductName());
            product.setProductDescrip(newProduct.getProductDescrip());
            product.setPrice(newProduct.getPrice());
            product.setBagType(newProduct.getBagType());
            product.setInStockDate(newProduct.getInStockDate());
            product.setImageName(newProduct.getImageName());
            return productRepository.save(product);
        }).orElse(null);
    }

    //POST
    public Product addProduct(Product newProduct) {
        int old_pid = (int) productRepository.count();
        newProduct.setProductId(Generate("P", old_pid));
        return productRepository.save(newProduct);
    }

    //DELETE
//    public void deleteProduct(String id) {
//        productRepository.deleteById(id);
//
//    }
}
