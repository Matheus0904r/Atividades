import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static void RegistrarLivro(Scanner scanner, ArrayList livros) {
        System.out.print("Insira o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Insira o autor do livro: ");
        String autor = scanner.nextLine();

        System.out.print("Insira o ano de publicação do livro: ");
        int ano = Integer.parseInt(scanner.nextLine());

        livros.add(new Livro(titulo, autor, ano));
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Livro> livros = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        System.out.println("Olá. Seja bem vindo a biblioteca!");

        while(!sair) {
            System.out.println("[1] Novo Livro");
            System.out.println("[2] Mostrar Livros");
            System.out.println("[3] Sair");
            System.out.print("Escolha uma opção acima: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    RegistrarLivro(scanner, livros);
                    break;
                case 2:
                    for (Livro livro: livros) {
                        System.out.println();
                        livro.exibirInfo();
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println();
                    System.out.print("Tchau até a próxima!");
                    sair = true;
                    continue;
                default:
                    System.out.println("Opção escolhida invalida :(");
                    System.out.println();
                    break;

            }

        }


    }
}