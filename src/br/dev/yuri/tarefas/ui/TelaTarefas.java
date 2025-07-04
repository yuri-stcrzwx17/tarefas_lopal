package br.dev.yuri.tarefas.ui;

import br.dev.yuri.tarefas.model.Funcionario;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class TelaTarefas extends JFrame {

	public TelaTarefas(FrameTarefasList frameTarefasList) {
		setTitle("Cadastro de Tarefas");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel painelPrincipal = new JPanel(new GridBagLayout());
		painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 8, 8, 8);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JLabel lblTituloGeral = new JLabel("Formulário de Tarefas");
		lblTituloGeral.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblTituloGeral.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTituloGeral, BorderLayout.NORTH);

		int linha = 0;

		// Título
		gbc.gridx = 0;
		gbc.gridy = linha;
		painelPrincipal.add(new JLabel("Título da Tarefa:"), gbc);
		gbc.gridx = 1;
		JTextField txtTitulo = new JTextField(25);
		painelPrincipal.add(txtTitulo, gbc);

		// Descrição
		linha++;
		gbc.gridx = 0;
		gbc.gridy = linha;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		painelPrincipal.add(new JLabel("Descrição:"), gbc);
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 0.3;
		JTextArea txtDescricao = new JTextArea(4, 25);
		txtDescricao.setLineWrap(true);
		txtDescricao.setWrapStyleWord(true);
		JScrollPane scrollDescricao = new JScrollPane(txtDescricao);
		painelPrincipal.add(scrollDescricao, gbc);

		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;

		// Data Inicial
		linha++;
		gbc.gridx = 0;
		gbc.gridy = linha;
		painelPrincipal.add(new JLabel("Data Inicial:"), gbc);
		gbc.gridx = 1;
		JPanel dataInicialPanel = criarPainelData();
		painelPrincipal.add(dataInicialPanel, gbc);

		// Prazo Final
		linha++;
		gbc.gridx = 0;
		gbc.gridy = linha;
		painelPrincipal.add(new JLabel("Prazo Final:"), gbc);
		gbc.gridx = 1;
		JPanel prazoFinalPanel = criarPainelData();
		painelPrincipal.add(prazoFinalPanel, gbc);

		// Data Conclusão
		linha++;
		gbc.gridx = 0;
		gbc.gridy = linha;
		painelPrincipal.add(new JLabel("Data Conclusão:"), gbc);
		gbc.gridx = 1;
		JPanel dataConclusaoPanel = criarPainelData();
		painelPrincipal.add(dataConclusaoPanel, gbc);

		// Status
		linha++;
		gbc.gridx = 0;
		gbc.gridy = linha;
		painelPrincipal.add(new JLabel("Status:"), gbc);
		gbc.gridx = 1;
		JComboBox<String> comboStatus = new JComboBox<>(new String[] { "NÃO INICIADO", "EM ANDAMENTO", "CONCLUÍDO" });
		painelPrincipal.add(comboStatus, gbc);

		// Responsável
		linha++;
		gbc.gridx = 0;
		gbc.gridy = linha;
		painelPrincipal.add(new JLabel("Responsável:"), gbc);
		gbc.gridx = 1;

		JComboBox<Funcionario> comboResponsavel = new JComboBox<>();
		painelPrincipal.add(comboResponsavel, gbc);

		// Botões
		linha++;
		gbc.gridx = 0;
		gbc.gridy = linha;
		gbc.gridwidth = 2;
		JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JButton btnSalvar = new JButton("Salvar");
		JButton btnSair = new JButton("Sair");
		painelBotoes.add(btnSalvar);
		painelBotoes.add(btnSair);
		painelPrincipal.add(painelBotoes, gbc);

		btnSair.addActionListener(e -> dispose());

		btnSalvar.addActionListener((ActionEvent e) -> {
			if (txtTitulo.getText().trim().isEmpty() || comboResponsavel.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(this, "Preencha os campos obrigatórios!", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			String resumo = "Tarefa salva:\n" + "Título: " + txtTitulo.getText() + "\n" + "Descrição: "
					+ txtDescricao.getText() + "\n" + "Responsável: " + comboResponsavel.getSelectedItem();

			JOptionPane.showMessageDialog(this, resumo, "Sucesso", JOptionPane.INFORMATION_MESSAGE);

			txtTitulo.setText("");
			txtDescricao.setText("");
			limparPainelData(dataInicialPanel);
			limparPainelData(prazoFinalPanel);
			limparPainelData(dataConclusaoPanel);
			comboResponsavel.setSelectedIndex(-1);
			comboStatus.setSelectedIndex(0);
		});

		add(painelPrincipal, BorderLayout.CENTER);
	}

	public TelaTarefas(String responsavel, String dataInicial, String prazo, String status) {
		// Construtor alternativo não implementado
	}

	private JPanel criarPainelData() {
		JPanel painelData = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
		JFormattedTextField txtDia = criarCampoData("##");
		JFormattedTextField txtMes = criarCampoData("##");
		JFormattedTextField txtAno = criarCampoData("####");

		painelData.add(txtDia);
		painelData.add(new JLabel("/"));
		painelData.add(txtMes);
		painelData.add(new JLabel("/"));
		painelData.add(txtAno);

		return painelData;
	}

	private JFormattedTextField criarCampoData(String mask) {
		try {
			MaskFormatter formatter = new MaskFormatter(mask);
			formatter.setPlaceholderCharacter('_');
			return new JFormattedTextField(formatter);
		} catch (ParseException e) {
			e.printStackTrace();
			return new JFormattedTextField();
		}
	}

	private void limparPainelData(JPanel painelData) {
		for (Component c : painelData.getComponents()) {
			if (c instanceof JFormattedTextField) {
				((JFormattedTextField) c).setValue(null);
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new TelaTarefas(null).setVisible(true));
	}
}
