package no.dnb.serverside.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="ENVIRONMENTS")
@Data
public class Environment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    private String description;
    //private double price;
   // private long inStock;

    @OneToMany(mappedBy="environment", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonManagedReference
    private List<ConfigData> configDataList;

    public Environment(){}

    public Environment(long id, String description) {
        this.id = id;
        this.description = description;
        }

 }
