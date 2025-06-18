package br.dev.yuri.tarefas.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GerenciadorTarefas extends JFrame {

	public GerenciadorTarefas() {
		setTitle("Gerenciador Central");
		setSize(400, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Título
		JLabel titulo = new JLabel("Escolha uma opção", SwingConstants.CENTER);
		titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
		add(titulo, BorderLayout.NORTH);

		// Painel com botões
		JPanel botoesPanel = new JPanel(new GridLayout(2, 1, 15, 15));
		botoesPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

		JButton btnFuncionario = new JButton("Funcionários");
		JButton btnTarefa = new JButton("Tarefas");

		botoesPanel.add(btnFuncionario);
		botoesPanel.add(btnTarefa);
		add(botoesPanel, BorderLayout.CENTER);

		// Ações dos botões
		btnFuncionario.addActionListener((ActionEvent e) -> {
			FrameFuncionarioList frameFuncionario = new FrameFuncionarioList();
			frameFuncionario.setVisible(true);
		});

		btnTarefa.addActionListener((ActionEvent e) -> {
			FrameTarefasList frameTarefa = new FrameTarefasList();
			frameTarefa.setVisible(true);
		});

		// Exibe o frame principal
		setVisible(true);
	}
}
