package br.dev.yuri.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import br.dev.yuri.tarefas.dao.FuncionarioDAO;
import br.dev.yuri.tarefas.model.Funcionario;

public class FrameFuncionario {

    private JLabel labelMatricula;
    private JLabel labelNome;
    private JLabel labelCargo;
    private JLabel labelSalario;
    private JTextField txtMatricula;
    private JTextField txtNome;
    private JTextField txtCargo;
    private JTextField txtSalario;
    private JButton btnSalvar;
    private JButton btnSair;

    private FrameFuncionarioList listaFrame;

    public FrameFuncionario(JFrame frame) {
        if (frame instanceof FrameFuncionarioList) {
            this.listaFrame = (FrameFuncionarioList) frame;
        }
        criarTela(frame);
    }

    private void criarTela(JFrame frame) {
        JDialog tela = new JDialog(frame, true);
        tela.setTitle("Cadastro de Funcionário");
        tela.setSize(400, 400);
        tela.setResizable(false);
        tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        tela.setLayout(null);
        tela.setLocationRelativeTo(frame);

        Container painel = tela.getContentPane();

        labelMatricula = new JLabel("Matrícula");
        labelMatricula.setBounds(10, 10, 200, 30);
        txtMatricula = new JTextField();
        txtMatricula.setBounds(10, 40, 150, 30);
        txtMatricula.setEnabled(false);

        labelNome = new JLabel("Nome:");
        labelNome.setBounds(10, 75, 200, 30);
        txtNome = new JTextField();
        txtNome.setBounds(10, 105, 365, 30);

        labelCargo = new JLabel("Cargo");
        labelCargo.setBounds(10, 140, 200, 30);
        txtCargo = new JTextField();
        txtCargo.setBounds(10, 170, 300, 30);

        labelSalario = new JLabel("Salário:");
        labelSalario.setBounds(10, 205, 150, 30);
        txtSalario = new JTextField();
        txtSalario.setBounds(10, 235, 150, 30);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 300, 120, 50);
        btnSair = new JButton("Sair");
        btnSair.setBounds(140, 300, 80, 50);

        painel.add(labelMatricula);
        painel.add(txtMatricula);
        painel.add(labelNome);
        painel.add(txtNome);
        painel.add(labelCargo);
        painel.add(txtCargo);
        painel.add(labelSalario);
        painel.add(txtSalario);
        painel.add(btnSalvar);
        painel.add(btnSair);

        btnSair.addActionListener(e -> tela.dispose());

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario f = new Funcionario(
                    txtCargo.getText(),
                    txtNome.getText(),
                    Double.parseDouble(txtSalario.getText())
                );

                FuncionarioDAO dao = new FuncionarioDAO(f);
                dao.gravar();
                JOptionPane.showMessageDialog(tela, txtNome.getText() + " gravado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                tela.dispose();

                if (listaFrame != null) {
                    listaFrame.dispose();
                    new FrameFuncionarioList(); // Atualiza a lista
                }
            }
        });

        tela.setVisible(true);
    }
}