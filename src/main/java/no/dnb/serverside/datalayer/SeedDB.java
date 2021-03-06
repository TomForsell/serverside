package no.dnb.serverside.datalayer;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class SeedDB {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private long id = -1;


    Date date = new Date();
    Timestamp timestamp2 = new Timestamp(date.getTime());


    @PostConstruct
    public void init() {

        jdbcTemplate.update(
                "insert into environments (description) values (?)",
                new Object[]{"Development"});
        jdbcTemplate.update(
                "insert into environments (description) values (?)",
                new Object[]{"A Test"});

        jdbcTemplate.update(
                "insert into environments (description) values (?)",
                new Object[]{"Disaster Recovery"});


        jdbcTemplate.update(
                "insert into environments (description) values (?)",
                new Object[]{"Production"});


        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi Password","password",timestamp2});


        jdbcTemplate.update("insert into users (user_name,password,isadmin) values (?,?,?)",
                new Object[]{"user1","password1",false});
        jdbcTemplate.update("insert into users (user_name,password,isadmin) values (?,?,?)",
                new Object[]{"user2","password2",true});



        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection","dadffd.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection2","dadfddsfd.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection3","dadfsdsfd.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection4","sds.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection5","dsdsds.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection6","sdsdssd.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection7","ffff.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection8","fdfdf.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection56","dfdfdfdgghh.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection9","reeeee.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection10","rererere.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection11","ererer.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection12","ererere.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection13 :","dadererffd.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection14 :","ererere.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection15","dadfererefd.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection16","ererer.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{1,"Wifi connection34","dadererereffd.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{2,"Wifi connection","dadddffd.ddd.dddd",new Timestamp(date.getTime())});
        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{3,"Wifi connection","dadddffd.ddd.dddd",new Timestamp(date.getTime())});

        jdbcTemplate.update(
                "insert into configdata (environment_id, key_name, config_value,ts) values (?, ?, ?, ?)",
                new Object[]{4,"Wifi connection","daddddddffd.ddd.dddd",new Timestamp(date.getTime())});

    }
}
