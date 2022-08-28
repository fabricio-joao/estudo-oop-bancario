package entidades;

public class Cliente extends ContaBancaria {
	private static int totalContas;
	private String titular;
	private int senha;
	private int numConta;

	private ContaCorrente contaCorrente;
	private ContaPoupanca contaPoupanca;
	private Boleto boleto;
    

	public Cliente(String agencia, double saldo, String titular) {
		super(agencia, saldo);
		this.titular = titular;
		this.senha = 123;
		System.out.println("****BANCO NACONAL****" + "\n");
		Cliente.totalContas += 1;
	}

	public static int getTotalContas() {
		return totalContas;
	}

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public ContaPoupanca getContaPoupanca() {
		return contaPoupanca;
	}

	public void setContaPoupanca(ContaPoupanca contaPoupanca) {
		this.contaPoupanca = contaPoupanca;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getSenha() {
		return senha;
	}

	public boolean validacao(int senha) {
		if (this.getSenha() == senha) {
			return true;
		} else {
			return false;
		}
	}
}
