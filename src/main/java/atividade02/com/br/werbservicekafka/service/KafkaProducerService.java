package atividade02.com.br.werbservicekafka.service;

import atividade02.com.br.werbservicekafka.dto.DTOInputMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> highPriorityKafkaTemplate;
    private final KafkaTemplate<String, String> mediumPriorityKafkaTemplate;
    private final KafkaTemplate<String, String> lowPriorityKafkaTemplate;

    private final String studentTopic = "student-topic";
    private final String teacherTopic = "teacher-topic";

    public KafkaProducerService(KafkaTemplate<String, String> highPriorityKafkaTemplate, KafkaTemplate<String, String> mediumPriorityKafkaTemplate, KafkaTemplate<String, String> lowPriorityKafkaTemplate) {
        this.highPriorityKafkaTemplate = highPriorityKafkaTemplate;
        this.mediumPriorityKafkaTemplate = mediumPriorityKafkaTemplate;
        this.lowPriorityKafkaTemplate = lowPriorityKafkaTemplate;
    }

    public void sendMenssage(DTOInputMessage dtoInputMessage) {
        if (dtoInputMessage.getPriorityLevel() == 1) {
            highPriorityKafkaTemplate.send(studentTopic, dtoInputMessage.getMessage());
            highPriorityKafkaTemplate.send(teacherTopic, dtoInputMessage.getMessage());
        } else if (dtoInputMessage.getPriorityLevel() == 2) {
            mediumPriorityKafkaTemplate.send(studentTopic, dtoInputMessage.getMessage());
            mediumPriorityKafkaTemplate.send(teacherTopic, dtoInputMessage.getMessage());
        } else if (dtoInputMessage.getPriorityLevel() == 3) {
            lowPriorityKafkaTemplate.send(studentTopic, dtoInputMessage.getMessage());
            lowPriorityKafkaTemplate.send(teacherTopic, dtoInputMessage.getMessage());
        }

        System.out.println("Mensagem: " + dtoInputMessage.getPriorityLevel());
        System.out.println("Level: " + dtoInputMessage.getMessage());
    }


//    public void sendMessage(String message, int priorityLevel) {
//        if (priorityLevel == 1) {
//            highPriorityKafkaTemplate.send("high-priority-topic", message);
//        } else if (priorityLevel == 2) {
//            mediumPriorityKafkaTemplate.send("medium-priority-topic", message);
//        } else if (priorityLevel == 3) {
//            lowPriorityKafkaTemplate.send("low-priority-topic", message);
//        }
//    }
}
