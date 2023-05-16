package de.tudortmund.wt2.backend.entity.mapper;

import de.tudortmund.wt2.backend.entity.IdeaDAO;
import de.tudortmund.wt2.backend.service.model.Idea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Mapper
public interface ModelToDaoMapper {
    IdeaDAO map(Idea idea);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "likeCount", ignore = true),
            @Mapping(target = "userId", ignore = true),
            @Mapping(target = "createdAt", ignore = true)
    })
    IdeaDAO update(@MappingTarget IdeaDAO target, Idea update);

    default Timestamp mapLocalDateTimeToTimestamp(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Timestamp.valueOf(localDateTime);
    }
}