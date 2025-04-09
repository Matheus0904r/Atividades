public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private int velocidadeAtual;

    public Carro(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.velocidadeAtual = 0;
    }

    public void acelerar(int valor) {
        if (valor > 0) {
            velocidadeAtual += valor;
            System.out.println("O carro acelerou em " + valor + " km/h.");
        } else {
            System.out.println("Valor inválido para aceleração.");
        }
    }

    public void frear(int valor) {
        if (valor > 0) {
            velocidadeAtual -= valor;
            if (velocidadeAtual < 0) {
                velocidadeAtual = 0;
            }
            System.out.println("O carro reduziu a velocidade em " + valor + " km/h.");
        } else {
            System.out.println("Valor inválido para frenagem.");
        }
    }

    public void exibirInformacoes() {
        System.out.println("\n=== Detalhes do Carro ===");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Placa: " + placa);
        System.out.println("Velocidade Atual: " + velocidadeAtual + " km/h");
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }
}
