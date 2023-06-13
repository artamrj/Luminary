package de.tudortmund.wt2.luminary.service;

import de.tudortmund.wt2.luminary.service.model.Spark;

import java.util.List;
import java.util.UUID;

public interface SparkService {
    List<Spark> fetchAllIdeas();

    String createIdea(Spark spark);

    String updateIdea(UUID id, Spark spark);
}