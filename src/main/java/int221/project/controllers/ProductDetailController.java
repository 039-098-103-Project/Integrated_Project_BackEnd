package int221.project.controllers;

import int221.project.models.ProductDetail;
import int221.project.services.ProductDetailService;
import int221.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductDetailController {
    @Autowired
    ProductDetailService productDetailService;
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public List<ProductDetail> showAll(){
        return  productDetailService.getAllProductDetail();
    }

//    @GetMapping("/product/{id}")
//    public ProductDetail show(@PathVariable String id){
//        return productDetailService.getProductDetail(id);
//    }
//
//    @PutMapping("/product/edit/{id}")
//    public ProductDetail edit(@RequestBody ProductDetail newProductDetail, @PathVariable String id){
//        return productDetailService.editProductDetail(newProductDetail,id);
//    }

    @PostMapping("/addProduct")
    public ProductDetail add(@RequestBody ProductDetail newProductDetail){
        return  productDetailService.addProductDetail(newProductDetail);
    }

//    @DeleteMapping("/product/delete/{id}")
//    public void delete(@PathVariable String id){
//        String pid = ( ( productDetailService.getProductDetail(id) ).getProduct() ).getProductId();
//        productDetailService.deleteProductDetail(id);
//        productService.deleteProduct(pid);
//    }
}
