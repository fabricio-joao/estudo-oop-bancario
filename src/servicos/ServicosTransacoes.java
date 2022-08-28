package servicos;

import java.time.LocalDate;

import entidades.Boleto;
import entidades.Cliente;
import excecao.DominioExcecao;

public class ServicosTransacoes {
	private TaxasImpostos tx;

	public ServicosTransacoes(TaxasImpostos tx) {
		this.tx = tx;
	}

	public void deposito(Cliente c, double valor) throws DominioExcecao {
		if (valor < 0) {
			throw new DominioExcecao("Operação deposito indíponivel, valor inadequado: $" + valor);
		} else {
			c.setSaldo(c.getSaldo() + valor);
			c.setBoleto(new Boleto(c.getSaldo(), c.getTitular(), c.getAgencia()));
		}
	}

	public void sacar(Cliente c, double valor) throws DominioExcecao {
		if (valor < 0 || valor > c.getSaldo()) {
			throw new DominioExcecao("Operação saque indíponivel, valor inadequado: $" + valor);
		} else {
			c.setSaldo(c.getSaldo() - valor);
			c.setBoleto(new Boleto(c.getSaldo(), c.getTitular(), c.getAgencia()));
		}
	}

	public void emprestimoLimite(Cliente c, double valor) throws DominioExcecao {
		if (valor > c.getContaCorrente().getLimiteEmprestimo()) {
			throw new DominioExcecao("Operação emprestimo indíponivel, valor inadequado: $" + valor);
		} else {
			c.setSaldo(c.getSaldo() + valor);
			c.setBoleto(new Boleto(c.getSaldo(), c.getTitular(), c.getAgencia()));
		}
	}

	public void atualizaSaldo(Cliente c) {
		LocalDate dataHoje = LocalDate.now();
		LocalDate data = c.getContaPoupanca().getData();
		if (dataHoje.isBefore(data)) {
			c.setSaldo(c.getSaldo() + tx.taxas(c.getSaldo()));
			c.setBoleto(new Boleto(c.getSaldo(), c.getTitular(), c.getAgencia()));
		} else {
			c.setSaldo(c.getSaldo());
			c.setBoleto(new Boleto(c.getSaldo(), c.getTitular(), c.getAgencia()));
		}
	}
}
