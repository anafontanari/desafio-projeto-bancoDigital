import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Representa uma conta corrente, que é um tipo de conta bancária.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirExtrato();
    }

    @Override
    public void imprimirHistorico() {
        System.out.println("=== Histórico Conta Corrente ===");
        super.getHistorico().forEach(System.out::println);
    }
}
