package com.conversor;

import com.conversor.api.ApiMoeda;
import com.conversor.converter.ConversorMoeda;
import com.conversor.modelo.HistoricoConversao;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        ApiMoeda apiMoeda = new ApiMoeda();
        ConversorMoeda conversorMoeda = new ConversorMoeda(apiMoeda);
        HistoricoConversao historico = new HistoricoConversao();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seja bem-vindo/a ao Conversor de Moeda\n");

        int opcao = 0;
        do {
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Sair");

            System.out.print("Escolha uma opção válida: ");
            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 6) {
                System.out.print("Informe o valor que deseja converter: ");
                double valorOriginal = scanner.nextDouble();

                // Realiza a conversão de moeda
                double valorConvertido = conversorMoeda.converterMoeda(opcao, valorOriginal);

                // Adiciona a conversão ao histórico
                historico.adicionarConversao(opcao, valorOriginal, valorConvertido);

                // Exibe o resultado para o usuário
                System.out.println("Valor convertido: " + valorConvertido);
            } else if (opcao != 7) {
                System.out.println("Opção inválida. Por favor, escolha uma opção de 1 a 7.");
            }
        } while (opcao != 7);

        // Exibe o histórico de conversões ao finalizar o programa
        System.out.println("\nHistórico de Conversões:");
        for (String registro : historico.getRegistros()) {
            System.out.println(registro);
        }
    }
}
