package int221.project.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "ProductDetail",
            joinColumns = @JoinColumn(name = "ProductID"),
            inverseJoinColumns = @JoinColumn(name = "ColorID")
    )
    Set<Color> colors = new HashSet<>();


}
