package atividade02.com.br.werbservicekafka.controller;

import atividade02.com.br.werbservicekafka.dto.DTOInputMessage;
import atividade02.com.br.werbservicekafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
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
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
