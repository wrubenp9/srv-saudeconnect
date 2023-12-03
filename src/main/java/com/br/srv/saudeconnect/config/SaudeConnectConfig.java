package com.br.srv.saudeconnect.config;

import com.br.srv.saudeconnect.auth.core.dto.AccountCreateRequestDTO;
import com.br.srv.saudeconnect.auth.core.entity.Account;
import com.br.srv.saudeconnect.auth.core.repository.AccountRepository;
import com.br.srv.saudeconnect.auth.core.service.account.AccountService;
import com.br.srv.saudeconnect.enums.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class SaudeConnectConfig {
    private final AccountRepository accountRepository;
    private final AccountService accountService;

    @Bean
    public void createAdmin() {
        final String email = "saudeconnect@hotmail.com";

        Optional<Account> account = accountRepository.findByEmail(email);
        if (account.isEmpty()) {
            accountService.createUser(AccountCreateRequestDTO.builder()
                    .email(email)
                    .role(RoleEnum.ADMIN)
                    .password("admin")
                    .build());
        }
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedHeaders("*")
                        .allowedMethods("*");
            }
        };
    }
}
