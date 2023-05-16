package de.tudortmund.wt2.backend.service;

import de.tudortmund.wt2.backend.entity.IdeaDAO;
import de.tudortmund.wt2.backend.entity.mapper.DaoToModelMapper;
import de.tudortmund.wt2.backend.entity.mapper.ModelToDaoMapper;
import de.tudortmund.wt2.backend.repository.IdeaRepository;
import de.tudortmund.wt2.backend.service.model.Idea;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class IdeaServiceImpl implements IdeaService{
    private final IdeaRepository ideaRepository;
    private final DaoToModelMapper daoToModelMapper;
    private final ModelToDaoMapper modelToDaoMapper;

    public IdeaServiceImpl(IdeaRepository ideaRepository, DaoToModelMapper daoToModelMapper, ModelToDaoMapper modelToDaoMapper) {
        this.ideaRepository = ideaRepository;
        this.daoToModelMapper = daoToModelMapper;
        this.modelToDaoMapper = modelToDaoMapper;
    }

    @Override
    public List<Idea> fetchAllIdeas() {
        List<IdeaDAO> ideaDAOList = ideaRepository.findByDeletedFalse();

        return ideaDAOList.stream().map(daoToModelMapper::map).collect(Collectors.toList());
    }

    @Override
    public String createIdea(Idea idea) {
        // TODO: Check USER ID and Save USER ID
        // TODO: Save current Time as create Time
        // TODO: Save current Time as create Time

        IdeaDAO newIdea = modelToDaoMapper.map(idea);
        try {
            ideaRepository.save(newIdea);
            return "Idea sent successful!";
        } catch (Exception e){
            return String.format("Somethings is wrong %s ", e);
        }
    }

    @Override
    public String updateIdea(UUID id, Idea idea) {
        // TODO: Set Edit Time!

        IdeaDAO updated = ideaRepository.findById(id)
                .map(fetch -> modelToDaoMapper.update(fetch, idea))
                .orElseThrow(() -> new NoSuchElementException(String.format("No Idea with this Id(%s) founded", id)));

        ideaRepository.save(updated);

        return "Update was successful";
    }
}