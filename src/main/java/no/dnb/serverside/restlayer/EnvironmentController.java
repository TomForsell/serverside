package no.dnb.serverside.restlayer;
import no.dnb.serverside.datalayer.ConfigDataRepository;
import no.dnb.serverside.businesslayer.EnvironmentService;
import no.dnb.serverside.datalayer.DataRepositoryH2;
import no.dnb.serverside.models.ConfigData;
import no.dnb.serverside.models.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/assignment")
@CrossOrigin
public class EnvironmentController {
    @Autowired
    private EnvironmentService environmentService;

    @Autowired
    private ConfigDataRepository configDataRepository;

    @Autowired
    private DataRepositoryH2 dataRepositoryH2;



    @GetMapping(value = "/getAllEnvironments", produces = {"application/json", "application/xml"})
    public ResponseEntity<Collection<Environment>> getAllEnvironments() {
        Collection<Environment> environments = environmentService.getAllEnvironments();
        return ResponseEntity.ok().body(environments);
    }

    @GetMapping(value = "/getEnvironment/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Environment> getEnvironment(@PathVariable long id) {
        Environment environment = environmentService.read(id);
        return ResponseEntity.ok().body(environment);
    }

    @PutMapping(value = "/updateEnvironment/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Boolean> updateEnvironment(@PathVariable long id, @RequestBody Environment environment) {
        String description = environment.getDescription();
        boolean result = environmentService.update(id, description);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(value = "/deleteEnvironment/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Boolean> deleteEnvironment(@PathVariable Long id) {
        boolean pr = environmentService.delete(id);
        return ResponseEntity.ok().body(pr);
    }

    @PostMapping(value = "/addEnvironment/", produces = {"application/json", "application/xml"})
    public ResponseEntity<Environment> addEnvironment(@RequestBody Environment e) {
        Environment re = environmentService.create(e.getDescription());
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getConfigData/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<List<ConfigData>> getConfigData (@PathVariable long id) {
        Pageable pageable = PageRequest.of(0, 5);
        Page<ConfigData> page = configDataRepository.findAllConfigData(id, pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    @PutMapping(value = {"/addConfigForEnvironment/{id}"}, produces = {"application/json", "application/xml"})
    public ResponseEntity<Void> addConfigForEnvironment(@PathVariable long id, @RequestBody ConfigData configData) {
        Environment environment = environmentService.read(id);
        String keyName = configData.getKeyName();
        String configValue = configData.getConfigValue();
        ConfigData newConfigData = new ConfigData(environment, keyName, configValue);
        if (environment == null) {
            return ResponseEntity.notFound().build();
        } else {
            configDataRepository.save(newConfigData);
            return ResponseEntity.ok().build();

        }
    }
    @DeleteMapping(value = "/deleteConfigForEnvironment/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Void> deleteConfigForEnvironment(@PathVariable long id,  @RequestBody ConfigData configData) {
        dataRepositoryH2.deleteConfigOnEnvironment(configData.getConfigID());
        return ResponseEntity.ok().build();

    }
    @PutMapping(value = {"/updateConfigForEnvironment/{id}"}, produces = {"application/json", "application/xml"})
    public ResponseEntity<Void> updateConfigForEnvironment(@PathVariable long id, @RequestBody ConfigData configData) {
      ConfigData myConfigData = configDataRepository.findById(configData.getConfigID()).get();
      myConfigData.setConfigValue(configData.getConfigValue());
      myConfigData.setKeyName(configData.getKeyName());
      configDataRepository.save(myConfigData);
        return ResponseEntity.ok().build();
    }


}


