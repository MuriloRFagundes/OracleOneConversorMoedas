package com.conversor.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiMoeda {
    private static final String CHAVE_API = "sua_chave_api";
    private static final String URL_API = "https://api.exchangerate-api.com/v4/latest/USD";

    public JsonObject obterTaxas() throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(URL_API + "?access_key=" + CHAVE_API))
                .build();

        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        String respostaJson = resposta.body();

        Gson gson = new Gson();
        return gson.fromJson(respostaJson, JsonObject.class).getAsJsonObject("rates");
    }
}
