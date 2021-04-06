package no.dnb.serverside.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;


@EqualsAndHashCode
@ToString
@Entity@Table(name="CONFIGDATA")
public class ConfigData {

//test
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long configID = -1;

    @ManyToOne
    @JoinColumn(name="ENVIRONMENT_ID")
    @JsonBackReference
    private Environment environment;

    private String keyName;
    private String value;
    private Timestamp ts;

    public ConfigData() { }

    public long getConfigID() {
        return configID;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public String getKeyName() {
        return keyName;
    }

    public String getValue() {
        return value;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setConfigID(long configID) {
        this.configID = configID;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }
}
