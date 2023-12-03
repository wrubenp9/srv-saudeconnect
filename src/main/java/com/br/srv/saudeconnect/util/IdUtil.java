package com.br.srv.saudeconnect.util;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class IdUtil {
    public String generate() {
        final UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }
}
