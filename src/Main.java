
public class Main {

	public static void main(String[] args) {
		
		Banco banco = new Banco();
		
		Cliente cliente1 = new Cliente("Willian");
		Cliente cliente2 = new Cliente("José");
		
		Conta conta1 = new ContaCorrente(cliente1, banco);
		Conta conta2 = new ContaCorrente(cliente2, banco);
		
		conta1.imprimirExtrato();
		conta1.sacar(100);
		
		conta1.depositar(500);
		conta1.sacar(100);
		
		conta1.imprimirExtrato();
		
		conta2.depositar(1000);
		conta2.imprimirExtrato();
		
		System.out.println("--------------------------");
		banco.exibirClientes();
		banco.exibirPatrimonio();

	}

}
