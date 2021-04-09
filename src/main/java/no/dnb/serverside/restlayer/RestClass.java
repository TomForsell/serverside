package no.dnb.serverside.restlayer;


import no.dnb.serverside.datalayer.ConfigDataRepository;
import no.dnb.serverside.businesslayer.EnvironmentService;
import no.dnb.serverside.datalayer.ConfigRepo;
import no.dnb.serverside.datalayer.DataRepositoryH2;
import no.dnb.serverside.models.ConfigData;
import no.dnb.serverside.models.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/assignment")
@CrossOrigin
public class RestClass {
    @Autowired
    private EnvironmentService environmentService;

    @Autowired
    private ConfigDataRepository configDataRepository;

    @Autowired
    private ConfigRepo myConfigRepo;



    @GetMapping(value = "/all", produces = {"application/json", "application/xml"})
    public ResponseEntity<Collection<Environment>> getAllEnvironments() {
        Collection<Environment> environments = environmentService.getAllEnvironments();
        return ResponseEntity.ok().body(environments);
    }

    @GetMapping(value = "/getID/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Environment> read(@PathVariable long id) {
        Environment environment = environmentService.read(id);
        return ResponseEntity.ok().body(environment);
    }

    @PutMapping(value = "/updateEnvironment/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Boolean> update(@PathVariable long id, @RequestBody Environment environment) {
        String description = environment.getDescription();
        boolean result = environmentService.update(id, description);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(value = "/deleteEnvironment/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        boolean pr = environmentService.delete(id);
        return ResponseEntity.ok().body(pr);
    }

    @PostMapping(value = "/createEnvironment/", produces = {"application/json", "application/xml"})
    public ResponseEntity<Environment> create(@RequestBody Environment e) {
        Environment re = environmentService.create(e.getDescription());
        return ResponseEntity.ok().build();
    }


    @PutMapping(
            value = {"/addConfigForEnvironment/{id}"},
            produces = {"application/json", "application/xml"}
    )
    public ResponseEntity<Void> addConfigForEnvironment(@PathVariable long id, @RequestBody ConfigData configData) {
        Environment environment = environmentService.read(id);
        String keyName = configData.getKeyName();
        String configValue = configData.getConfigValue();
        ConfigData newConfigData = new ConfigData(environment, keyName, configValue);
        if (environment == null) {
            return ResponseEntity.notFound().build();
        } else {
            //configData.setEnvironment(environment);
            configDataRepository.save(newConfigData);
            return ResponseEntity.ok().build();

        }
    }
    @DeleteMapping(
            value = "/deleteConfigForEnvironment/{id}",
            produces = {"application/json", "application/xml"}
    )
    public ResponseEntity<Void> deleteConfigForEnvironment(@PathVariable long id) {
        //configDataServiceImpl.deleteConfigurationById(id);

        configDataRepository.deleteById(id);
       // myConfigRepo.deleteConfigData(id);
        //dataRepositoryH2.emergencyDeleteOfConfigData(id);
      // Environment myEnvironment =  environmentService.read(1);
     //  myEnvironment.deleteConfigElement(1);
        return ResponseEntity.ok().build();

    }
    @PutMapping(
            value = {"/updateConfigForEnvironment/{id}"},
            produces = {"application/json", "application/xml"}
    )
    public ResponseEntity<Void> updateConfigForEnvironment(@PathVariable long id, @RequestBody ConfigData configData) {
      ConfigData myConfigData = configDataRepository.findById(id).get();
      myConfigData.setConfigValue(configData.getConfigValue());
      myConfigData.setKeyName(configData.getKeyName());
      configDataRepository.save(myConfigData);
        return ResponseEntity.ok().build();

    }


}


