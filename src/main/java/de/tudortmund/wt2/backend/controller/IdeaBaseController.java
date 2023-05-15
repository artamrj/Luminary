package de.tudortmund.wt2.backend.controller;

import de.tudortmund.wt2.backend.service.model.Idea;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IdeaBaseController {

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation
    ResponseEntity<List<Idea>> fetchAllIdeas();

    @PostMapping(path = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation
    ResponseEntity<String> createIdea(@RequestBody Idea idea);
}