package no.dnb.serverside.datalayer;

import no.dnb.serverside.models.ConfigData;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository
public interface ConfigDataRepository extends CrudRepository<ConfigData,Long>{

   @Query("select cd from ConfigData cd where cd.environment.id = ?1")
   Page<ConfigData> findAllConfigData(long id, Pageable pageable);

}

