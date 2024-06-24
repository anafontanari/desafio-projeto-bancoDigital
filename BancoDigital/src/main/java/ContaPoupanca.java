import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Representa uma conta poupança, que é um tipo de conta bancária.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirExtrato();
    }

    @Override
    public void imprimirHistorico() {
        System.out.println("=== Histórico Conta Poupança ===");
        super.getHistorico().forEach(System.out::println);
    }
}
