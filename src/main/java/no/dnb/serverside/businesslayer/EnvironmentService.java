package no.dnb.serverside.businesslayer;
import no.dnb.serverside.models.ConfigData;
import no.dnb.serverside.models.Environment;

import java.util.Collection;

public interface EnvironmentService {
    Collection<Environment> getAllEnvironments();
    Environment create(String description);
    Environment read(long id);
    boolean update(long id,String description);
    boolean delete(long id);

}
