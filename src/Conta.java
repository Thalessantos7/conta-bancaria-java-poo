import java.util.ArrayList;

public class Conta {
    private double saldo;
    private String titular, agencia, cpf;
    private int numero;
    private Data dataDeAbertura;
    private ArrayList<Transacao> historico = new ArrayList<>();

    Conta(String titular, String cpf, int numero, double saldo, int dia, int mes, int ano) {
        this.titular = titular;
        this.saldo = saldo;
        this.cpf = cpf;
        this.agencia = "Banco ADS";
        this.numero = numero;
        this.dataDeAbertura = new Data(dia, mes, ano);
    }

    public void sacar(double valor, int dia, int mes, int ano) {
        if (valor > 0 && valor <= this.saldo && this.saldo > 0) {
            this.saldo -= valor;
            Transacao t = new Transacao("Saque", valor, dia, mes, ano);
            this.historico.add(t);

            System.out.printf("Valor de R$%.2f sacado com sucesso!%n", valor);
        } else {
            System.out.println("Saque falhou!");
        }
    }

    public void depositar(double valor, int dia, int mes, int ano) {
        if (valor > 0) {
            this.saldo += valor;
            Transacao t = new Transacao("Depósito", valor, dia, mes, ano);
            this.historico.add(t);

            System.out.printf("Valor de R$%.2f depositado com sucesso!%n", valor);
        } else {
            System.out.println("Depósito falhou!");
        }
    }

    public void transferir(double valor, Conta destino, int dia, int mes, int ano) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            destino.saldo += valor;
            Transacao t = new Transacao("Transferência", valor, dia, mes, ano);
            this.historico.add(t);

            System.out.println(this.titular + String.format(" transferiu R$%.2f para ", valor) + destino.titular + "!");
        } else {
            System.out.println("Transferência fahou!");
        }
    }

    private void mostrarHistorico() {
        for (Transacao t : this.historico) {
            System.out.print(t.mostrarTransação());
        }
    }

    public void resumo() {
        System.out.printf("""
        -----INFORMAÇÕES DA CONTA-----
        Agência: %s
        Titular: %s
        CPF: %s
        Número: %d
        Saldo: %.2f%n""", this.agencia, this.titular, this.cpf, this.numero, this.saldo);
        System.out.print("Data de abertura: ");
        System.out.println(dataDeAbertura.mostrarData());

        System.out.println("-----HISTÓRICO DE TRANSAÇÕES-----");
        mostrarHistorico();
    }
}