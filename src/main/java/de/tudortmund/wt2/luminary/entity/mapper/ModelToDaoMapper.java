package de.tudortmund.wt2.luminary.entity.mapper;

import de.tudortmund.wt2.luminary.entity.SparkDAO;
import de.tudortmund.wt2.luminary.entity.UserDAO;
import de.tudortmund.wt2.luminary.model.RegisterDto;
import de.tudortmund.wt2.luminary.model.SparkDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Mapper
public interface ModelToDaoMapper {
    SparkDAO map(SparkDto sparkDto);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "lightCount", ignore = true),
            @Mapping(target = "creator", ignore = true),
            @Mapping(target = "createdAt", ignore = true)
    })
    SparkDAO update(@MappingTarget SparkDAO target, SparkDto update);

    UserDAO map (RegisterDto registerDto);

    default Timestamp mapLocalDateTimeToTimestamp(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Timestamp.valueOf(localDateTime);
    }
}