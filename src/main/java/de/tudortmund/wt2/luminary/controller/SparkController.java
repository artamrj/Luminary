package de.tudortmund.wt2.luminary.controller;

import de.tudortmund.wt2.luminary.service.SparkService;
import de.tudortmund.wt2.luminary.model.spark.SparkDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/sparks")
public class SparkController implements SparkBaseController {
    private final SparkService sparkService;

    public SparkController(SparkService sparkService) {
        this.sparkService = sparkService;
    }

    @Override
    public ResponseEntity<List<SparkDto>> fetchAllSparks() {
        return new ResponseEntity<>(this.sparkService.fetchAllIdeas(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createSpark(UserDetails authentication, String sparkContent) {
        return new ResponseEntity<>(sparkService.createSpark(sparkContent, authentication), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateSpark(UserDetails authentication, UUID id, String newContent) {
        return new ResponseEntity<>(sparkService.updateSpark(id, newContent, authentication), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteSpark(UserDetails authentication, UUID id) {
        return new ResponseEntity<>(sparkService.deleteSpark(id, authentication), HttpStatus.OK);
    }
}