package servicos;

public class TaxasBrasil implements TaxasImpostos {

	@Override
	public double taxas(double valor) {
		return (valor * 0.1) / 100;
	}
}
