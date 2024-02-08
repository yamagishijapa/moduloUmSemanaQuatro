package utils;

import java.util.Scanner;

public class ValidacaoValoresUtils {
    public static String obterStringNaoVazia(Scanner scanner, String input){
        String valor = "";
        boolean primeiraEntrada = true;
        boolean entradaValida = false;

        while (!entradaValida) {
            if (primeiraEntrada) {
                primeiraEntrada = false;
                if(!(input.isBlank() || input.isEmpty())) {
                    valor = input;
                    entradaValida = true;
                }
            } else {
                System.out.println("Entrada vazia. Digite um nome que contenha pelo menos um caractére: ");
                valor = scanner.nextLine();
                if(!(valor.isBlank() || valor.isEmpty())) {
                    entradaValida = true;
                }
            }

        }

        return valor;
    }
}
