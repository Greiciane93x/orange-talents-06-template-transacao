package com.transacao.repository;

import com.transacao.transacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    boolean existsById(Long id);

    List<Transacao> findAllById(Long id, Pageable pageable);
}
