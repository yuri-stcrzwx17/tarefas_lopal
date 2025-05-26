package br.dev.yuri.tarefas;

import java.util.UUID;

import br.dev.yuri.tarefas.dao.FuncionarioDAO;
import br.dev.yuri.tarefas.model.Funcionario;
import br.dev.yuri.tarefas.ui.FrameFuncionario;
import br.dev.yuri.tarefas.utils.Utils;

public class Main {

	public static void main(String[] args) {
		
		new FrameFuncionario();

		//Funcionario f = new Funcionario();
		//Funcionario f2 = new Funcionario("Yuri");
		//f.setNome("Paulo Gomes");
		//f.setCargo("Programador Jr");
		//f.setSalario(1989, 73);

		FuncionarioDAO dao = new FuncionarioDAO();
		dao.gravar();

		System.out.println(Utils.gerarUUID8);

		// Funcionario funcionario1 = new Funcionario("Maria da Silva");
		// Funcionario funcionario2 = new Funcionario();

		// funcionario2.setMatricula(9);
		// funcionario2.setNome("Patricia");
		// funcionario2.setCargo("Gerente de TI");

		// Funcionario funcionario3 = new Funcionario("Programador", "Ana Maria");
		// Funcionario funcionario4 = new Funcionario("Progarmador", "Pedro", 2,
		// 5000.0);

		// System.out.println(funcionario1.toString());
		// System.out.println(funcionario2);
		// System.out.println(funcionario3);

	}

}
