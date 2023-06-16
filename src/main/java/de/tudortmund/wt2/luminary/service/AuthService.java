package de.tudortmund.wt2.luminary.service;

import de.tudortmund.wt2.luminary.model.AuthResponseDto;
import de.tudortmund.wt2.luminary.model.LoginDto;
import de.tudortmund.wt2.luminary.model.RegisterDto;

public interface AuthService {
    Boolean registration(RegisterDto user);
    AuthResponseDto login(LoginDto user);
}