
public abstract class Conta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	private int agencia;
	private int numero;
	private double saldo;
	private Cliente cliente;
	private Banco banco;
	
	
	public Conta(Cliente cliente, Banco banco) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.banco = banco;
		this.banco.adicionarConta(this);
	}
	
	//Indica se o a conta tem saldo suficiente para um determinado valor
	public boolean verificarSaldo(double valor) {
		if(valor <= this.saldo) {
			return true;
		}else {
			return false;
		}
	}
	
	public void sacar(double valor) {
		if(this.verificarSaldo(valor)) {
			this.saldo -= valor;
		}else {
			System.out.println("Saldo insuficiente!");
		}
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public void transferir(Conta conta, double valor) {
		if(this.verificarSaldo(valor)) {
			this.sacar(valor);
			conta.depositar(valor);
		}else {
			System.out.println("Saldo insuficiente!");
		}
	}
	
	public abstract void imprimirExtrato();
	
	protected void exibeInfos() {
		System.out.println("Cliente: " + this.cliente.getNome());
		System.out.println("Agencia: " + this.agencia);
		System.out.println("Conta: " + this.numero);
		System.out.println("Saldo: " + String.format("%.2f", this.saldo));
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
}
