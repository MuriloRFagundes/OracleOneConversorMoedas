package com.conversor.converter;

import com.conversor.api.ApiMoeda;
import com.google.gson.JsonObject;

import java.io.IOException;

public class ConversorMoeda {
    private final ApiMoeda apiMoeda;

    public ConversorMoeda(ApiMoeda apiMoeda) {
        this.apiMoeda = apiMoeda;
    }

    public double converterMoeda(int opcao, double valor) throws IOException, InterruptedException {
        JsonObject taxas = apiMoeda.obterTaxas();

        double taxa = 1.0;
        switch (opcao) {
            case 1: // USD para ARS
                taxa = taxas.get("ARS").getAsDouble();
                break;
            case 2: // ARS para USD
                taxa = 1 / taxas.get("ARS").getAsDouble();
                break;
            case 3: // USD para BRL
                taxa = taxas.get("BRL").getAsDouble();
                break;
            case 4: // BRL para USD
                taxa = 1 / taxas.get("BRL").getAsDouble();
                break;
            case 5: // USD para COP
                taxa = taxas.get("COP").getAsDouble();
                break;
            case 6: // COP para USD
                taxa = 1 / taxas.get("COP").getAsDouble();
                break;
            default:
                throw new IllegalArgumentException("Opção inválida");
        }

        return valor * taxa;
    }
}
