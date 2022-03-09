
public class Banco {
	
	private static int NUMERO_CLIENTES = 0;
	
	private Conta[] contas = new Conta[100];
	
	public void exibirClientes() {
		for(int i = 0; i < NUMERO_CLIENTES; i++) {
			System.out.println(contas[i].getCliente().getNome());
		}
	}
	
	public void exibirPatrimonio() {
		
		double saldoTotal = 0; 
		
		for(int i = 0; i < NUMERO_CLIENTES; i++) {
			saldoTotal += contas[i].getSaldo();
		}
		
		System.out.println("Patrimonio do banco: " + String.format("%.2f", saldoTotal));
	}
	
	public void adicionarConta(Conta conta) {
		contas[NUMERO_CLIENTES] = conta;
		NUMERO_CLIENTES++;
	}
}
