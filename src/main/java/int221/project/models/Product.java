package int221.project.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
//    @GeneratedValue
    private String productId;
    private String productName;
    private String productDescrip;
    private Double price;
    private Date inStockDate;
    private String imageName;

    @ManyToOne
    @JoinColumn(name = "bagTypeId")
    BagType bagType;


}
