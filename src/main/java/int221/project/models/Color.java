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
@Table(name = "color")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "products")
@SQLInsert(sql = "INSERT IGNORE INTO color(colorId,colorName) VALUES(?,?)")
public class Color {
    @Id
    private int colorId;
    private String colorName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "colors")
    Set<Product> products = new HashSet<>();

}
