package entidades;

public abstract class ContaBancaria {

	private String agencia;
	private double saldo;

	public ContaBancaria() {
		
	}
	
	public ContaBancaria(String agencia, double saldo) {
		super();
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
