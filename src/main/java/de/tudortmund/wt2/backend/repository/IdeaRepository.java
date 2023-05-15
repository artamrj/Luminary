package de.tudortmund.wt2.backend.repository;

import de.tudortmund.wt2.backend.entity.IdeaDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IdeaRepository extends JpaRepository<IdeaDAO, UUID> {}