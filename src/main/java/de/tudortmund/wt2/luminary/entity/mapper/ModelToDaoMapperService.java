package de.tudortmund.wt2.luminary.entity.mapper;

import de.tudortmund.wt2.luminary.constant.UserRole;
import de.tudortmund.wt2.luminary.entity.SparkDAO;
import de.tudortmund.wt2.luminary.entity.UserDAO;
import de.tudortmund.wt2.luminary.model.RegisterDto;
import de.tudortmund.wt2.luminary.model.SparkDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class ModelToDaoMapperService implements ModelToDaoMapper{
    private final ModelToDaoMapper mapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public SparkDAO map(SparkDto sparkDto) {
        return null;
    }

    @Override
    public SparkDAO update(SparkDAO target, SparkDto update) {
        return null;
    }

    @Override
    public UserDAO map(RegisterDto registerDto) {
        UserDAO userDAO = mapper.map(registerDto);

        String encryptedPassword = passwordEncoder.encode(registerDto.getPassword());
        userDAO.setPassword(encryptedPassword);

        // Default Role is USER
        userDAO.setRole(UserRole.USER);

        return userDAO;
    }
}