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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }
}
