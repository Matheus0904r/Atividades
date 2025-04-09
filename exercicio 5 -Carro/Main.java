import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Carro> carros = new ArrayList<>();
        int opcao;

        do {
            System.out.println("1 - Registrar novo carro");
            System.out.println("2 - Listar carros registrados");
            System.out.println("3 - Acelerar carro");
            System.out.println("4 - Frear carro");
            System.out.println("5 - Exibir informações de um carro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();

                    System.out.print("Ano: ");
                    int ano = Integer.parseInt(scanner.nextLine());

                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();

                    Carro novoCarro = new Carro(marca, modelo, ano, placa);
                    carros.add(novoCarro);
                    System.out.println("Carro registrado com sucesso!");
                    break;

                case 2:
                    if (carros.isEmpty()) {
                        System.out.println("Nenhum carro registrado.");
                    } else {
                        System.out.println("Carros Registrados");
                        for (int i = 0; i < carros.size(); i++) {
                            Carro c = carros.get(i);
                            System.out.println((i + 1) + " - " + c.getMarca() + " " + c.getModelo() + " | Placa: " + c.getPlaca());
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    if (carros.isEmpty()) {
                        System.out.println("Nenhum carro para acelerar.");
                        break;
                    }
                    System.out.print("Digite o número do carro: ");
                    int indexAcelerar = Integer.parseInt(scanner.nextLine()) - 1;

                    if (indexAcelerar >= 0 && indexAcelerar < carros.size()) {
                        System.out.print("Quanto deseja acelerar (km/h)? ");
                        int velocidade = Integer.parseInt(scanner.nextLine());
                        carros.get(indexAcelerar).acelerar(velocidade);
                    } else {
                        System.out.println("Carro inválido.");
                    }
                    break;

                case 4:
                    if (carros.isEmpty()) {
                        System.out.println("Nenhum carro para frear.");
                        break;
                    }
                    System.out.print("Digite o número do carro: ");
                    int indexFrear = Integer.parseInt(scanner.nextLine()) - 1;

                    if (indexFrear >= 0 && indexFrear < carros.size()) {
                        System.out.print("Quanto deseja reduzir (km/h)? ");
                        int freio = Integer.parseInt(scanner.nextLine());
                        carros.get(indexFrear).frear(freio);
                    } else {
                        System.out.println("Carro inválido.");
                    }
                    break;

                case 5:
                    if (carros.isEmpty()) {
                        System.out.println("Nenhum carro para exibir.");
                        break;
                    }
                    System.out.print("Digite o número do carro: ");
                    int indexInfo = Integer.parseInt(scanner.nextLine()) - 1;

                    if (indexInfo >= 0 && indexInfo < carros.size()) {
                        carros.get(indexInfo).exibirInformacoes();
                    } else {
                        System.out.println("Carro inválido.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema. Até o próximo evento!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
