package de.tudortmund.wt2.luminary.entity.mapper;

import de.tudortmund.wt2.luminary.entity.SparkDAO;
import de.tudortmund.wt2.luminary.service.model.Spark;
import org.mapstruct.Mapper;

@Mapper
public interface DaoToModelMapper {
    Spark map(SparkDAO sparkDAO);
}
