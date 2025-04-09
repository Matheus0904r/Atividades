public class ContaBancaria {

    private String numeroConta;
    private String nomeTitular;
    private double saldo;
    private String senha;

    public ContaBancaria(String numeroConta, String nomeTitular, double saldo, String senha) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
        this.senha = senha;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor não pode ser menor ou igual a 0");
            return;
            }
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saque inválido. Verifique o valor e o saldo disponível.");
        }
    }

    public boolean login(String senha){
        if (this.senha.equalsIgnoreCase(senha)) {
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void exibirInformacoes() {
        System.out.println("Conta: " + numeroConta);
        System.out.println("Titular: " + nomeTitular);
        System.out.println("Saldo: R$" + saldo);
    }


}
