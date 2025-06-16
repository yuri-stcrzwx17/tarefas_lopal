package br.dev.yuri.tarefas.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.yuri.tarefas.factory.FileFactory;
import br.dev.yuri.tarefas.model.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;

	public FuncionarioDAO() {
	}

	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void gravar() {
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferedWriter().write(funcionario.toString());
			ff.getBufferedWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Funcionario> listar() {

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			FileFactory ff = new FileFactory();
			BufferedReader br = ff.getBufferedReader();

			String linha = "";

			br.readLine();

			while (linha != null) {
				// extraindoi uma linha do arquivo
				linha = br.readLine();

				// Criando um vetor
				if (linha != null) {
					String funcionarioStr[] = linha.split(",");

					// Criando um objeto funcionario
					Funcionario funcionario = new Funcionario();
					funcionario.setMatricula(funcionarioStr[0]);
					funcionario.setNome(funcionarioStr[1]);
					funcionario.setCargo(funcionarioStr[2]);
					funcionario.setSalario(Double.parseDouble(funcionarioStr[3]));

					funcionarios.add(funcionario);
				}

			}

			return funcionarios;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}