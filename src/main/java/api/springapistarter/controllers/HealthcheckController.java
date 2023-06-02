package api.springapistarter.controllers;

import org.openapitools.api.HealthcheckApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController implements HealthcheckApi {

    @Override
    public ResponseEntity<Void> getHealth() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
