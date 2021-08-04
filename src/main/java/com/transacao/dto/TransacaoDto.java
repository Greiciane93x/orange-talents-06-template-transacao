package com.transacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDto {
    private String id;

    @JsonProperty("valor")
    private BigDecimal valor;

    @JsonProperty("efetivoEm")
    private LocalDateTime efetivoEm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getEfetivoEm() {
        return efetivoEm;
    }

    public void setEfetivoEm(LocalDateTime efetivoEm) {
        this.efetivoEm = efetivoEm;
    }

    @Override
    public String toString() {
        return "TransacaoDto{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", efetivoEm=" + efetivoEm +
                '}';
    }
}
