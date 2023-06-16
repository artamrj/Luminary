package de.tudortmund.wt2.luminary.service;

import de.tudortmund.wt2.luminary.entity.UserDAO;
import de.tudortmund.wt2.luminary.entity.mapper.DaoToModelMapper;
import de.tudortmund.wt2.luminary.entity.mapper.ModelToDaoMapper;
import de.tudortmund.wt2.luminary.model.AuthResponseDto;
import de.tudortmund.wt2.luminary.model.LoginDto;
import de.tudortmund.wt2.luminary.model.RegisterDto;
import de.tudortmund.wt2.luminary.repository.UserRepository;
import de.tudortmund.wt2.luminary.security.jwt.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final ModelToDaoMapper modelToDaoMapper;
    private final DaoToModelMapper daoToModelMapper;

    @Override
    public Boolean registration(RegisterDto user) {
        if (userRepository.existsByUsername(user.getUsername()))
            return false;

        UserDAO newUser = modelToDaoMapper.map(user);
        userRepository.save(newUser);

        return true;
    }

    @Override
    public AuthResponseDto login(LoginDto user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtUtil.generateToken(authentication);

        return new AuthResponseDto(token);
    }
}