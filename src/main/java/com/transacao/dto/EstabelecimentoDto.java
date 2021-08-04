package com.transacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstabelecimentoDto {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("cidade")
    private String cidade;

    @JsonProperty("endereco")
    private String endereco;
}
