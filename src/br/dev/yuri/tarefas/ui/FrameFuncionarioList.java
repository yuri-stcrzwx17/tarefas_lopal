package br.dev.yuri.tarefas.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

import br.dev.yuri.tarefas.dao.FuncionarioDAO;

public class FrameFuncionarioList extends JFrame {

    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public FrameFuncionarioList() {
        setTitle("Lista de Funcionários");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Funcionários Cadastrados", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        String[] colunas = {"Matrícula", "Nome", "Cargo", "Salário"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnAdicionar = new JButton("Adicionar Funcionário");
        btnAdicionar.addActionListener((ActionEvent e) -> {
            new FrameFuncionario(this); // Passa referência da tela atual
        });

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnAdicionar);
        add(painelBotoes, BorderLayout.SOUTH);

        carregarFuncionarios();

        setVisible(true);
    }

    public void carregarFuncionarios() {
        modeloTabela.setRowCount(0);
        for (var f : new FuncionarioDAO().listar()) {
            modeloTabela.addRow(new Object[]{
                f.getMatricula(), f.getNome(), f.getCargo(), f.getSalario()
            });
        }
    }
}