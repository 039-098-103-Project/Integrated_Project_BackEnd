package int221.project.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bagtype")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BagType {
    @Id
    private int bagTypeId;
    private String bagTypeName;

}
