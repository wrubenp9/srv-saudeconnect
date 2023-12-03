package com.br.srv.saudeconnect.auth.core.service.account;

import com.br.srv.saudeconnect.auth.core.entity.Account;
import com.br.srv.saudeconnect.auth.core.entity.AccountDetailsImpl;
import com.br.srv.saudeconnect.auth.core.repository.AccountRepository;
import com.br.srv.saudeconnect.domain.exception.CustomException;
import com.br.srv.saudeconnect.enums.ExceptionEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@SuppressWarnings("PMD.AbstractClassWithoutAbstractMethod")
public class AccountDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final Account account = accountRepository
                .findByEmail(username)
                .orElseThrow(() -> new CustomException(ExceptionEnum.USER_NOT_FOUND));

        return new AccountDetailsImpl(account);
    }
}
