package com.morseit.messaging.model.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.morseit.messaging.model.PrivateMessage;
import com.morseit.messaging.utility.MorseItConstants;

/**
 * @author Harsh
 *
 */
@EnableKafka
@Configuration
public class MorseItKafkaProducerConfiguration {
	@Bean
    public ProducerFactory<String, PrivateMessage> producerFactory() {
        return new DefaultKafkaProducerFactory<>(buildConfigurations());
    }

  

	@Bean
    public Map<String, Object> buildConfigurations() {
        Map<String, Object> configurations = new HashMap<>();
        configurations.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, MorseItConstants.KAFKA_BROKER.SERVER_URL_AND_PORT);
        configurations.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configurations.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return configurations;
    }

    @Bean
    public KafkaTemplate<String, PrivateMessage> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
