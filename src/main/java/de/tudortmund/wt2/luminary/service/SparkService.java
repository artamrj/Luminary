package de.tudortmund.wt2.luminary.service;

import de.tudortmund.wt2.luminary.model.SparkDto;

import java.util.List;
import java.util.UUID;

public interface SparkService {
    List<SparkDto> fetchAllIdeas();

    String createIdea(SparkDto sparkDto);

    String updateIdea(UUID id, SparkDto sparkDto);
}