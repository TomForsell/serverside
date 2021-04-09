package no.dnb.serverside.restlayer;


import no.dnb.serverside.businesslayer.EnvironmentService;
import no.dnb.serverside.datalayer.ConfigDataRepository;
import no.dnb.serverside.datalayer.DataRepositoryH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assignment")
@CrossOrigin

public class ConfigurationController {
    @Autowired
    private EnvironmentService environmentService;

    @Autowired
    private ConfigDataRepository configDataRepository;

    @Autowired
    private DataRepositoryH2 dataRepositoryH2;

}
