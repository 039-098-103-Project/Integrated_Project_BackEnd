package int221.project.repositories;

import int221.project.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Query(value = "delete from productdetail where productID = :productid", nativeQuery = true)
    void deleteProductDetailById(@Param("productid") int productid);
    @Modifying
    @Query(value = "delete from product where productID = :productid", nativeQuery = true)
    void deleteProductById(@Param("productid") int productid);
}
