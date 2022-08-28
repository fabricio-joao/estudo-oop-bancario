package entidades;

public class ContaCorrente extends ContaBancaria {
	
	private double LimiteEmprestimo;

	public ContaCorrente(String agencia, double saldo, double limiteEmprestimo) {
		super(agencia, saldo);
		LimiteEmprestimo = limiteEmprestimo;
	}

	public double getLimiteEmprestimo() {

		return LimiteEmprestimo;
	}

	public void setLimiteEmprestimo(double limiteEmprestimo) {

		LimiteEmprestimo = limiteEmprestimo;
	}

}
