package int221.project.repositories;

import int221.project.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Query(value = "delete from productdetail where productID = :productid", nativeQuery = true)
    void deleteProductDetailById(@Param("productid") int productid);
    @Modifying
    @Query(value = "delete from product where productID = :productid", nativeQuery = true)
    void deleteProductById(@Param("productid") int productid);

    @Modifying
    @Query(value = "select * from product where productname = :productname", nativeQuery = true)
    List<Product> searchProductByName(@Param("productname") String productname);

    @Modifying
    @Query(value = "select * from product where imagename = :imagename", nativeQuery = true)
    List<Product> searchProductByImageName(@Param("imagename") String imagename);
}
