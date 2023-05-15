package de.tudortmund.wt2.backend.repository;

import de.tudortmund.wt2.backend.entity.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, UUID> {}