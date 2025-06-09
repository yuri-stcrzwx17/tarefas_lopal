package br.dev.yuri.tarefas.ui;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

 
public class TelaTarefas  extends JFrame {

	    public TelaTarefas() {
	        setTitle("Gerenciador de Tarefas");
	        setSize(600, 500);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        // Original tava 500, 400
	        
	        // Painel principal com borda e layout
	        JPanel mainPanel = new JPanel();
	        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	        
	        // Título da tela
	        JLabel tituloSecao = new JLabel("Cadastro de tarefas");
	        tituloSecao.setFont(new Font("Arial", Font.BOLD, 20));
	        tituloSecao.setAlignmentX(Component.CENTER_ALIGNMENT);
	        
	        // Campos do formulário
	        JPanel formPanel = new JPanel();
	        formPanel.setLayout(new GridLayout(0, 2, 10, 10));
	        
	        // Título
	        formPanel.add(new JLabel("Título"));
	        JTextField tituloField = new JTextField();
	        formPanel.add(tituloField);
	        
	        // Descrição
	        formPanel.add(new JLabel("Descrição"));
	        JTextArea descricaoArea = new JTextArea(3, 20);
	       
	        // Data Inicial
	        formPanel.add(new JLabel("Data Inicial"));
	        JTextField dataInicialField = new JTextField();
	        formPanel.add(dataInicialField);
	        
	        // Prazo
	        formPanel.add(new JLabel("Prazo"));
	        JTextField prazoField = new JTextField();
	        formPanel.add(prazoField);
	        
	        // Data Conclusão
	        formPanel.add(new JLabel("Data conclusão"));
	        JTextField dataConclusaoField = new JTextField();
	        formPanel.add(dataConclusaoField);
	        
	        // Status com ComboBox
	        formPanel.add(new JLabel("Status"));
	        String[] statusOptions = {"NÃO INICIADO", "EM ANDAMENTO", "CONCLUÍDO",};
	        JComboBox<String> statusCombo = new JComboBox<>(statusOptions);
	        formPanel.add(statusCombo);
	        
	        // Responsável
	        formPanel.add(new JLabel("Responsável"));
	        JTextField responsavelField = new JTextField("Nome do funcionário");
	        formPanel.add(responsavelField);
	        
	        // Botões
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
	        
	        JButton salvarButton = new JButton("Salvar");
	        JButton sairButton = new JButton("Sair");
	        
	        buttonPanel.add(salvarButton);
	        buttonPanel.add(sairButton);
	        
	        // Fazendo o Botão sair funcionar =)
	        sairButton.addActionListener(new ActionListener() {
	            
	        	@Override
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);
	            }
	        });
	        
	        // Adicionando tudo ao painel principal
	        mainPanel.add(tituloSecao);
	        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
	        mainPanel.add(formPanel);
	        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
	        mainPanel.add(buttonPanel);
	        
	        add(mainPanel);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new TelaTarefas().setVisible(true);
	            }
	        });
	    }
	}

