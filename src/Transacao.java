public class Transacao {
    private String tipo;
    private double valor;
    private Data data;

    Transacao(String tipo, double valor, int dia, int mes, int ano) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = new Data(dia, mes, ano);
    }

    public String mostrarTransação() {
        return this.tipo + String.format(" de R$%.2f em ", valor) + data.mostrarData();
    }
}