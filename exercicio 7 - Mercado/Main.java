import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> estoque = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Atualizar produto");
            System.out.println("3 - Remover produto");
            System.out.println("4 - Listar produtos");
            System.out.println("5 - Ver valor total do estoque");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Código (único): ");
                    String codigo = scanner.nextLine();

                    System.out.print("Preço: ");
                    double preco = Double.parseDouble(scanner.nextLine());

                    System.out.print("Quantidade: ");
                    int quantidade = Integer.parseInt(scanner.nextLine());

                    estoque.add(new Produto(nome, codigo, preco, quantidade));
                    System.out.println("Produto adicionado!");
                    break;

                case 2:
                    System.out.print("Informe o código do produto: ");
                    String codigoAtualizar = scanner.nextLine();
                    Produto produtoAtualizar = null;

                    for (Produto p : estoque) {
                        if (p.getCodigo().equalsIgnoreCase(codigoAtualizar)) {
                            produtoAtualizar = p;
                            break;
                        }
                    }

                    if (produtoAtualizar != null) {
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();

                        System.out.print("Novo preço: ");
                        double novoPreco = Double.parseDouble(scanner.nextLine());

                        System.out.print("Nova quantidade: ");
                        int novaQuantidade = Integer.parseInt(scanner.nextLine());

                        produtoAtualizar.atualizar(novoNome, novoPreco, novaQuantidade);
                        System.out.println("Produto atualizado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Informe o código do produto para remover: ");
                    String codigoRemover = scanner.nextLine();
                    Produto produtoRemover = null;

                    for (Produto p : estoque) {
                        if (p.getCodigo().equalsIgnoreCase(codigoRemover)) {
                            produtoRemover = p;
                            break;
                        }
                    }

                    if (produtoRemover != null) {
                        estoque.remove(produtoRemover);
                        System.out.println("Produto removido!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    if (estoque.isEmpty()) {
                        System.out.println("Estoque vazio.");
                    } else {
                        System.out.println("Produtos :");
                        for (Produto p : estoque) {
                            p.exibirInformacoes();
                        }
                        System.out.println();
                    }
                    break;

                case 5:
                    double total = 0;
                    for (Produto p : estoque) {
                        total += p.calcularValorTotal();
                    }
                    System.out.println("Valor total em estoque: R$" + total);
                    break;

                case 0:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
