package io.github.caiobrunoE.api_mesage.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@Document(collection = "SMSRequest")
public class SMSRequest {
    @Id
    private String id;

    private String to;
    private String message;

}


