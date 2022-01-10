import domain.*;

public class Main {
    public static void main(String[] args) {
        Banco meuBanco = new Banco("Meu Banco");
        Cliente caio = new Cliente("Caio");

        Conta cc  = new ContaCorrente(caio, meuBanco);
        Conta poupanca = new ContaPoupanca(caio, meuBanco);

        cc.depositar(100);
        cc.transferir(100,poupanca);

        meuBanco.imprimirContas();

    }
}
