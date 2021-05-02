package int221.project.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BagType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BagType {
    @Id
    @Column(name = "BagTypeID")
    private int bagTypeId;
    @Column(name = "BagTypeName")
    private String bagTypeName;

}
