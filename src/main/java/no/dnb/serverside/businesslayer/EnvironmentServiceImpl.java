package no.dnb.serverside.businesslayer;
import lombok.Getter;
import lombok.Setter;
import no.dnb.serverside.datalayer.ConfigDataRepository;
import no.dnb.serverside.datalayer.EnvironmentRepository;
import no.dnb.serverside.models.ConfigData;
import no.dnb.serverside.models.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@Service
public class EnvironmentServiceImpl implements EnvironmentService {
    private EnvironmentRepository repository;
   // private ConfigDataRepository configRepository;

    @Autowired
    public EnvironmentServiceImpl(@Qualifier("dataRepositoryH2") EnvironmentRepository repository) {
        this.repository = repository;

    }
    @Override
    public Collection<Environment> getAllEnvironments() {
        return repository.getAllEnvironments();
    }
    @Override
    public Environment create(String description) {
        Environment myEnvironment = new Environment(description);
        return repository.create(myEnvironment);
    }
    @Override
    public Environment read(long id) {
       return  repository.read(id);
    }
    @Override
    public boolean update(long id,String description) {
        if(repository.update(id,description)){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public boolean delete(long id) {
        if(repository.delete(id)){
            return true;
        }
        else{
            return false;
        }
    }
}
