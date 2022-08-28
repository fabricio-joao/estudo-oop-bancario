package entidades;

public class Boleto {

	private double recebeSaldo;
	private String titular;
	private String agencia;

	public Boleto(double recebeSaldo, String titular, String agencia) {
		super();
		this.recebeSaldo = recebeSaldo;
		this.titular = titular;
		this.agencia = agencia;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public double getRecebeSaldo() {

		return recebeSaldo;
	}

	public void setRecebeSaldo(double recebeSaldo) {

		this.recebeSaldo = recebeSaldo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Titular: ");
		sb.append(this.getTitular());
		sb.append("\nAgência: ");
		sb.append(this.getAgencia());
		sb.append("\nSaldo: R$");
		sb.append(String.format("%.2f", this.getRecebeSaldo()));
		
		/*String info = "Titular: " + this.getTitular();
		info += "\nAgencia: " + this.getAgencia();
		info += "\nSaldo Deposito: " + this.getRecebeSaldo();
		return info;*/
		return sb.toString();
	}
}
