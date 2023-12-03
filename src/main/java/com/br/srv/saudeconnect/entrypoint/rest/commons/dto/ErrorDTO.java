package com.br.srv.saudeconnect.entrypoint.rest.commons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {
    private Integer code;
    private String message;
}
