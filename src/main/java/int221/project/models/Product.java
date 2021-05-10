package int221.project.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private int productId;
    @Column(name = "ProductName")
    private String productName;
    @Column(name = "ProductDescrip")
    private String productDescrip;
    @Column(name = "Price")
    private Double price;
    @Column(name = "InStockDate")
    private Date inStockDate;
    @Column(name = "ImageName")
    private String imageName;

    @ManyToOne
    @JoinColumn(name = "BagTypeID")
    BagType bagType;

    @ManyToMany
    @JoinTable(
            name = "ProductDetail",
            joinColumns = @JoinColumn(name = "ProductID",insertable = false),
            inverseJoinColumns = @JoinColumn(name = "ColorID",insertable = false)
    )
    Set<Color> colors = new HashSet<>();


}
