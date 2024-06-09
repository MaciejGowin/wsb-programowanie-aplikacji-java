package com.coderbrother.programowaniejava;

import com.coderbrother.programowaniejava.dto.AccountLoginDto;
import com.coderbrother.programowaniejava.dto.ProfileDto;
import com.coderbrother.programowaniejava.dto.TokenDto;
import com.coderbrother.programowaniejava.repository.UserRepository;
import com.coderbrother.programowaniejava.exception.AuthenticationException;
import com.coderbrother.programowaniejava.security.model.BasicPrincipal;
import com.coderbrother.programowaniejava.security.service.AuthenticationService;
import com.coderbrother.programowaniejava.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApplicationController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @PostMapping("/accountLogin")
    public TokenDto login(@RequestBody AccountLoginDto accountLoginDto) {
        return authenticationService.authenticate(accountLoginDto.getUsername(), accountLoginDto.getPassword())
                .flatMap(jwtService::generateToken)
                .map(token -> TokenDto.builder().token(token).build())
                .orElseThrow(AuthenticationException::new);
    }

    @GetMapping("/profile")
    public ProfileDto profile(@AuthenticationPrincipal BasicPrincipal basicPrincipal) {
        return userRepository.getUserById(basicPrincipal.getUserId())
                .map(user -> ProfileDto.builder()
                        .email(user.getEmail())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .build())
                .orElseThrow(AuthenticationException::new);
    }
}
