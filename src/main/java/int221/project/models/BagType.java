package int221.project.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BagType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String bagTypeId;
    private String bagTypeName;

}
