package de.tudortmund.wt2.backend.controller;

import de.tudortmund.wt2.backend.service.IdeaService;
import de.tudortmund.wt2.backend.service.model.Idea;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ideas")
public class IdeaController implements IdeaBaseController{
    private final IdeaService ideaService;

    public IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @Override
    public ResponseEntity<List<Idea>> fetchAllIdeas() {
        return new ResponseEntity<>(this.ideaService.fetchAllIdeas(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createIdea(Idea idea) {
        return new ResponseEntity<>(ideaService.createIdea(idea), HttpStatus.CREATED);
    }
}