package br.dev.yuri.tarefas.model;

import br.dev.yuri.tarefas.dao.TarefasDAO;
import br.dev.yuri.tarefas.ui.FrameTarefasList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Tarefas extends JFrame {

	private final JTextField txtResponsavel;
	private final JTextField txtDataInicial;
	private final JTextField txtPrazo;
	private final JTextField txtStatus;

	private final FrameTarefasList telaLista; // Referência à lista de tarefas

	public Tarefas(FrameTarefasList telaLista) {
		this.telaLista = telaLista;

		setTitle("Cadastro de Tarefas");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(5, 2, 10, 10));

		add(new JLabel("Responsável:"));
		txtResponsavel = new JTextField();
		add(txtResponsavel);

		add(new JLabel("Data Inicial (dd/mm/yyyy):"));
		txtDataInicial = new JTextField();
		add(txtDataInicial);

		add(new JLabel("Prazo Final (dd/mm/yyyy):"));
		txtPrazo = new JTextField();
		add(txtPrazo);

		add(new JLabel("Status:"));
		txtStatus = new JTextField();
		add(txtStatus);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this::salvarTarefa);
		add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e -> dispose());
		add(btnCancelar);

		setVisible(true);
	}

	public Tarefas(String responsavel, String dataInicial, String prazo, String status) {
		this.txtResponsavel = new JTextField();
		this.txtDataInicial = new JTextField();
		this.txtPrazo = new JTextField();
		this.txtStatus = new JTextField();
		this.telaLista = new FrameTarefasList();
		// TODO Auto-generated constructor stub
	}

	private void salvarTarefa(ActionEvent e) {
		String responsavel = txtResponsavel.getText();
		String dataInicial = txtDataInicial.getText();
		String prazo = txtPrazo.getText();
		String status = txtStatus.getText();

		if (responsavel.isEmpty() || dataInicial.isEmpty() || prazo.isEmpty() || status.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		Tarefas nova = new Tarefas(responsavel, dataInicial, prazo, status);
		new TarefasDAO(nova).gravar();

		JOptionPane.showMessageDialog(this, "Tarefa salva com sucesso!");
		telaLista.carregarTarefas(); // Atualiza a tabela na outra tela
		dispose(); // Fecha esta tela
	}
}
