import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jogador> jogadores = new ArrayList<>();
        int opcao;

        do {
            System.out.println("1 - Criar novo jogador");
            System.out.println("2 - Listar jogadores");
            System.out.println("3 - Aumentar pontuação de um jogador");
            System.out.println("4 - Subir nível de um jogador");
            System.out.println("5 - Exibir informações de um jogador");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do jogador: ");
                    String nome = scanner.nextLine();
                    Jogador novo = new Jogador(nome);
                    jogadores.add(novo);
                    System.out.println("Jogador criado com sucesso!");
                    break;

                case 2:
                    if (jogadores.isEmpty()) {
                        System.out.println("Nenhum jogador cadastrado.");
                    } else {
                        System.out.println("Jogadores: ");
                        for (int i = 0; i < jogadores.size(); i++) {
                            System.out.println((i + 1) + " - " + jogadores.get(i).getNome());
                        }
                    }
                    break;

                case 3:
                    if (jogadores.isEmpty()) {
                        System.out.println("Nenhum jogador para atualizar.");
                        break;
                    }
                    System.out.print("Digite o número do jogador para aumentar pontuação: ");
                    int indexPontuacao = scanner.nextInt() - 1;
                    if (indexPontuacao >= 0 && indexPontuacao < jogadores.size()) {
                        System.out.print("Quanto deseja adicionar à pontuação? ");
                        int pontos = scanner.nextInt();
                        jogadores.get(indexPontuacao).aumentarPontuacao(pontos);
                    } else {
                        System.out.println("Jogador inválido.");
                    }
                    break;

                case 4:
                    if (jogadores.isEmpty()) {
                        System.out.println("Nenhum jogador para subir de nível.");
                        break;
                    }
                    System.out.print("Digite o número do jogador para subir de nível: ");
                    int indexNivel = scanner.nextInt() - 1;
                    if (indexNivel >= 0 && indexNivel < jogadores.size()) {
                        jogadores.get(indexNivel).subirNivel();
                    } else {
                        System.out.println("Jogador inválido.");
                    }
                    break;

                case 5:
                    if (jogadores.isEmpty()) {
                        System.out.println("Nenhum jogador para exibir.");
                        break;
                    }
                    System.out.print("Digite o número do jogador: ");
                    int indexInfo = scanner.nextInt() - 1;
                    if (indexInfo >= 0 && indexInfo < jogadores.size()) {
                        jogadores.get(indexInfo).exibirInformacoes();
                    } else {
                        System.out.println("Jogador inválido.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema. Valeu!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
