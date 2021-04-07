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


        //Date date = new Date();
        //Timestamp timestamp2 = new Timestamp(date.getTime());

        //configRepository.save(new ConfigData( -1,devEnvironment,"Connection:","wifi.dnb.no",timestamp2));

    }
    @Override
    public Collection<Environment> getAllProducts() {
        return repository.getAllEnvironments();
    }
    @Override
    public Environment create(Environment p) {
        return repository.create(p);
    }
    @Override
    public Environment read(long id) {
       return  repository.read(id);
    }
    @Override
    public boolean update(long id) {
        if(repository.update(id)){
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
