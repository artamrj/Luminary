package de.tudortmund.wt2.luminary.service;

import de.tudortmund.wt2.luminary.entity.SparkDAO;
import de.tudortmund.wt2.luminary.entity.mapper.DaoToModelMapper;
import de.tudortmund.wt2.luminary.entity.mapper.ModelToDaoMapper;
import de.tudortmund.wt2.luminary.repository.SparkRepository;
import de.tudortmund.wt2.luminary.service.model.Spark;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SparkServiceImpl implements SparkService {
    private final SparkRepository sparkRepository;
    private final DaoToModelMapper daoToModelMapper;
    private final ModelToDaoMapper modelToDaoMapper;

    public SparkServiceImpl(SparkRepository sparkRepository, DaoToModelMapper daoToModelMapper, ModelToDaoMapper modelToDaoMapper) {
        this.sparkRepository = sparkRepository;
        this.daoToModelMapper = daoToModelMapper;
        this.modelToDaoMapper = modelToDaoMapper;
    }

    @Override
    public List<Spark> fetchAllIdeas() {
        List<SparkDAO> sparkDAOList = sparkRepository.findByDeletedFalse();

        return sparkDAOList.stream().map(daoToModelMapper::map).collect(Collectors.toList());
    }

    @Override
    public String createIdea(Spark spark) {
        // TODO: Check USER ID and Save USER ID
        // TODO: Save current Time as create Time
        // TODO: Save current Time as create Time

        SparkDAO newIdea = modelToDaoMapper.map(spark);
        try {
            sparkRepository.save(newIdea);
            return "Idea sent successful!";
        } catch (Exception e){
            return String.format("Somethings is wrong %s ", e);
        }
    }

    @Override
    public String updateIdea(UUID id, Spark spark) {
        // TODO: Set Edit Time!

        SparkDAO updated = sparkRepository.findById(id)
                .map(fetch -> modelToDaoMapper.update(fetch, spark))
                .orElseThrow(() -> new NoSuchElementException(String.format("No Idea with this Id(%s) founded", id)));

        sparkRepository.save(updated);

        return "Update was successful";
    }
}