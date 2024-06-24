import java.time.LocalDateTime;

import lombok.Data;

/**
 * Representa uma transação bancária.
 */
@Data
public class Transacao {
    private LocalDateTime data;
    private String tipo; // "DEPOSITO", "SAQUE", "TRANSFERENCIA"
    private double valor;
    private String descricao;

    /**
     * Construtor para criar uma transação.
     *
     * @param tipo Tipo da transação.
     * @param valor Valor da transação.
     * @param descricao Descrição da transação.
     */
    public Transacao(String tipo, double valor, String descricao) {
        this.data = LocalDateTime.now();
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
    }
}




