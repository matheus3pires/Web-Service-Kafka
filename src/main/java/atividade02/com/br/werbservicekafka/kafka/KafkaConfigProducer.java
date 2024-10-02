package atividade02.com.br.werbservicekafka.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

public class KafkaConfigProducer {

//    @Bean
//    public ProducerFactory<String, String> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    @Bean
//    public ProducerFactory<String, String> highPriorityProducerFactory() {
//        Map<String, Object> configProps = new HashMap<>(producerFactory().getConfigurationProperties());
//        // Configurações para envio imediato (sem batch)
//        configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, 0); // Desativar o batch
//        configProps.put(ProducerConfig.LINGER_MS_CONFIG, 0); // Sem atraso
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> highPriorityKafkaTemplate() {
//        return new KafkaTemplate<>(highPriorityProducerFactory());
//    }
//
//    @Bean
//    public ProducerFactory<String, String> mediumPriorityProducerFactory() {
//        Map<String, Object> configProps = new HashMap<>(producerFactory().getConfigurationProperties());
//        // Configurações para um lote de aproximadamente 5 mensagens
//        configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, 5120); // 5 KB de tamanho para o lote
//        configProps.put(ProducerConfig.LINGER_MS_CONFIG, 10); // Aguardar até 10 ms para agrupar mensagens
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> mediumPriorityKafkaTemplate() {
//        return new KafkaTemplate<>(mediumPriorityProducerFactory());
//    }
//
//    @Bean
//    public ProducerFactory<String, String> lowPriorityProducerFactory() {
//        Map<String, Object> configProps = new HashMap<>(producerFactory().getConfigurationProperties());
//        // Configurações para um lote de aproximadamente 10 mensagens
//        configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, 10240); // 10 KB de tamanho para o lote
//        configProps.put(ProducerConfig.LINGER_MS_CONFIG, 10); // Aguardar até 10 ms para agrupar mensagens
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> lowPriorityKafkaTemplate() {
//        return new KafkaTemplate<>(lowPriorityProducerFactory());
//    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

//    @Bean
//    public ProducerFactory<String, String> highPriorityProducerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//
//        // Enviar mensagens imediatamente (sem batch)
//        configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, 0); // Desativar o batch
//        configProps.put(ProducerConfig.LINGER_MS_CONFIG, 0); // Sem atraso
//        configProps.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432); // 32 MB de buffer
//
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public ProducerFactory<String, String> mediumPriorityProducerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//
//        // Configurar para um lote de aproximadamente 5 mensagens (5 KB como exemplo)
//        configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, 5120); // 5 KB de tamanho para o lote
//        configProps.put(ProducerConfig.LINGER_MS_CONFIG, 10); // Aguardar até 10 ms para agrupar mensagens
//        configProps.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432); // 32 MB de buffer
//
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public ProducerFactory<String, String> lowPriorityProducerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//
//        // Configurar para um lote de aproximadamente 10 mensagens (10 KB como exemplo)
//        configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, 10240); // 10 KB de tamanho para o lote
//        configProps.put(ProducerConfig.LINGER_MS_CONFIG, 10); // Aguardar até 10 ms para agrupar mensagens
//        configProps.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432); // 32 MB de buffer
//
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> highPriorityKafkaTemplate() {
//        return new KafkaTemplate<>(highPriorityProducerFactory());
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> mediumPriorityKafkaTemplate() {
//        return new KafkaTemplate<>(mediumPriorityProducerFactory());
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> lowPriorityKafkaTemplate() {
//        return new KafkaTemplate<>(lowPriorityProducerFactory());
//    }

}
