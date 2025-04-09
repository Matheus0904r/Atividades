public class Produto {
    private String nome;
    private String codigo;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, String codigo, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public void atualizar(String novoNome, double novoPreco, int novaQuantidade) {
        this.nome = novoNome;
        this.preco = novoPreco;
        this.quantidadeEstoque = novaQuantidade;
    }

    public double calcularValorTotal() {
        return preco * quantidadeEstoque;
    }

    public void exibirInformacoes() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$" + preco);
        System.out.println("Quantidade em estoque: " + quantidadeEstoque);
        System.out.println("Valor total em estoque: R$" + calcularValorTotal());
        System.out.println();
    }
}
