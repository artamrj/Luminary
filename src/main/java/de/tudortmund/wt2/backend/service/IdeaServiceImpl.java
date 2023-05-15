package de.tudortmund.wt2.backend.service;

import de.tudortmund.wt2.backend.service.model.Idea;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaServiceImpl implements IdeaService{
    @Override
    public List<Idea> fetchAllIdeas() {
        return null;
    }
}