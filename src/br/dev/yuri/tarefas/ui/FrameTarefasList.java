package br.dev.yuri.tarefas.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class FrameTarefasList extends JFrame {

	private JTable tabela;
	private DefaultTableModel modeloTabela;
	private JButton btnAdicionar;
	private JButton btnEditar;
	private JButton btnExcluir;

	public FrameTarefasList() {
		setTitle("Lista de Tarefas");
		setSize(700, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Definir colunas da tabela
		String[] colunas = { "Responsável", "Data Inicial", "Prazo Final", "Status" };

		modeloTabela = new DefaultTableModel(colunas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // deixa a tabela só para leitura
			}
		};

		tabela = new JTable(modeloTabela);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Impedir mover e redimensionar colunas
		tabela.getTableHeader().setReorderingAllowed(false);
		tabela.getTableHeader().setResizingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(tabela);
		add(scrollPane, BorderLayout.CENTER);

		// Painel inferior com botões
		JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnAdicionar = new JButton("Adicionar Tarefa");
		btnEditar = new JButton("Editar");
		btnExcluir = new JButton("Excluir");

		painelBotoes.add(btnAdicionar);
		painelBotoes.add(btnEditar);
		painelBotoes.add(btnExcluir);

		add(painelBotoes, BorderLayout.SOUTH);

		// Eventos dos botões
		btnAdicionar.addActionListener(e -> abrirCadastroTarefa());

		btnEditar.addActionListener(e -> {
			int linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada == -1) {
				JOptionPane.showMessageDialog(this, "Selecione uma tarefa para editar.", "Aviso",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			editarTarefa(linhaSelecionada);
		});

		btnExcluir.addActionListener(e -> {
			int linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada == -1) {
				JOptionPane.showMessageDialog(this, "Selecione uma tarefa para excluir.", "Aviso",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir a tarefa selecionada?",
					"Confirmação", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				modeloTabela.removeRow(linhaSelecionada);
				// Aqui você deve implementar também a exclusão real no banco ou arquivo
			}
		});

		// Carregar tarefas
		carregarTarefas();
	}

	public void carregarTarefas() {
		// TODO: implementar a leitura real das tarefas do banco ou arquivo e popular a
		// tabela
		// Exemplo: modeloTabela.addRow(new Object[]{responsavel, dataInicial,
		// prazoFinal, status});
	}

	private void abrirCadastroTarefa() {
		TelaTarefas telaCadastro = new TelaTarefas(null);
		telaCadastro.setVisible(true);

		// Após fechar a tela, você pode atualizar a tabela com os dados novos
		// carregarTarefas();
	}

	private void editarTarefa(int linha) {
		JOptionPane.showMessageDialog(this, "Funcionalidade de edição ainda não implementada. Foi mal.", "Info",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new FrameTarefasList().setVisible(true));
	}
}
