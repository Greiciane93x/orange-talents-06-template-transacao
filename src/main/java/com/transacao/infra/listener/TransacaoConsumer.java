package com.transacao.infra.listener;

import com.transacao.infra.dto.TransacaoDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransacaoConsumer {

    @KafkaListener(topics = "transacoes")
    public void consume(TransacaoDto transacao){
        System.err.println("Consumer transacao: " + transacao.toString());
    }

}
