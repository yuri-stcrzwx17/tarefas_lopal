package Main;

// As importações devem estar fora de qualquer classe ou método
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JLabel;

import br.dev.yuri.tarefas.dao.FuncionarioDAO;
import br.dev.yuri.tarefas.model.Funcionario;
import br.dev.yuri.tarefas.ui.FrameFuncionario;
import br.dev.yuri.tarefas.ui.FrameFuncionarioList;
import br.dev.yuri.tarefas.ui.GerenciadorTarefas;
import br.dev.yuri.tarefas.ui.GerenciadorTarefas;
import br.dev.yuri.tarefas.utils.Utils;

public class Main { // Removido a classe Main duplicada

   private static String path = "C:\\Users\\25132703\\Projeto Tarefas DS1TB\\tarefas.txt";

    public static void main(String[] args) {
        new GerenciadorTarefas(); // Abre a interface do gerenciador de tarefas

        //
    }

    private static void gravarArquivo() {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(path, true); // 'true' para acrescentar no arquivo
            bw = new BufferedWriter(fw);

            String novaLinha = "Isso é uma nova linha!\n";
            String novaLinha1 = "Senai Jandira\n";
            String novaLinha2 = "Turma DS1TB\n";

            bw.write(novaLinha);
            bw.write(novaLinha1);
            bw.write(novaLinha2);
            bw.flush(); // Importante para garantir que os dados sejam escritos

        } catch (Exception erro) {
            System.out.println(erro.getMessage()); // Mostra o erro, se houver
        }
    }

    private static void lerArquivo() {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(path); // Abre o arquivo para leitura
            br = new BufferedReader(fr);

            String linha = br.readLine(); // Lê a primeira linha
            while (linha != null) {
                String registro[] = linha.split(";");
                System.out.println(" Nome:    " + registro[0]);
                System.out.println(" Tarefa:  " + registro[1]);
                linha = br.readLine(); // Lê a próxima linha
            }

        } catch (FileNotFoundException erro) {
            System.out.println(erro.getMessage());

        } catch (IOException erro) {
            System.out.println(erro.getMessage());

        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }
    }
}
