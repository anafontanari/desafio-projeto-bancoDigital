import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public abstract class Conta {
    private static int SEQUENCIAL = 1;
    
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<String> historico;

    public Conta(Cliente cliente) {
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.historico = new ArrayList<>();
        this.historico.add("Conta criada");
    }

    public void depositar(double valor) {
        this.saldo += valor;
        this.historico.add("Depósito de: " + valor);
    }

    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            this.historico.add("Saque de: " + valor);
        } else {
            System.out.println("Saldo insuficiente.");
            this.historico.add("Tentativa de saque falhou. Saldo insuficiente.");
        }
    }

    public void transferir(double valor, Conta contaDestino) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
            this.historico.add("Transferência de: " + valor + " para a conta " + contaDestino.getNumero());
        } else {
            System.out.println("Saldo insuficiente.");
            this.historico.add("Tentativa de transferência falhou. Saldo insuficiente.");
        }
    }

    public void imprimirExtrato() {
        System.out.println("Extrato da conta " + this.numero + ":");
        System.out.println("Saldo atual: " + this.saldo);
        // Adicione mais detalhes ao extrato, se necessário
    }

    public void imprimirHistorico() {
        System.out.println("Histórico da conta " + this.numero + ":");
        for (String evento : this.historico) {
            System.out.println(evento);
        }
    }
}


