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
    public ResponseEntity<Collection<Environment>>getAllProducts() {
        Collection<Environment> environments = environmentService.getAllEnvironments();
        return ResponseEntity.ok().body(environments);
    }
    @GetMapping(value="/getID/{id}", produces={"application/json","application/xml"})
    public ResponseEntity <Environment> read(@PathVariable long id) {
        Environment environment = environmentService.read(id);
        return ResponseEntity.ok().body(environment);
    }

    @PutMapping(value="/update/{id}", produces={"application/json","application/xml"})
    public ResponseEntity <Boolean> update(@PathVariable long id) {
        boolean result = environmentService.update(id);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping(value="/delete/{id}", produces={"application/json","application/xml"})
    public ResponseEntity <Boolean> delete(@PathVariable Environment p) {
        boolean pr= environmentService.delete(p.getId());
        return ResponseEntity.ok().body(pr);
    }
    @PostMapping(value="/create/{Environment e}", produces ={"application/json","application/xml"})
    public ResponseEntity<Environment> create(@PathVariable Environment e){
        Environment re = environmentService.create(e);
        if(re.equals(e)){
            return ResponseEntity.ok().build();
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping(
            value="/addConfigDataforEnvironments/{ENVIRONMENT_ID}",
            consumes={"application/json","application/xml"},
            produces={"application/json","application/xml"}
    )
    public ResponseEntity<Void> addCOnfigForEnvironment(@PathVariable long configID, @RequestBody ConfigData configData) {
        Optional<ConfigData> environment = configDataRepository.findById(configID);

        if (environment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            configData.setEnvironment(environment.get().getEnvironment());
            configDataRepository.save(configData);
            return ResponseEntity.ok().build();
        }
    }

}
