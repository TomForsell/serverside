package no.dnb.serverside.datalayer;

import no.dnb.serverside.models.ConfigData;
import no.dnb.serverside.models.Environment;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface ConfigDataRepository extends CrudRepository<ConfigData,Long>{
    List<ConfigData> findByEnvironment(Environment environment);
}

