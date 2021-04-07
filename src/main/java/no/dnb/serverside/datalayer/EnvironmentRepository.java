package no.dnb.serverside.datalayer;

import no.dnb.serverside.models.Environment;

import java.util.Collection;

public interface EnvironmentRepository {
    Collection <Environment> getAllEnvironments();
    Environment create(Environment e);
    Environment read(long id);
    boolean update(long id,String description);
    boolean delete(long id);
}
