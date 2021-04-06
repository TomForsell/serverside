package no.dnb.serverside.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="ENVIRONMENT")
@Data
public class Environment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    private String description;
    private double price;
    private long inStock;


    @OneToMany(mappedBy="environment", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonManagedReference
    private List<ConfigData> configDataList;

    public Environment(){}

    public Environment(String description, double price, long inStock){
        this(-1, description, price, inStock);

    }

    public Environment(long id, String description, double price, long inStock) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
    }

 }
