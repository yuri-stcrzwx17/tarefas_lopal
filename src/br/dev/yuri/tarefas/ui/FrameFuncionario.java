package br.dev.yuri.tarefas.ui;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameFuncionario {
	
	private JLabel labelMatricula;
	private JLabel labelNome;
	private JLabel labelCargo;
	private JLabel labelSalario;
	private JLabel txtMatricula;
	private JLabel txtNome;
	private JLabel txtCargo;
	private JLabel txtSalario;
	private JLabel btnSalvar;
	private JLabel btnSair;
	
	public FrameFuncionario() {
		criarTela();
	}
	
	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro");
		tela.setSize(400, 400);
		tela.setResizable(false);
		tela.set.DefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		tela.setVisible(true);
	}
}
