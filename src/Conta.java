import java.util.ArrayList;

public class Conta {
    private double saldo;
    private String titular, agencia, cpf;
    private int numero;
    private int diaDeAbertura, mesAbertura, anoAbertura;
    private ArrayList<Integer> diaTransacoes = new ArrayList<>();
    private ArrayList<Integer> mesTransacoes = new ArrayList<>();
    private ArrayList<Integer> anoTransacoes = new ArrayList<>();
    private ArrayList<String> tipoTransacoes = new ArrayList<>();
    private ArrayList<Double> valorTransacoes = new ArrayList<>();

    Conta(String titular, double saldo, String cpf, int dia, int mes, int ano) {
        this.titular = titular;
        this.saldo = saldo;
        this.cpf = cpf;
        this.agencia= "Banco ADS";
        this.diaDeAbertura = dia;
        this.mesAbertura = mes;
        this.anoAbertura = ano;
        numero = 12345;
    }

    public void sacar(double valor, int dia, int mes, int ano) {
        if (valor <= saldo && saldo != 0) {
            saldo -= valor;
            diaTransacoes.add(dia);
            mesTransacoes.add(mes);
            anoTransacoes.add(ano);
            tipoTransacoes.add("Saque");
            valorTransacoes.add(valor);
        } else {
            System.out.println("Saldo insuficiente, saque falhou!");
        }
    }

    public void depositar(double valor, int dia, int mes, int ano) {
        if (valor > 0) {
            saldo += valor;
            diaTransacoes.add(dia);
            mesTransacoes.add(mes);
            anoTransacoes.add(ano);
        }
    }

    public void transferir(double valor, Conta conta, Conta destino, int dia, int mes, int ano) {
        if (conta.saldo >= valor) {
            conta.saldo -= valor;
            destino.saldo += valor;
            diaTransacoes.add(dia);
            mesTransacoes.add(mes);
            anoTransacoes.add(ano);
            tipoTransacoes.add("Transferência");
        } else {
            System.out.println("Saldo insuficiente, transferência falhou!");
        }
    }

    public void resumo() {
        System.out.printf("""
                -----INFORMAÇÕES DA CONTA-----
                Titular: %s
                Saldo: %.2f
                CPF: %s
                Número: %d
                Agência: %s
                Data de abertura: %d/%d/%d%n""", titular, saldo, cpf, numero, agencia, diaDeAbertura, mesAbertura, anoAbertura);

                for (int i = 0; i < diaTransacoes.size() - 1; i++) {
                    System.out.printf("""
                            -----TRANSAÇÕES DA CONTA-----
                            Tipo: %s
                            Valor: %.2f
                            Data: %d/%d/%d""",tipoTransacoes.get(i), valorTransacoes.get(i), diaTransacoes.get(i), mesTransacoes.get(i), anoTransacoes.get(i));
                }
    }
}