package de.tudortmund.wt2.luminary.service;

import de.tudortmund.wt2.luminary.constant.UserRole;
import de.tudortmund.wt2.luminary.entity.SparkDAO;
import de.tudortmund.wt2.luminary.entity.UserDAO;
import de.tudortmund.wt2.luminary.entity.mapper.DaoToModelMapper;
import de.tudortmund.wt2.luminary.entity.mapper.ModelToDaoMapper;
import de.tudortmund.wt2.luminary.model.auth.UserContentInfoDto;
import de.tudortmund.wt2.luminary.model.spark.SparkDto;
import de.tudortmund.wt2.luminary.repository.SparkRepository;
import de.tudortmund.wt2.luminary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SparkServiceImpl implements SparkService {
    private final SparkRepository sparkRepository;
    private final UserRepository userRepository;
    private final DaoToModelMapper daoToModelMapper;
    private final ModelToDaoMapper modelToDaoMapper;

    @Override
    public List<SparkDto> fetchAllIdeas() {
        List<SparkDAO> sparkDAOList = sparkRepository.findAll();

        return sparkDAOList.stream().map(daoToModelMapper::map).collect(Collectors.toList());
    }

    @Override
    public String createSpark(String sparkContent, UserDetails authentication) {
        if (authentication == null || !authentication.isAccountNonExpired()) {
            throw new IllegalStateException("User not authenticated");
        }

        String username = authentication.getUsername();
        UserDAO user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        new SparkDto();
        SparkDto newSpark = SparkDto.builder()
                .content(sparkContent)
                .creator(UserContentInfoDto.builder().username(user.getUsername()).name(user.getName()).build())
                .build();

        SparkDAO newIdea = modelToDaoMapper.map(newSpark);
        try {
            sparkRepository.save(newIdea);
            return "Idea sent successful!";
        } catch (Exception e){
            return String.format("Somethings is wrong %s ", e);
        }
    }

    @Override
    public String updateSpark(UUID id, String newContent, UserDetails authentication) {
        SparkDAO founded = sparkRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("No Spark with this Id(%s) founded", id)));

        String usernameOfSpark = founded.getCreator().getUsername();

        if (Objects.equals(authentication.getUsername(), usernameOfSpark)){
            SparkDAO updated = modelToDaoMapper.update(founded, newContent);
            sparkRepository.save(updated);

            return "Update was successful";
        }

        return "Update was not successful";
    }

    @Override
    public String deleteSpark(UUID id, UserDetails authentication) {
        SparkDAO foundedSpark = sparkRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("No Spark with this Id(%s) founded", id)));

        UserDAO user = userRepository.findByUsername(authentication.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(String.format("No User with this username(%s) founded", authentication.getUsername())));

        String usernameOfSpark = foundedSpark.getCreator().getUsername();

        if (user.getRole() == UserRole.ADMIN || Objects.equals(user.getUsername(), usernameOfSpark)){
            sparkRepository.delete(foundedSpark);

            return "deleted";
        }

        return "cant be deleted!";
    }
}