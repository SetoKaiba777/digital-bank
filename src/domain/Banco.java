package domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome){
        this.nome = nome;
        contas = new ArrayList<>();
    }

    public void addConta(Conta conta){
        contas.add(conta);
    }

    public void imprimirContas(){
        for(Conta conta : contas){
            conta.imprimirExtrato();
        }
    }
}
