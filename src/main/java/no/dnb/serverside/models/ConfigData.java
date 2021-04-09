package no.dnb.serverside.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@EqualsAndHashCode
@ToString
@Entity@Table(name="CONFIGDATA")
public class ConfigData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long configID = -1;


    @ManyToOne
    @JoinColumn(name="ENVIRONMENT_ID")
    @JsonBackReference
    private Environment environment;
    private String keyName;
    private String configValue;
    private Timestamp ts;

    private Date date = new Date();
    public ConfigData() { }

    public ConfigData(Environment environment, String keyName, String configValue) {
        this.configID = configID;
        this.environment = environment;
        this.keyName = keyName;
        this.configValue = configValue;
        this.ts = new Timestamp(date.getTime());
    }

    public long getConfigID() {
        return configID;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public String getKeyName() {
        return keyName;
    }

    public String getConfigValue() {
        return configValue;
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

    public void setConfigValue(String value) {
        this.configValue = value;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }


}
