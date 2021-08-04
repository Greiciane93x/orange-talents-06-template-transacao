package com.transacao.transacao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal valor;
    private String numeroCartao;
    private LocalDateTime efetivoEm;

    @Embedded
    private Endereco endereco;

    @Deprecated
    public Transacao() { }

    public Transacao(Long id, BigDecimal valor, String numeroCartao, LocalDateTime efetivoEm, Endereco endereco) {
        this.id = id;
        this.valor = valor;
        this.numeroCartao = numeroCartao;
        this.efetivoEm = efetivoEm;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public LocalDateTime getEfetivoEm() {
        return efetivoEm;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", valor=" + valor +
                ", numeroCartao='" + numeroCartao + '\'' +
                ", efetivoEm=" + efetivoEm +
                '}';
    }
}
