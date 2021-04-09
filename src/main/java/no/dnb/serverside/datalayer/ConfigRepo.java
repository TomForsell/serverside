package no.dnb.serverside.datalayer;

import no.dnb.serverside.models.ConfigData;
import no.dnb.serverside.models.Environment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ConfigRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public boolean deleteConfigData(long id) {
        ConfigData c = entityManager.find(ConfigData.class, id);
        if(c!=null) {
            entityManager.remove(c);
            return true;
        }
        else
            return false;

    }
}
