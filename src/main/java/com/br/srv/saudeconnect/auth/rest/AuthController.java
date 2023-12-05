package com.br.srv.saudeconnect.auth.rest;

import com.br.srv.saudeconnect.auth.core.dto.AccountCreateRequestDTO;
import com.br.srv.saudeconnect.auth.core.dto.AuthRequestDTO;
import com.br.srv.saudeconnect.auth.core.dto.AuthResponseDTO;
import com.br.srv.saudeconnect.auth.core.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
@SuppressWarnings("PMD.AbstractClassWithoutAbstractMethod")
public class AuthController {

    private final AccountService accountService;

    @PostMapping("/auth")
    public AuthResponseDTO authenticate(@RequestBody final AuthRequestDTO request) {
        return accountService.authenticateUser(request);
    }

    @PostMapping("/register")
    public void postUser(@RequestBody final AccountCreateRequestDTO request) {
        accountService.createUser(request);
    }

    @PostMapping("/account/{accountId}")
    public void deleteAccount(@PathVariable final String accountId) {
        accountService.deleteAccount(accountId);
    }
}
