package de.tudortmund.wt2.luminary.controller;

import de.tudortmund.wt2.luminary.service.SparkService;
import de.tudortmund.wt2.luminary.service.model.Spark;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sparks")
public class SparkController implements SparkBaseController {
    private final SparkService sparkService;

    public SparkController(SparkService sparkService) {
        this.sparkService = sparkService;
    }

    @Override
    public ResponseEntity<List<Spark>> fetchAllIdeas() {
        return new ResponseEntity<>(this.sparkService.fetchAllIdeas(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createIdea(Spark spark) {
        return new ResponseEntity<>(sparkService.createIdea(spark), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateIdea(UUID id, Spark spark) {
        return new ResponseEntity<>(sparkService.updateIdea(id, spark), HttpStatus.OK);
    }
}