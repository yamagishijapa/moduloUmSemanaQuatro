import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                System.out.println("\n Os valores adicionados na lista de cursos foram: \n");
                for(String s : listaCursos){
                    System.out.println(" - " + s);
                }

                System.out.println("\n Os valores adicionados na lista de professores foram: \n");
                for(String s : listaProfessores){
                    System.out.println(" - " + s);
                }
                System.out.println("\n Saindo do programa.");
                System.exit(0);
            }

            switch (entradaUsuario.toLowerCase()) {
                case "1":
                    System.out.println("Digite o curso a ser inserido na lista. \n");
                    adicionaEntradaLista(scanner, listaCursos);
                    break;
                case "2":
                    System.out.println("Digite o professor a ser inserido na lista. \n");
                    adicionaEntradaLista(scanner, listaProfessores);
                    break;
                default:
                    System.out.println("Comando inválido. Use um dos comandos informados anteriormente. \n");
            }



        }


    }

    public static void adicionaEntradaLista(Scanner scanner, List<String> listaCursos)
    {
        String entrada = scanner.nextLine();
        listaCursos.add(entrada);
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
        System.out.println("Para adicionar um curso a lista, digite '1' \n");
        System.out.println("Para adicionar um professor a lista, digite '2' \n");
        System.out.print("Para sair do programa, digite 'exit' ou '0'. \n");
    }
}
