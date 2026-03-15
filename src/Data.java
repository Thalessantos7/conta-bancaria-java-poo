public class Data {
    private int dia, mes, ano;

    Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String mostrarData() {
        return this.dia + "/" + this.mes + "/" + this.ano + "\n";
    }
}