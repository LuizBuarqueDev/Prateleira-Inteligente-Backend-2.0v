package br.com.lgbv.prateleira_inteligente_v2.config.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtProperties(String secret, long expiration) {
}