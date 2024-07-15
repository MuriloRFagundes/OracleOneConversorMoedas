package com.conversor.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoricoConversao {
    private List<String> registros;

    public HistoricoConversao() {
        this.registros = new ArrayList<>();
    }

    public void adicionarConversao(int opcao, double valorOriginal, double valorConvertido) {
        LocalDateTime agora = LocalDateTime.now();
        String registro = agora + ": Convertido " + valorOriginal + " para " + valorConvertido + " (opção " + opcao + ")";
        registros.add(registro);
    }

    public List<String> getRegistros() {
        return registros;
    }
}
