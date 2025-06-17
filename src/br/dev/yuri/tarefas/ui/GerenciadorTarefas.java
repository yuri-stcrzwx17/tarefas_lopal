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

        JLabel titulo = new JLabel("Escolha uma opção", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        JPanel botoesPanel = new JPanel(new GridLayout(2, 1, 15, 15));
        botoesPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JButton btnFuncionario = new JButton("Cadastro de Funcionário");
        JButton btnTarefa = new JButton("Cadastro de Tarefa");

        botoesPanel.add(btnFuncionario);
        botoesPanel.add(btnTarefa);

        add(botoesPanel, BorderLayout.CENTER);

        btnFuncionario.addActionListener((ActionEvent e) -> {
            new FrameFuncionarioList(); 
        });

        btnTarefa.addActionListener((ActionEvent e) -> {
            TelaTarefas tela = new TelaTarefas();
            tela.setVisible(true);
        });

        setVisible(true);
    }
}