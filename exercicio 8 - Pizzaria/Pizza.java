import java.util.List;

public class Pizza {
    private String nome;
    private double valor;
    private List<String> ingredientes;

    public Pizza(String nome, double valor, List<String> ingredientes) {
        this.nome = nome;
        this.valor = valor;
        this.ingredientes = ingredientes;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void exibirPizza() {
        System.out.println("Pizza: " + nome);
        System.out.println("Preço: R$" + valor);
        System.out.print("Ingredientes: ");
        for (String ing : ingredientes) {
            System.out.print(ing + " ");
        }
        System.out.println();
    }
}
