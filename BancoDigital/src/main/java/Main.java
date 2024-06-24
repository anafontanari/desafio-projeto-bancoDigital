import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Conta> contas = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nBem-vindo ao Banco Digital!");
            System.out.println("1. Criar Conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Imprimir Extrato");
            System.out.println("6. Imprimir Histórico");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    depositar();
                    break;
                case 3:
                    sacar();
                    break;
                case 4:
                    transferir();
                    break;
                case 5:
                    imprimirExtrato();
                    break;
                case 6:
                    imprimirHistorico();
                    break;
                case 7:
                    System.out.println("Obrigado por usar o Banco Digital!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void criarConta() {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);

        System.out.println("Escolha o tipo de conta: ");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        int tipoConta = scanner.nextInt();
        scanner.nextLine();  // Consome a nova linha

        Conta novaConta = null;
        if (tipoConta == 1) {
            novaConta = new ContaCorrente(cliente);
        } else if (tipoConta == 2) {
            novaConta = new ContaPoupanca(cliente);
        } else {
            System.out.println("Tipo de conta inválido. Tente novamente.");
            return;
        }

        contas.put(novaConta.getNumero(), novaConta);
        System.out.println("Conta criada com sucesso! Número da conta: " + novaConta.getNumero());
    }

    private static void depositar() {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();  // Consome a nova linha

        Conta conta = contas.get(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Digite o valor do depósito: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();  // Consome a nova linha

        conta.depositar(valor);
        System.out.println("Depósito realizado com sucesso!");
    }

    private static void sacar() {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();  // Consome a nova linha

        Conta conta = contas.get(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        System.out.print("Digite o valor do saque: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();  // Consome a nova linha

        conta.sacar(valor);
        System.out.println("Saque realizado com sucesso!");
    }

    private static void transferir() {
        System.out.print("Digite o número da conta de origem: ");
        int numeroContaOrigem = scanner.nextInt();
        scanner.nextLine();  // Consome a nova linha

        Conta contaOrigem = contas.get(numeroContaOrigem);
        if (contaOrigem == null) {
            System.out.println("Conta de origem não encontrada.");
            return;
        }

        System.out.print("Digite o número da conta de destino: ");
        int numeroContaDestino = scanner.nextInt();
        scanner.nextLine();  // Consome a nova linha

        Conta contaDestino = contas.get(numeroContaDestino);
        if (contaDestino == null) {
            System.out.println("Conta de destino não encontrada.");
            return;
        }

        System.out.print("Digite o valor da transferência: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();  // Consome a nova linha

        contaOrigem.transferir(valor, contaDestino);
        System.out.println("Transferência realizada com sucesso!");
    }

    private static void imprimirExtrato() {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();  // Consome a nova linha

        Conta conta = contas.get(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        conta.imprimirExtrato();
    }

    private static void imprimirHistorico() {
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();  // Consome a nova linha

        Conta conta = contas.get(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        conta.imprimirHistorico();
    }
}



