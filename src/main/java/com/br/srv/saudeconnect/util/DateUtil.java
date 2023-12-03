package com.br.srv.saudeconnect.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtil {

    private final DateTimeFormatter outputDateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public static String formatDate(final LocalDateTime dateTime) {
        return dateTime.format(outputDateTimeFormat);
    }
}
