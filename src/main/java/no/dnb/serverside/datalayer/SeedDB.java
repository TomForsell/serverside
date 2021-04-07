package no.dnb.serverside.datalayer;

import no.dnb.serverside.datalayer.ConfigDataRepository;
import no.dnb.serverside.models.ConfigData;
import no.dnb.serverside.models.Environment;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class SeedDB {

   /* @Autowired
    ConfigDataRepository configRepo;
*/
    @Autowired
    JdbcTemplate jdbcTemplate;
    private long id = -1;


    Date date = new Date();
    Timestamp timestamp2 = new Timestamp(date.getTime());


    //Environment devEnvironment = new Environment(-1,"Development");

  //  ConfigData newConfigData = new ConfigData(-1,devEnvironment,"Connection:","wifi.dnb.no",timestamp2);

    @PostConstruct
    public void init() {


       /* repository.create(devEnvironment);
        repository.create(new Environment(-1,"Disaster Recovery"));
        repository.create(new Environment(-1,"Production"));
*/
        jdbcTemplate.update(
                "insert into ENVIRONMENTS (description) values (?)",
                new Object[]{"Development"});
        jdbcTemplate.update(
                "insert into ENVIRONMENTS (description) values (?)",
                new Object[]{"A Test"});

        jdbcTemplate.update(
                "insert into ENVIRONMENTS (description) values (?)",
                new Object[]{"Disaster Recovery"});


        jdbcTemplate.update(
                "insert into ENVIRONMENTS (description) values (?)",
                new Object[]{"Production"});

        //  configRepo.save(new ConfigData( -1,devEnvironment,"Connection:","wifi.dnb.no",timestamp2));

        jdbcTemplate.update(
                "insert into CONFIGDATA (ENVIRONMENT_ID, key_name, value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi Password:","password",timestamp2});


    }
}
