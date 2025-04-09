import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pizza> cardapio = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();

        cardapio.add(new Pizza("Calabresa", 30.0, Arrays.asList("calabresa", "cebola", "queijo")));
        cardapio.add(new Pizza("Mussarela", 28.0, Arrays.asList("mussarela", "tomate", "orégano")));
        cardapio.add(new Pizza("Frango com Catupiry", 35.0, Arrays.asList("frango", "catupiry", "milho")));

        int opcao;

        do {
            System.out.println("1 - Ver cardápio");
            System.out.println("2 - Fazer pedido");
            System.out.println("3 - Cancelar pedido");
            System.out.println("4 - Listar pedidos");
            System.out.println("5 - Relatório de pedidos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("\n=== CARDÁPIO ===");
                    for (int i = 0; i < cardapio.size(); i++) {
                        System.out.println("[" + i + "] ");
                        cardapio.get(i).exibirPizza();
                    }
                    break;

                case 2:
                    System.out.println("Escolha a pizza pelo número:");
                    for (int i = 0; i < cardapio.size(); i++) {
                        System.out.println("[" + i + "] " + cardapio.get(i).getNome());
                    }
                    int escolha = Integer.parseInt(scanner.nextLine());

                    if (escolha < 0 || escolha >= cardapio.size()) {
                        System.out.println("Opção inválida.");
                        break;
                    }

                    System.out.print("Tamanho (pequena/média/grande): ");
                    String tamanho = scanner.nextLine();

                    System.out.print("Endereço de entrega: ");
                    String endereco = scanner.nextLine();

                    Pedido novoPedido = new Pedido(cardapio.get(escolha), tamanho, endereco);
                    pedidos.add(novoPedido);
                    System.out.println("Pedido realizado com sucesso!");
                    break;

                case 3:
                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido para cancelar.");
                        break;
                    }

                    System.out.println("Pedidos realizados:");
                    for (int i = 0; i < pedidos.size(); i++) {
                        System.out.println("[" + i + "] Pedido de " + pedidos.get(i).getValorFinal());
                    }

                    System.out.print("Digite o número do pedido para cancelar: ");
                    int cancelar = Integer.parseInt(scanner.nextLine());

                    if (cancelar >= 0 && cancelar < pedidos.size()) {
                        pedidos.remove(cancelar);
                        System.out.println("Pedido cancelado!");
                    } else {
                        System.out.println("Pedido inválido.");
                    }
                    break;

                case 4:
                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido registrado.");
                    } else {
                        for (Pedido p : pedidos) {
                            p.exibirPedido();
                        }
                    }
                    break;

                case 5:
                    int total = pedidos.size();
                    double soma = 0;
                    for (Pedido p : pedidos) {
                        soma += p.getValorFinal();
                    }

                    double media = total > 0 ? soma / total : 0;

                    System.out.println("Total de pedidos: " + total);
                    System.out.printf("Valor médio dos pedidos: R$%.2f\n", media);
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
