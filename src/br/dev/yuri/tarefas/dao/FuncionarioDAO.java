package br.dev.yuri.tarefas.dao;

import br.dev.yuri.tarefas.factory.FileFactory;
import br.dev.yuri.tarefas.model.Funcionario;

public class FuncionarioDAO {

	private FuncionarioDAO {

	private Funcionario funcionario;

	public FuncionarioDAO() {
	}

	public FuncionarioDAO(Funcionario funciorario) {
		this.funcionario = funcionario;
	}

	public void gravar() 
	
	
	{
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferedWriter().write("");
			ff.getBufferedWriter().flush();
			System.out.println("Funcionario Cadastrado com Sucesso =) ");
		} catch (IOExeption e) {
			e.printStackTrace();
		}

	}
}

}
