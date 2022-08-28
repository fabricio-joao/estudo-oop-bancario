package aplicativo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entidades.Boleto;
import entidades.Cliente;
import entidades.ContaCorrente;
import entidades.ContaPoupanca;
import excecao.DominioExcecao;
import servicos.ServicosTransacoes;
import servicos.TaxasBrasil;

public class Programa {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		DateTimeFormatter dataformatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			Cliente c = new Cliente("443", 300, "Luiz Costa");
			int numContas = Cliente.getTotalContas();
			// System.out.print("Entre com a senha: ");
			// int senha = scan.nextInt();
			if (c.validacao(123)) { // SENHA:123
				System.out.print("Opeação: 1- Conta Corrente; 2- Conta Popança: ");
				int conta = scan.nextInt();
				scan.nextLine();
				switch (conta) {
				case 1:
					System.out.println("Deseja fazer emprestimos: [S/N] ");
					String dado = scan.nextLine();
					if (dado.equalsIgnoreCase("s")) {
						ContaCorrente cc = new ContaCorrente(c.getAgencia(), c.getSaldo(), 1000);
						c.setContaCorrente(cc);
						c.setBoleto(new Boleto(c.getSaldo(), c.getTitular(), c.getAgencia()));
						ServicosTransacoes st = new ServicosTransacoes(new TaxasBrasil());
						System.out.print("Entre com valor do emprestimo: ");
						double emprestimo = scan.nextDouble(); // valor do emprestimo
						st.emprestimoLimite(c, emprestimo);
						st.deposito(c, 100);
						st.sacar(c, 50);
						System.out.println(c.getBoleto());
					} else {
						ContaCorrente cc = new ContaCorrente(c.getAgencia(), c.getSaldo(), 1000);
						c.setContaCorrente(cc);
						c.setBoleto(new Boleto(c.getSaldo(), c.getTitular(), c.getAgencia()));
						ServicosTransacoes st = new ServicosTransacoes(new TaxasBrasil());
						st.deposito(c, 100);
						st.sacar(c, 30);
						System.out.println(c.getBoleto() + "\nTotal de contas: " + numContas);
					}
					break;
				case 2:
					System.out.print("Entre com data: (dd/MM/yyyy): ");
					LocalDate data = LocalDate.parse(scan.next(), dataformatada);
					ContaPoupanca cp = new ContaPoupanca(c.getAgencia(), c.getSaldo(), 10, data);
					c.setContaPoupanca(cp);
					c.setBoleto(new Boleto(c.getSaldo(), c.getTitular(), c.getAgencia()));
					ServicosTransacoes st = new ServicosTransacoes(new TaxasBrasil());
					System.out.print("Depositar [D] ou sacar [S]: ");
					String op = scan.next();
					if (op.equalsIgnoreCase("D")) {
						st.deposito(c, 10);
						System.out.println(c.getBoleto());
					} else if (op.equalsIgnoreCase("S")) {
						st.sacar(c, 10);
						System.out.println(c.getBoleto());
					} else {
						throw new DominioExcecao("Opção incorreta");
					}

					System.out.print("Consultar saldo poupança: [S/N]: ");
					String consulta = scan.next();
					if (consulta.equalsIgnoreCase("S")) {
						st.atualizaSaldo(c);
						System.out.println(c.getBoleto());
					} else if (consulta.equalsIgnoreCase("N")) {
						System.out.println(c.getBoleto());
					} else {
						throw new DominioExcecao("Opção incorreta");
					}
					break;
				default:
					System.out.print("Opção incorreta ");
				}
			} else {
				System.out.println("Senha incorreta");
			}
			scan.close();
		} catch (DominioExcecao e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Valor de entrada inválido");
		}
	}
}
