public class Main {
    public static void main(String[] args) {
        Conta conta = new Conta("Thales", "202.344.180-20", 12345, 100, 15, 3, 2026);
        conta.sacar(50, 16, 3, 2026);
        conta.depositar(200, 17, 3, 2026);
        conta.resumo();
    }
}