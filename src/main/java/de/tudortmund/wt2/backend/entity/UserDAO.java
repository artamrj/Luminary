package de.tudortmund.wt2.backend.entity;

import de.tudortmund.wt2.backend.constant.UserType;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Nullable
    private String username;
    @Nullable
    private String password;
    @Nullable
    private String email;
    @Nullable
    private UserType userType;
}