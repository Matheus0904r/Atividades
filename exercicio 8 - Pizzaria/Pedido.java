public class Pedido {
    private Pizza pizza;
    private String tamanho; // Pequena, Média, Grande
    private String endereco;
    private double valorFinal;

    public Pedido(Pizza pizza, String tamanho, String endereco) {
        this.pizza = pizza;
        this.tamanho = tamanho;
        this.endereco = endereco;
        calcularValorFinal();
    }

    private void calcularValorFinal() {
        double multiplicador = 1.0;
        switch (tamanho.toLowerCase()) {
            case "média":
                multiplicador = 1.3;
                break;
            case "grande":
                multiplicador = 1.6;
                break;
            case "pequena":
            default:
                multiplicador = 1.0;
                break;
        }
        valorFinal = pizza.getValor() * multiplicador;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void exibirPedido() {
        System.out.println("Pedido de: " + pizza.getNome());
        System.out.println("Tamanho: " + tamanho);
        System.out.println("Endereço de entrega: " + endereco);
        System.out.println("Valor total: R$" + valorFinal);
        System.out.println();
    }
}
