package de.tudortmund.wt2.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.UUID;
@Entity
@Table(name = "ideas_table")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdeaDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String content;
    private int likeCount;
    private UUID userId;
    private Timestamp createdAt;
    private Timestamp lastEditedAt;
    private boolean deleted;
}