package atividade02.com.br.werbservicekafka.service;

import atividade02.com.br.werbservicekafka.dto.DTOInputMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private List<String> batchMedium;
    private List<String> batchLow;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.batchMedium = new ArrayList<>();
        this.batchLow = new ArrayList<>();
    }

    public void sendMessage(DTOInputMessage dtoInputMessage) {
        if (dtoInputMessage.getPriorityLevel() == 1) {
            kafkaTemplate.send("school-kafka", dtoInputMessage.getMessage());
        } else if (dtoInputMessage.getPriorityLevel() == 2) {
            if (batchMedium.size() < 5) {
                batchMedium.add(dtoInputMessage.getMessage());
            } else {
                batchMedium.forEach(message -> kafkaTemplate.send("school-kafka", message));
                batchMedium.clear();
            }
        } else if (dtoInputMessage.getPriorityLevel() == 3) {
            if (batchLow.size() < 10) {
                batchLow.add(dtoInputMessage.getMessage());
            } else {
                batchLow.forEach(message -> kafkaTemplate.send("school-kafka", message));
                batchLow.clear();
            }
        }
    }
}
