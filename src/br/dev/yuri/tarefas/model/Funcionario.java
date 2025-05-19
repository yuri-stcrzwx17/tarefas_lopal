package br.dev.yuri.tarefas.model;

public class Funcionario {

	private String nome;
	private int matricula;
	private String cargo;

	// metodo construtor
	public Funcionario(String nome) {
		this.nome = nome;
	}

	public Funcionario() {

	}

	public Funcionario(String cargo, String nome) {
		this.cargo = cargo;
	}

	public Funcionario(String cargo, String nome, int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		String funcionario = matricula + " , " + nome + " , " + cargo;
		return funcionario;
	}

}
