package com.transacao.controller;

import com.transacao.transacao.Transacao;
import com.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {

    private final TransacaoRepository repository;

    @Autowired
    public TransacaoController(TransacaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/transacoes/{id}")
    public ResponseEntity<?> buscaTransacoes(@PathVariable("id") Long id) {

        Pageable primeiraPagina = PageRequest.of(0, 50);
        Page<Transacao> transacoes = repository.findAll(primeiraPagina);
        var exists = repository.existsById(id);
        if (!exists) {
            return ResponseEntity.status(404).build();
        }
         return  ResponseEntity.ok().body(transacoes);
    }
}
