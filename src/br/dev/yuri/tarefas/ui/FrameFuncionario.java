package br.dev.yuri.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrameFuncionario {

	private JLabel labelMatricula;
	private JLabel labelNome;
	private JLabel labelCargo;
	private JLabel labelSalario;
	private JTextField txtMatricula;
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
		
		labelMatricula = new JLabel("Matricula: ");
		labelMatricula.setBounds(10, 10, 200,30);
		txtMatricula = new JTextField();	
		txtMatricula.setBounds(10,40,150,30);
		txtMatricula.setEnabled(false);
		
		labelNome = new JLabel("Nome: ");
		labelNome.setBounds(10, 75, 200, 30);
		txtNome = new JTextField();
		txtNome.setBounds(10, 105, 365, 30);
		
		labelCargo = new JLabel("Cargo: ");
		labelCargo.setBounds(10, 140, 200, 30);
		txtCargo = new JTextField();
		txtCargo.setBounds(10, 170, 200, 30);
		
		labelSalario = new JLabel("Salario: ");
		labelSalario.setBounds(10, 205, 150, 30);
		txtsalario = new JTextField();
		txtsalario.setBounds(10, 235, 150, 30);
		
		btnSalvar = new JLabel("Salvar");
		btnSalvar.setBounds(10, 300, 150, 30);
		btnSair = new JLabel("Sair");
		btnSair.setBounds(10, 320, 150, 30);
		
		painel.add(labelMatricula);
		painel.add(txtMatricula);
		painel.add(labelNome);
		painel.add(txtNome);
		painel.add(labelCargo);
		painel.add(txtCargo);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		
		
		
		
		
		btnSalvar.addAncestorListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Funcionario f = new Funcionario(txtCargo.getText(),
						txtNome.getText(),
						Double.parseDouble(txtSalario.getText()));
				
					
				
			}
			
			btnSair.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
				int resposta = JOptionPane.showConfirmDialog(tela, "Voce confirma a saida do Sistema?");
				if(resposta == 0) {System.exit(JFrame.EXIT_ON_CLOSE);
				}
				
					
				
				}
				
			}
		) {
			
		}
		
		tela.setVisible(true);
	}
	
	private void limparFormulario() {
		txtNome.setText(null);
		txtCargo.setText(null);
		txtSalario.setText(null);
		txtNome.requestFocus();
		
	}
}
