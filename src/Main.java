public class Main {
    public static void main(String[] args) {
        Conta c1 = new Conta("Thales",100,"100.482.556-15", 16, 9, 2026);
        c1.sacar(50, 11, 3, 2026);
        c1.depositar(200, 12, 3, 2026);
        c1.resumo();
    }
}