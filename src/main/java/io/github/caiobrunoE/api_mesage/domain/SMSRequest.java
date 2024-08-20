package io.github.caiobrunoE.api_mesage.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SMSRequest {
    private String to;       // Número de telefone de destino
    private String message;  // Mensagem de texto a ser enviada

}


