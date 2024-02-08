package utils;

import java.util.Scanner;

public class ValidacaoValoresUtils {
    public static String obterStringNaoVazia(Scanner scanner, String input) {
        String valor = "";
        boolean primeiraEntrada = true;
        boolean entradaValida = false;

        while (!entradaValida) {
            if (primeiraEntrada) {
                primeiraEntrada = false;
                if (!(input.isBlank() || input.isEmpty())) {
                    valor = input;
                    entradaValida = true;
                }
            } else {
                System.out.println("Entrada vazia. Digite um nome que contenha pelo menos um caractére: ");
                valor = scanner.nextLine();
                if (!(valor.isBlank() || valor.isEmpty())) {
                    entradaValida = true;
                }
            }

        }
        return valor;
    }

    public static int obterIntValido(Scanner scanner, String input) {
        int numero = 0;
        boolean primeiraEntrada = true;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                if (primeiraEntrada) {
                    primeiraEntrada = false;
                    numero = Integer.parseInt(input);
                    entradaValida = true;
                } else {
                    System.out.println("Digite um número válido: ");
                    numero = Integer.parseInt(scanner.nextLine());
                    entradaValida = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido. \n");
            }
        }

        return numero;
    }
}
