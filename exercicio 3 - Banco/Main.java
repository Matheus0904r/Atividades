import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ContaBancaria> contas = new ArrayList<>();
        int opcao;

        do {
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Login");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número da conta: ");
                    String numero = scanner.nextLine();

                    System.out.print("Digite o nome do titular: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o saldo inicial: ");
                    double saldoInicial = Double.parseDouble(scanner.nextLine());

                    System.out.print("Digite uma senha pra sua conta: ");
                    String senha = scanner.nextLine();

                    boolean contaCriada = false;
                    for (ContaBancaria conta: contas) {
                        if (conta.getNumeroConta().equals(numero)) {
                            System.out.println("Conta já existe em nome de " + conta.getNomeTitular());
                            contaCriada = true;
                            break;
                        }
                    }

                    if (contaCriada) {
                        break;
                    }

                    ContaBancaria novaConta = new ContaBancaria(numero, nome, saldoInicial, senha);
                    contas.add(novaConta);
                    System.out.println("Conta criada com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o número da conta: ");
                    String numeroLogin = scanner.nextLine();

                    System.out.print("Digite a senha da sua conta: ");
                    String senhaLogin = scanner.nextLine();

                    ContaBancaria contaLogada = null;
                    for (ContaBancaria conta : contas) {
                        if (conta.getNumeroConta().equals(numeroLogin)) {
                            if (conta.login(senhaLogin)) {
                                contaLogada = conta;
                                break;
                            }
                        }
                    }

                    if (contaLogada != null) {
                        System.out.println("Login realizado com sucesso!");
                        int opcaoLogin;
                        do {
                            System.out.println("Menu da Conta (" + contaLogada.getNomeTitular() + ")");
                            System.out.println("1 - Depositar");
                            System.out.println("2 - Sacar");
                            System.out.println("3 - Ver Saldo");
                            System.out.println("4 - Exibir Informações");
                            System.out.println("0 - Logout");
                            System.out.print("Escolha uma opção: ");
                            opcaoLogin = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcaoLogin) {
                                case 1:
                                    System.out.print("Digite o valor para depósito: ");
                                    double deposito = Double.parseDouble(scanner.nextLine());
                                    contaLogada.depositar(deposito);
                                    break;
                                case 2:
                                    System.out.print("Digite o valor para saque: ");
                                    double saque = Double.parseDouble(scanner.nextLine());
                                    contaLogada.sacar(saque);
                                    break;
                                case 3:
                                    System.out.println("Saldo atual: R$" + contaLogada.getSaldo());
                                    break;
                                case 4:
                                    contaLogada.exibirInformacoes();
                                    break;
                                case 0:
                                    System.out.println("Logout realizado.");
                                    break;
                                default:
                                    System.out.println("Opção inválida.");
                            }

                        } while (opcaoLogin != 0);

                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 3);

        scanner.close();
    }
}
