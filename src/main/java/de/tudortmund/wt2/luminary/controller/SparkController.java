package de.tudortmund.wt2.luminary.controller;

import de.tudortmund.wt2.luminary.service.SparkService;
import de.tudortmund.wt2.luminary.model.SparkDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createSpark(SparkDto sparkDto) {
        return new ResponseEntity<>(sparkService.createIdea(sparkDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateSpark(UUID id, SparkDto sparkDto) {
        return new ResponseEntity<>(sparkService.updateIdea(id, sparkDto), HttpStatus.OK);
    }
}