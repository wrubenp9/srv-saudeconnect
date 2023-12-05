package com.br.srv.saudeconnect.auth.core.service.account;

import com.br.srv.saudeconnect.auth.core.dto.AccountCreateRequestDTO;
import com.br.srv.saudeconnect.auth.core.dto.AuthRequestDTO;
import com.br.srv.saudeconnect.auth.core.dto.AuthResponseDTO;
import com.br.srv.saudeconnect.auth.core.entity.Account;
import com.br.srv.saudeconnect.auth.core.entity.AccountDetailsImpl;
import com.br.srv.saudeconnect.auth.core.repository.AccountRepository;
import com.br.srv.saudeconnect.auth.core.service.AuthTokenService;
import com.br.srv.saudeconnect.config.AuthConfig;
import com.br.srv.saudeconnect.domain.exception.CustomException;
import com.br.srv.saudeconnect.enums.ExceptionEnum;
import com.br.srv.saudeconnect.enums.RoleEnum;
import com.br.srv.saudeconnect.util.DateUtil;
import com.br.srv.saudeconnect.util.IdUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@SuppressWarnings("PMD.AbstractClassWithoutAbstractMethod")
public class AccountService {

    private final AuthenticationManager authenticationManager;
    private final AuthTokenService authTokenService;
    private final AccountRepository accountRepository;
    private final AuthConfig authConfig;

    public AuthResponseDTO authenticateUser(final AuthRequestDTO authRequest) {

        final UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword());

        final Authentication authentication = authenticationManager.authenticate(token);

        final AccountDetailsImpl accountDetails = (AccountDetailsImpl) authentication.getPrincipal();

        return AuthResponseDTO.builder()
                .accountId(accountDetails.getAccountId())
                .role(accountDetails.getAccount().getRole())
                .token(authTokenService.generateToken(accountDetails))
                .build();
    }

    public Account createUser(final AccountCreateRequestDTO request) {
        if (Boolean.TRUE.equals(accountRepository.existsByEmail(request.getEmail()))) {
            throw new CustomException(ExceptionEnum.USER_EXIST);
        }

        final Account.AccountBuilder newAccount = Account.builder()
                .accountId(IdUtil.generate())
                .email(request.getEmail())
                .password(authConfig.passwordEncoder().encode(request.getPassword()))
                .createdAt(DateUtil.formatDate(LocalDateTime.now()))
                .updatedAt(DateUtil.formatDate(LocalDateTime.now()));

        newAccount.role(request.getRole() != null ? request.getRole() : RoleEnum.STUDENTS);

        return accountRepository.save(newAccount.build());
    }

    @Transactional
    public void deleteAccount(final String accountId) {
        if (accountRepository.existsById(accountId)) {
            throw new CustomException(ExceptionEnum.USER_NOT_FOUND);
        }

        accountRepository.findById(accountId).ifPresent(accountRepository::delete);
    }
}
