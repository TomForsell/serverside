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

        repository.create(new Environment(-1,"Development"));
        repository.create(new Environment(-1,"Disaster Recovery"));
        repository.create(new Environment(-1,"Production"));

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
