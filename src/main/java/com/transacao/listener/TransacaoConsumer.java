package com.transacao.listener;

import com.transacao.dto.TransacaoDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransacaoConsumer {

    @KafkaListener(topics = "transacoes")
    public void consume(TransacaoDto transacao){
        System.err.println("Consumer transacao: " + transacao.toString());
    }

}
