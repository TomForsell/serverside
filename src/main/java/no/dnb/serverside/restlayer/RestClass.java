package no.dnb.serverside.restlayer;


import no.dnb.serverside.datalayer.ConfigDataRepository;
import no.dnb.serverside.businesslayer.EnvironmentService;
import no.dnb.serverside.models.ConfigData;
import no.dnb.serverside.models.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/assignment")
@CrossOrigin
public class RestClass {
    @Autowired
    private EnvironmentService environmentService;

    @Autowired
    private ConfigDataRepository configDataRepository;

    @GetMapping(value="/all", produces={"application/json","application/xml"})
    public ResponseEntity<Collection<Environment>>getAllEnvironments() {
        Collection<Environment> environments = environmentService.getAllEnvironments();
        return ResponseEntity.ok().body(environments);
    }
    @GetMapping(value="/getID/{id}", produces={"application/json","application/xml"})
    public ResponseEntity <Environment> read(@PathVariable long id) {
        Environment environment = environmentService.read(id);
        return ResponseEntity.ok().body(environment);
    }

    @PutMapping(value="/update/{id}", produces={"application/json","application/xml"})
    public ResponseEntity <Boolean> update(@PathVariable long id,@RequestBody String description) {
        boolean result = environmentService.update(id,description);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping(value="/delete/{id}", produces={"application/json","application/xml"})
    public ResponseEntity <Boolean> delete(@PathVariable Long id) {
        boolean pr= environmentService.delete(id);
        return ResponseEntity.ok().body(pr);
    }
    @PostMapping(value="/create/", produces ={"application/json","application/xml"})
    public ResponseEntity<String> create(@RequestBody String description){
        Environment re = environmentService.create(description);
        return ResponseEntity.ok().build();
    }

/*
    @PostMapping(
            value="/save/{id}", produces={"application/json","application/xml"}
    )
    public ResponseEntity<Void> save(@PathVariable long environmentID, @RequestBody String keyName, String configValue ) {
        Environment re = environmentService.read(environmentID);
        ConfigData newConfigData = new ConfigData(re,keyName,configValue);
        configDataRepository.save(newConfigData);
        return ResponseEntity.ok().build();

    }
*/

    @PutMapping(
            value = {"/addConfigForEnvironment/{environmentID}"},
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"}
    )
    public ResponseEntity<Void> addConfigForEnvironment(@PathVariable long environmentID, @RequestBody ConfigData configData) {
        Environment environment = environmentService.read(environmentID);
        String keyName = configData.getKeyName();
        String configValue = configData.getConfigValue();
        ConfigData newConfigData = new ConfigData(environment,keyName,configValue);
        if (environment==null) {
            return ResponseEntity.notFound().build();
        } else {
            configData.setEnvironment(environment);
            this.configDataRepository.save(newConfigData);
            return ResponseEntity.ok().build();
        }
    }


}


