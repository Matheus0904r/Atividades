public class Jogador {
    private String nome;
    private int pontuacao;
    private int nivel;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
        this.nivel = 1;
    }

    public void aumentarPontuacao(int pontos) {
        if (pontos > 0) {
            pontuacao += pontos;
            System.out.println("Pontuação aumentada em " + pontos + " pontos!");
        } else {
            System.out.println("Valor inválido para pontuação.");
        }
    }

    public void subirNivel() {
        nivel++;
        System.out.println(nome + " subiu para o nível " + nivel + "!");
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Pontuação: " + pontuacao);
        System.out.println("Nível: " + nivel);
    }

    public String getNome() {
        return nome;
    }
}
