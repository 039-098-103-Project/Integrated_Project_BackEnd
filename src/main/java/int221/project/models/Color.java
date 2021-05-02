package int221.project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Color")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "products")
@SQLInsert(sql = "INSERT IGNORE INTO Color(ColorID,ColorName) VALUES(?,?)")
public class Color {
    @Id
    @Column(name = "ColorID")
    private int colorId;
    @Column(name = "ColorName")
    private String colorName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "colors")
    Set<Product> products = new HashSet<>();

}
