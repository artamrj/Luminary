package de.tudortmund.wt2.backend.entity.mapper;

import de.tudortmund.wt2.backend.entity.IdeaDAO;
import de.tudortmund.wt2.backend.service.model.Idea;
import org.mapstruct.Mapper;

@Mapper
public interface DaoToModelMapper {
    Idea map(IdeaDAO ideaDAO);
}
