package buscarapi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversaoMoeda {

    public void executar() {
        Scanner leitura = new Scanner(System.in);
        BuscarDadosApi consulta = new BuscarDadosApi();

        int busca = 0;

        while (busca != 7) {

            try {

                System.out.println("*****************************************************");
                System.out.println("Seja bem vindo ao Conversor de Moeda \n");

                System.out.println("1) Dólar -> Peso Argentino\n" +
                        "2) Peso Argentino -> Dólar\n" +
                        "3) Dólar -> Real Brasileiro\n" +
                        "4) Real Brasileiro -> Dólar\n" +
                        "5) Dólar -> Peso Colombiano\n" +
                        "6) Peso Colombiano -> Dólar\n" +
                        "7) Sair\n" +
                        "\nEscolha um opção válida: \n");

                busca = leitura.nextInt();


                if (busca == 7) {
                    System.out.println("Programa finalizado!\n" +
                            "Obrigado e até a próxima!\n");
                } else if (busca == 1) {
                    realizarConversao("USD", "ARS", leitura, consulta);
                } else if (busca == 2) {
                    realizarConversao("ARS", "USD", leitura, consulta);
                } else if (busca == 3) {
                    realizarConversao("USD", "BRL", leitura, consulta);
                } else if (busca == 4) {
                    realizarConversao("BRL", "USD", leitura, consulta);
                } else if (busca == 5) {
                    realizarConversao("USD", "COP", leitura, consulta);
                } else if (busca == 6) {
                    realizarConversao("COP", "USD", leitura, consulta);
                } else {
                    System.out.println("Opção inválida! Escolha um número entre 1 e 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nERRO: Por favor, digite apenas números inteiros!");
                leitura.nextLine();
                busca = 0;
            }



        }

    }
    private void realizarConversao(String base, String destino, Scanner leitura, BuscarDadosApi consulta) {
        try {
            System.out.println("Digite o valor que deseja converter (" + base + "):");
            double valor = leitura.nextDouble();

            DadosApi dados = consulta.buscaDadosApi(base);
            Double taxa = dados.conversion_rates().get(destino);

            if (taxa != null) {
                double resultado = valor * taxa;
                System.out.printf("Valor %.2f [%s] -> %.2f [%s]%n", valor, base, resultado, destino);
            }
        } catch (InputMismatchException e) {
            System.out.println("Valor númerico inválido para conversão!");
            leitura.nextLine();
        }
    }


}
