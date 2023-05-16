package de.tudortmund.wt2.backend.service;

import de.tudortmund.wt2.backend.service.model.Idea;

import java.util.List;
import java.util.UUID;

public interface IdeaService {
    List<Idea> fetchAllIdeas();

    String createIdea(Idea idea);

    String updateIdea(UUID id, Idea idea);
}