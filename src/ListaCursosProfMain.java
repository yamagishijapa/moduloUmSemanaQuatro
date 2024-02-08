import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.ValidacaoValoresUtils.obterIntValido;
import static utils.ValidacaoValoresUtils.obterStringNaoVazia;

public class ListaCursosProfMain {

    public static void main(String[] args) {

        List<String> listaCursos = new ArrayList<>();
        List<String> listaProfessores = new ArrayList<>();
        List<String> listaCursosConcluidos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        printLogoFMT();

        System.out.println("Bem vindo ao programa de exercicios do Modulo 1 - Semana 4 do curso FullStack. \n");

        while (true) {
            mostrarMenuPrincipal();

            String entradaUsuario = scanner.nextLine();

            if (entradaUsuario.equalsIgnoreCase("sair") ||
                    entradaUsuario.equalsIgnoreCase("0")) {
                listarValores(listaCursos, listaProfessores);
                System.out.println("\nSaindo do programa.");
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
                case "3":
                    if (listaCursos.isEmpty() && listaProfessores.isEmpty()) {
                        System.out.println("\nA lista de curso/professores está vazia. Não é possível remover um curso se não há nada a ser removido.");
                        System.out.println("Para executar essa operação, antes adicione algum curso/professor. \n");
                    } else
                        removerEntradaLista(scanner, listaCursos, listaProfessores);
                    break;
                case "4":
                    if (listaCursos.isEmpty() && listaProfessores.isEmpty()) {
                        System.out.println("\nA lista de curso/professores está vazia. Não é possível marcar um curso como concluído se não há nenhum curso listado.");
                        System.out.println("Para executar essa operação, antes adicione algum curso/professor. \n");
                    } else
                        marcarComoConcluido(scanner, listaCursos, listaProfessores, listaCursosConcluidos);
                    break;
                case "5":
                    listarValores(listaCursosConcluidos, null);
                    break;
                default:
                    System.out.println("Comando inválido. Use um dos comandos informados anteriormente. \n");
            }

        }
    }

    public static void adicionaEntradaLista(Scanner scanner, List<String> listaCursos, List<String> listaProfessores) {
        System.out.println("Digite o curso a ser inserido na lista. \n");
        String entrada = obterStringNaoVazia(scanner, scanner.nextLine());
        listaCursos.add(entrada);
        System.out.println("Digite o professor que leciona este curso. \n");
        entrada = obterStringNaoVazia(scanner, scanner.nextLine());
        listaProfessores.add(entrada);
    }

    public static void listarValores(List<String> listaCursos, List<String> listaProfessores) {
        if (listaProfessores == null) {
            System.out.println("\nLISTA DE CURSOS CONCLUÍDOS: \n");
            if (listaCursos.isEmpty()) {
                System.out.println("Nenhum curso foi marcado como concluído.");
            } else {
                for (int i = 0; i < listaCursos.size(); i++) {
                    String[] cursoConcluidoSplit = listaCursos.get(i).split(" - ");
                    String curso = cursoConcluidoSplit[0];
                    String professor = cursoConcluidoSplit[1];
                    System.out.println(i + " - Curso: " + curso + ", Professor: " + professor);
                }
            }
        } else {
            System.out.println("\nLISTA DE CURSOS/PROFESSORES: \n");
            if (listaCursos.isEmpty()) {
                System.out.println("Não há nenhum curso listado.");
            } else {
                for (int i = 0; i < listaCursos.size(); i++) {
                    String curso = listaCursos.get(i);
                    String professor = listaProfessores.get(i);
                    System.out.println(i + " - Curso: " + curso + ", Professor: " + professor);
                }
            }
        }
    }

    public static void removerEntradaLista(Scanner scanner, List<String> listaCursos, List<String> listaProfessores) {
        System.out.println("Digite o índice a ser removido da lista. \n");
        removerItem(listarPedirIndice(scanner, listaCursos, listaProfessores), listaCursos, listaProfessores);
        System.out.println("Curso removido com sucesso!");
    }

    public static int listarPedirIndice(Scanner scanner, List<String> listaCursos, List<String> listaProfessores) {
        boolean indiceValido = false;
        int indice = 0;
        while (!indiceValido) {
            listarValores(listaCursos, listaProfessores);
            indice = obterIntValido(scanner, scanner.nextLine());
            if (!(indice >= 0 && indice < listaCursos.size())) {
                System.out.println("O índice está fora dos limites da lista. Informe um índice existente na lista.");
            } else
                indiceValido = true;
        }
        return indice;
    }

    public static void removerItem(int indice, List<String> listaCursos, List<String> listaProfessores) {
        listaCursos.remove(indice);
        listaProfessores.remove(indice);
    }

    public static void marcarComoConcluido(Scanner scanner, List<String> listaCursos, List<String> listaProfessores, List<String> listaCursosConcluidos) {
        System.out.println("Digite o índice do curso a ser marcado como concluído. \n");
        int valorIndice = listarPedirIndice(scanner, listaCursos, listaProfessores);
        String cursoConcluido = listaCursos.get(valorIndice) + " - " + listaProfessores.get(valorIndice);
        listaCursosConcluidos.add(cursoConcluido);
        removerItem(valorIndice, listaCursos, listaProfessores);
        System.out.println("Curso marcado como concluído com sucesso!");

    }

    public static void printLogoFMT() {
        System.out.println("███████╗██╗   ██╗██╗     ██╗         ███████╗████████╗ █████╗  ██████╗██╗  ██╗");
        System.out.println("██╔════╝██║   ██║██║     ██║         ██╔════╝╚══██╔══╝██╔══██╗██╔════╝██║ ██╔╝");
        System.out.println("█████╗  ██║   ██║██║     ██║         ███████╗   ██║   ███████║██║     █████╔╝ ");
        System.out.println("██╔══╝  ██║   ██║██║     ██║         ╚════██║   ██║   ██╔══██║██║     ██╔═██╗ ");
        System.out.println("██║     ╚██████╔╝███████╗███████╗    ███████║   ██║   ██║  ██║╚██████╗██║  ██╗");
        System.out.println("╚═╝      ╚═════╝ ╚══════╝╚══════╝    ╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝");
        System.out.println("                                                                              ");
    }


    public static void mostrarMenuPrincipal() {
        System.out.println("\nPara listar os valores adicionados, digite '1'.");
        System.out.println("Para adicionar um curso/professor a lista, digite '2'.");
        System.out.println("Para remover um curso/professor da lista, digite '3'.");
        System.out.println("Para marcar um curso com concluído, digite '4'.");
        System.out.println("Para listar os cursos concluídos, digite '5'.");
        System.out.print("Para sair do programa, digite 'exit' ou '0'. \n");
    }
}