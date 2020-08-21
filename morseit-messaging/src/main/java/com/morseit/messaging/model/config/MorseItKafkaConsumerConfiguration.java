package com.morseit.messaging.model.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.morseit.messaging.model.PrivateMessage;
import com.morseit.messaging.utility.MorseItConstants;

/**
 * @author Harsh
 *
 */
public class MorseItKafkaConsumerConfiguration {
	 @Bean
	    ConcurrentKafkaListenerContainerFactory<String, PrivateMessage> kafkaListenerContainerFactory() {
	        ConcurrentKafkaListenerContainerFactory<String, PrivateMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(consumerFactory());
	        return factory;
	    }

	    @Bean
	    public ConsumerFactory<String, PrivateMessage> consumerFactory() {
	        return new DefaultKafkaConsumerFactory<>(morseItConsumerConfigurations(), new StringDeserializer(), new JsonDeserializer<>(PrivateMessage.class));
	    }

	    @Bean
	    public Map<String, Object> morseItConsumerConfigurations() {
	        Map<String, Object> configurations = new HashMap<>();
	        configurations.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, MorseItConstants.KAFKA_BROKER.SERVER_URL_AND_PORT);
	        configurations.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	        configurations.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	        configurations.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	        return configurations;
	    }

}
