package no.dnb.serverside.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@ToString
@Table(name="CONFIGDATA")
public class ConfigData {
    @ManyToOne
    @JoinColumn(name="ENVIRONMENT_ID")
    @JsonBackReference
    private Environment environment;
//test
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ConfigID = -1;

    private String keyName;
    private String value;
    private Timestamp ts;

    public ConfigData() { }



}
