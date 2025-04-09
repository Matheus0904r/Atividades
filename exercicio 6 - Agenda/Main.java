import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcao;

        do {
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Buscar contato por nome");
            System.out.println("3 - Remover contato por nome");
            System.out.println("4 - Listar contatos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    agenda.adicionarContato(new Contato(nome, telefone));
                    break;

                case 2:
                    System.out.print("Digite o nome para buscar: ");
                    String busca = scanner.nextLine();
                    agenda.buscarContatoPorNome(busca);
                    break;

                case 3:
                    System.out.print("Digite o nome para remover: ");
                    String remover = scanner.nextLine();
                    agenda.removerContatoPorNome(remover);
                    break;

                case 4:
                    agenda.listarContatos();
                    break;

                case 0:
                    System.out.println("Saindo da agenda. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
