import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean sair = false;
        Scanner scanner = new Scanner(System.in);
        float n1;
        float n2;

        System.out.println("Seja bem vindo a calculadora!");
        while(!sair) {
            System.out.println("[+] Adicionar");
            System.out.println("[-] Subtrair");
            System.out.println("[/] Dividir");
            System.out.println("[*] Multiplicar");
            System.out.println("[S] Sair");
            System.out.print("Escolha uma das opções acima : ");
            String opcao = scanner.nextLine();
            opcao = opcao.toLowerCase().trim();


            switch (opcao) {
                case "+":
                    System.out.println("Opção soma escolhida.");
                    System.out.print("Digite o primeiro número: ");
                    n1 = Float.parseFloat(scanner.nextLine());
                    System.out.print("Digite o segundo número: ");
                    n2 = Float.parseFloat(scanner.nextLine());
                    System.out.println("");
                    System.out.println("A soma dos números, número 1: " + n1 + " + número 2: " + n2 + " = " + Calculadora.Adicionar(n1, n2));
                    System.out.println("");
                    break;
                case "-":
                    System.out.println("Opção subtrair escolhida.");
                    System.out.print("Digite o primeiro numero: ");
                    n1 = Float.parseFloat(scanner.nextLine());
                    System.out.print("Digite o segundo numero: ");
                    n2 = Float.parseFloat(scanner.nextLine());
                    System.out.println("");
                    System.out.println("A subtração dos números numero 1: " + n1 + " - número 2: " + n2 + " = " + Calculadora.Subtrair(n1, n2));
                    System.out.println("");
                    break;
                case "/":
                    System.out.println("Opção divisão escolhida.");
                    System.out.print("Digite o primeiro número: ");
                    n1 = Float.parseFloat(scanner.nextLine());
                    System.out.print("Digite o segundo número: ");
                    n2 = Float.parseFloat(scanner.nextLine());
                    System.out.println("");

                    if (n1 == 0 || n2 == 0){
                        System.out.println("Nenhum dos números pode ser dividido por 0.");
                        System.out.println("");
                        continue;

                    }
                    System.out.println("");
                    System.out.println("A divisao dos números número 1: " + n1 + " / número 2: " + n2 + " = " + Calculadora.Dividir(n1, n2));
                    break;
                case "*":
                    System.out.println("Opção multiplicar escolhida.");
                    System.out.print("Digite o primeiro numero: ");
                    n1 = Float.parseFloat(scanner.nextLine());
                    System.out.print("Digite o segundo numero: ");
                    n2 = Float.parseFloat(scanner.nextLine());
                    System.out.println("");
                    System.out.println("A multiplicação dos números n1: " + n1 + " x número 2: " + n2 + " = " + Calculadora.Multiplicar(n1, n2));
                    System.out.println("");
                    break;
                case "s":
                    System.out.println("Tchau até a proxima :)");
                    sair = true;
                    continue;
                case "sair":
                    System.out.println("Tchau até a proxima :)");
                    sair = true;
                    continue;
                default:
                    System.out.println("Opção escolhida invalida");
                    break;
            }
        }

        scanner.close();

    }
}