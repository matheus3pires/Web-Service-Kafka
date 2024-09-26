package atividade02.com.br.werbservicekafka.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DTOInputMessage {
    String message;
    Integer priorityLevel;
}
