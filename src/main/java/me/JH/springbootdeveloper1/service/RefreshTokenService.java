package me.JH.springbootdeveloper1.service;

import lombok.RequiredArgsConstructor;
import me.JH.springbootdeveloper1.domain.RefreshToken;
import me.JH.springbootdeveloper1.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected"));
    }

}
