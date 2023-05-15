package de.tudortmund.wt2.backend.service;

import de.tudortmund.wt2.backend.entity.IdeaDAO;
import de.tudortmund.wt2.backend.entity.mapper.DaoToModelMapper;
import de.tudortmund.wt2.backend.repository.IdeaRepository;
import de.tudortmund.wt2.backend.service.model.Idea;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IdeaServiceImpl implements IdeaService{
    private final IdeaRepository ideaRepository;
    private final DaoToModelMapper daoToModelMapper;

    public IdeaServiceImpl(IdeaRepository ideaRepository, DaoToModelMapper daoToModelMapper) {
        this.ideaRepository = ideaRepository;
        this.daoToModelMapper = daoToModelMapper;
    }

    @Override
    public List<Idea> fetchAllIdeas() {
        List<IdeaDAO> ideaDAOList = ideaRepository.findAll();

        return ideaDAOList.stream().map(daoToModelMapper::map).collect(Collectors.toList());
    }
}