package no.dnb.serverside.datalayer;

import no.dnb.serverside.models.ConfigData;
import no.dnb.serverside.models.Environment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ConfigDataRepository extends CrudRepository<ConfigData,Long>{
    List<ConfigData> findByEnvironment(Environment environment);
   // @Query("DELETE FROM CONFIGDATA c WHERE id=?1")
    //void deleteById (Long id);

}

