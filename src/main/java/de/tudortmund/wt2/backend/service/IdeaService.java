package de.tudortmund.wt2.backend.service;

import de.tudortmund.wt2.backend.service.model.Idea;

import java.util.List;

public interface IdeaService {
    List<Idea>  fetchAllIdeas();
}