package no.dnb.serverside.datalayer;

import no.dnb.serverside.models.ConfigData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigDataRepository extends CrudRepository<ConfigData,Long>{
   }

