package int221.project.services;

import int221.project.models.Product;
import int221.project.models.ProductDetail;
import int221.project.repositories.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailService extends UUIDGenerator {
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    ProductService productService;

    //GET
    public List<ProductDetail> getAllProductDetail() {
        return productDetailRepository.findAll();
    }

    //GET
    public ProductDetail getProductDetail(String id) {
        return productDetailRepository.findById(id).orElse(null);
    }

    //PUT
    public ProductDetail editProductDetail(ProductDetail newProductDetail, String id) {
        return productDetailRepository.findById(id).map(productDetail -> {
            String pid = newProductDetail.getProduct().getProductId();
            Product product = newProductDetail.getProduct();
            productDetail.setProduct(productService.editProduct(product, pid));

            return productDetailRepository.save(productDetail);
        }).orElse(null);
    }

    //POST
    public ProductDetail addProductDetail(ProductDetail newProductDetail) {
//        if(productDetail.get(newProductDetail.getProductDetailId()) != null){
//            throw new Exception("duplicate id");
//        }
        newProductDetail.setProduct(productService.addProduct(newProductDetail.getProduct()));
        int old_id = (int) productDetailRepository.count();
        newProductDetail.setProductDetailId(Generate("PD",old_id));
        return productDetailRepository.save(newProductDetail);
    }

    //DELETE
//    public void deleteProductDetail(String id){
//        productDetailRepository.deleteById(id);
//    }
}
