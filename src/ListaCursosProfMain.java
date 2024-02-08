import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.ValidacaoValoresUtils.obterStringNaoVazia;

public class ListaCursosProfMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printLogoFMT();

        List<String> listaCursos = new ArrayList<>();
        List<String> listaProfessores = new ArrayList<>();


        while (true) {

            mostrarMenuPrincipal();

            String entradaUsuario = scanner.nextLine();

            if (entradaUsuario.equalsIgnoreCase("exit") ||
                    entradaUsuario.equalsIgnoreCase("0")) {
                listarValores(listaCursos, listaProfessores);
                scanner.close();
                System.out.println("\nSaindo do programa.");
                System.exit(0);
            }

            if (entradaUsuario.equalsIgnoreCase("1")) {
                adicionaEntradaLista(scanner, listaCursos, listaProfessores);
            } else {
                System.out.println("Comando inválido. Use um dos comandos informados anteriormente. \n");
            }



        }


    }

    public static void adicionaEntradaLista(Scanner scanner, List<String> listaCursos, List<String> listaProfessores)
    {
        System.out.println("Digite o curso a ser inserido na lista. \n");
        String entrada = obterStringNaoVazia(scanner, scanner.nextLine());
        listaCursos.add(entrada);
        System.out.println("Digite o professor que leciona este curso. \n");
        entrada = obterStringNaoVazia(scanner, scanner.nextLine());
        listaProfessores.add(entrada);
    }

    public static void listarValores(List<String> listaCursos, List<String> listaProfessores){
        System.out.println("\nLISTA DE CURSOS/PROFESSORES: \n");

        for (int i = 0; i < listaCursos.size(); i++) {
            String curso = listaCursos.get(i);
            String professor = listaProfessores.get(i);
            System.out.println(" - Curso: " + curso + ", Professor: " + professor);
        }
    }

    public static void printLogoFMT()
    {
        System.out.println("███████╗██╗   ██╗██╗     ██╗         ███████╗████████╗ █████╗  ██████╗██╗  ██╗");
        System.out.println("██╔════╝██║   ██║██║     ██║         ██╔════╝╚══██╔══╝██╔══██╗██╔════╝██║ ██╔╝");
        System.out.println("█████╗  ██║   ██║██║     ██║         ███████╗   ██║   ███████║██║     █████╔╝ ");
        System.out.println("██╔══╝  ██║   ██║██║     ██║         ╚════██║   ██║   ██╔══██║██║     ██╔═██╗ ");
        System.out.println("██║     ╚██████╔╝███████╗███████╗    ███████║   ██║   ██║  ██║╚██████╗██║  ██╗");
        System.out.println("╚═╝      ╚═════╝ ╚══════╝╚══════╝    ╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝");
        System.out.println("                                                                              ");
    }


    public static void mostrarMenuPrincipal(){
        System.out.println("Bem vindo ao programa de exercicios do Modulo 1 - Semana 4 do curso FullStack. \n");
        System.out.println("Para adicionar um curso/professor a lista, digite '1' \n");
        System.out.print("Para sair do programa, digite 'exit' ou '0'. \n");
    }
}
