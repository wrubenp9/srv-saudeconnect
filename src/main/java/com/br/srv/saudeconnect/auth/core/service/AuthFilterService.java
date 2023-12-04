package com.br.srv.saudeconnect.auth.core.service;

import com.br.srv.saudeconnect.auth.core.entity.Account;
import com.br.srv.saudeconnect.auth.core.entity.AccountDetailsImpl;
import com.br.srv.saudeconnect.auth.core.repository.AccountRepository;
import com.br.srv.saudeconnect.domain.exception.CustomException;
import com.br.srv.saudeconnect.enums.ExceptionEnum;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class AuthFilterService extends OncePerRequestFilter {

    private final AuthTokenService authTokenService;

    private final AccountRepository accountRepository;

    @Value("${endpoint.noAuth}")
    private final String[] endpointNoAuth;

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    public AuthFilterService() {
    }

    @Override
    protected void doFilterInternal(
            @NonNull final HttpServletRequest request,
            @NonNull final HttpServletResponse response,
            @NonNull final FilterChain filterChain)
            throws ServletException, IOException {

        if (checkIfEndpointIsNotPublic(request)) {
            final String token = recoveryToken(request);

            if (token != null) {
                final String subject = authTokenService.getSubjectFromToken(token);

                final Account account = accountRepository
                        .findByEmail(subject)
                        .orElseThrow(() -> new CustomException(ExceptionEnum.USER_NOT_FOUND));

                final AccountDetailsImpl userDetails = new AccountDetailsImpl(account);

                final Authentication authentication = new UsernamePasswordAuthenticationToken(
                        userDetails.getUsername(), null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                throw new CustomException(ExceptionEnum.AUTHENTICATION_MISSING_TOKEN);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoveryToken(final HttpServletRequest request) {
        final String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);

        return authorizationHeader != null && authorizationHeader.startsWith(BEARER_PREFIX)
                ? authorizationHeader.replace(BEARER_PREFIX, "")
                : null;
    }

    private boolean checkIfEndpointIsNotPublic(final HttpServletRequest request) {
        final String requestURI = request.getRequestURI();
        return !Arrays.asList(endpointNoAuth).contains(requestURI);
    }
}
