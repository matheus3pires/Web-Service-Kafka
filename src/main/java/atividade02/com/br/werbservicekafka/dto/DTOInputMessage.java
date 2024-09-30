package atividade02.com.br.werbservicekafka.dto;

import java.util.List;

public class DTOInputMessage {
    List<String> messages;
    Integer priorityLevel;

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }
}
