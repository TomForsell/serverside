package no.dnb.serverside.businesslayer;
import lombok.Getter;
import lombok.Setter;
import no.dnb.serverside.datalayer.EnvironmentRepository;
import no.dnb.serverside.models.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Getter
@Setter
@Service
public class EnvironmentServiceImpl implements EnvironmentService {
    private EnvironmentRepository repository;

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
