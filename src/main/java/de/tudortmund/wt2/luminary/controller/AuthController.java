package de.tudortmund.wt2.luminary.controller;

import de.tudortmund.wt2.luminary.model.AuthResponseDto;
import de.tudortmund.wt2.luminary.model.LoginDto;
import de.tudortmund.wt2.luminary.model.RegisterDto;
import de.tudortmund.wt2.luminary.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController implements AuthBaseController {
    private final AuthService authService;
    @Override
    public ResponseEntity<String> registration(RegisterDto user) {
        boolean response = authService.registration(user);

        if (response)
            return new ResponseEntity<>("User created Successfully!", HttpStatus.OK);

        return new ResponseEntity<>("Username is already token!", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<AuthResponseDto> login(LoginDto user) {
        AuthResponseDto response = authService.login(user);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}