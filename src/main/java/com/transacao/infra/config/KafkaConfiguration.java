package com.transacao.infra.config;

import com.transacao.infra.dto.TransacaoDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfiguration {
    private final KafkaProperties kafka;

    public KafkaConfiguration(KafkaProperties kafka) { this.kafka = kafka; }

    @Bean
    public ConsumerFactory<String, TransacaoDto> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers(),
                ConsumerConfig.GROUP_ID_CONFIG, kafka.getConsumer().getGroupId(),
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, kafka.getConsumer().getKeyDeserializer(),
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafka.getConsumer().getAutoOffsetReset()
        ),
                new StringDeserializer(),
                new JsonDeserializer<>(TransacaoDto.class, false));
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, TransacaoDto> kafkaListenerContainerFactory(){
        var factory = new ConcurrentKafkaListenerContainerFactory<String, TransacaoDto>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
