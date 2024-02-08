import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.ValidacaoValoresUtils.obterStringNaoVazia;

public class ListaCursosProfMain {

    public static void main(String[] args) {

        List<String> listaCursos = new ArrayList<>();
        List<String> listaProfessores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        printLogoFMT();

        System.out.println("Bem vindo ao programa de exercicios do Modulo 1 - Semana 4 do curso FullStack. \n");

        while (true) {
            mostrarMenuPrincipal();

            String entradaUsuario = scanner.nextLine();

            if (entradaUsuario.equalsIgnoreCase("sair") ||
                    entradaUsuario.equalsIgnoreCase("0")) {
                listarValores(listaCursos, listaProfessores);
                System.out.println("\n Saindo do programa.");
                scanner.close();
                System.exit(0);
            }

            switch (entradaUsuario.toLowerCase()) {
                case "1":
                    listarValores(listaCursos, listaProfessores);
                    break;
                case "2":
                    adicionaEntradaLista(scanner, listaCursos, listaProfessores);
                    break;
                default:
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
        if(listaCursos.isEmpty()){
            System.out.println("Nenhum curso foi adicionado a lista.");
        } else {
            for (int i = 0; i < listaCursos.size(); i++) {
                String curso = listaCursos.get(i);
                String professor = listaProfessores.get(i);
                System.out.println(i + " - Curso: " + curso + ", Professor: " + professor);
            }
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
        System.out.println("\nPara listar os valores adicionados, digite '1'.");
        System.out.println("Para adicionar um curso/professor a lista, digite '2'.");
        System.out.print("Para sair do programa, digite 'exit' ou '0'. \n");
    }
}