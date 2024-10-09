package atividade02.com.br.werbservicekafka.dto;

import lombok.Getter;

@Getter
public class DTOInputMessage {
    String message;
    Integer priorityLevel;

    public DTOInputMessage(String message, Integer priorityLevel) {
        this.message = message;
        this.priorityLevel = priorityLevel;
    }
}
