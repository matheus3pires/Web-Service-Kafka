package atividade02.com.br.werbservicekafka.controller;

import atividade02.com.br.werbservicekafka.dto.DTOInputMessage;
import atividade02.com.br.werbservicekafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
@CrossOrigin(origins = "http://127.0.0.1:5500") // Permitir CORS para essa origem
public class ControllerKafkaProducer {

    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public ControllerKafkaProducer(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/message")
    public ResponseEntity<DTOInputMessage> sendMessage(
            @RequestBody DTOInputMessage dtoInputMessage
    ) {
        kafkaProducerService.sendMessage(dtoInputMessage);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DTOInputMessage("Mensagem enviada com sucesso!", dtoInputMessage.getPriorityLevel()));
    }

}
