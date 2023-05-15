package de.tudortmund.wt2.backend.entity.mapper;

import de.tudortmund.wt2.backend.entity.IdeaDAO;
import de.tudortmund.wt2.backend.service.model.Idea;
import org.mapstruct.Mapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Mapper
public interface ModelToDaoMapper {
    IdeaDAO map(Idea idea);

    default Timestamp mapLocalDateTimeToTimestamp(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Timestamp.valueOf(localDateTime);
    }
}