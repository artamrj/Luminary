package de.tudortmund.wt2.luminary.service;

import de.tudortmund.wt2.luminary.model.auth.AuthResponseDto;
import de.tudortmund.wt2.luminary.model.auth.LoginDto;
import de.tudortmund.wt2.luminary.model.auth.RegisterDto;

public interface AuthService {
    Boolean registration(RegisterDto user);
    AuthResponseDto login(LoginDto user);
}