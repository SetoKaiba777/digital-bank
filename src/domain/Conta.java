package domain;

import lombok.Getter;

@Getter
public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL=1;


    protected int agencia;
    protected int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente, Banco banco) {
        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.saldo = 0;
        banco.addConta(this);
    }


    @Override
    public void sacar(double valor) {
        if(saldo < valor){
            System.out.println("Saldo insuficiente para saque");
        }else{
            saldo-=valor;
        }
    }

    @Override
    public void depositar(double valor) {
        saldo+=valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if(saldo < valor){
            System.out.println("Saldo insuficiente para transferencia");
        }else{
            sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    protected void imprimirInfoComuns(){
        System.out.println(String.format("Titular: %s",cliente.getNome()));
        System.out.println(String.format("Agência: %d",agencia));
        System.out.println(String.format("Numero: %d",numero));
        System.out.println(String.format("Saldo: %.2f",saldo));
    }
}
