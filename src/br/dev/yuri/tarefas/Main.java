package br.dev.yuri.tarefas;

import br.dev.yuri.tarefas.model.Funcionario;

public class Main {

	public static void main(String[] args) {
		
		
		Funcionario funcionario1 = new Funcionario("Maria da Silva");
		Funcionario funcionario2 = new Funcionario();
		
		funcionario2.setMatricula(9);
		funcionario2.setNome("Patricia");
		funcionario2.setCargo("Gerente de TI");
		
		Funcionario funcionario3 = new Funcionario("Programador", "Ana Maria");
		Funcionario funcionario4 = new Funcionario("Progarmador", "Pedro", 2);
		
		System.out.println(funcionario1.toString());
		System.out.println(funcionario2);
		System.out.println(funcionario3);

	}

}
