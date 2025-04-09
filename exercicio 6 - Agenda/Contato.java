public class Contato {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void exibirContato() {
        System.out.println("Nome: " + nome + " | Telefone: " + telefone);
    }
}
