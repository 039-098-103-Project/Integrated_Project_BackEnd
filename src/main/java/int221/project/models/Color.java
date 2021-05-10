package int221.project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

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
public class Color {
    @Id
    @Column(name = "ColorID")
    private int colorId;
    @Column(name = "ColorName")
    private String colorName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "colors")
    Set<Product> products = new HashSet<>();

}
