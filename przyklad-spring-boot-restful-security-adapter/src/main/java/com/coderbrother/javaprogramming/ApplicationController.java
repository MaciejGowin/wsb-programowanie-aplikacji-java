package com.coderbrother.javaprogramming;

import com.coderbrother.javaprogramming.dto.AccountLoginDto;
import com.coderbrother.javaprogramming.dto.ProfileDto;
import com.coderbrother.javaprogramming.dto.TokenDto;
import com.coderbrother.javaprogramming.repository.UserRepository;
import com.coderbrother.javaprogramming.exception.AuthenticationException;
import com.coderbrother.javaprogramming.security.model.BasicPrincipal;
import com.coderbrother.javaprogramming.security.service.AuthenticationService;
import com.coderbrother.javaprogramming.security.service.JwtService;
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
