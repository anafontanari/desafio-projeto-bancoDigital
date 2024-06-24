import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe representando um banco, contendo um nome e uma lista de contas.
 */
@Getter
@Setter
public class Banco {

    private String nome;
    private List<Conta> contas;

    /**
     * Busca todas as contas associadas a um cliente pelo nome.
     *
     * @param nomeCliente Nome do cliente.
     * @return Lista de contas associadas ao cliente.
     */
    public List<Conta> buscarContasPorCliente(String nomeCliente) {
        return contas.stream()
                     .filter(conta -> conta.getCliente().getNome().equals(nomeCliente))
                     .collect(Collectors.toList());
    }

    /**
     * Fecha (remove) uma conta do banco.
     *
     * @param conta Conta a ser fechada.
     */
    public void fecharConta(Conta conta) {
        contas.remove(conta);
        System.out.println("Conta " + conta.getNumero() + " fechada.");
    }
}

