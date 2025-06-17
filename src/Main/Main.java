package Main;

import br.dev.yuri.tarefas.ui.GerenciadorTarefas;
import java.io.*;

public class Main {

    private static final String path = "C:\\Users\\25132733\\tarefas.txt";

    public static void main(String[] args) {
        // Inicia o menu principal com opções: Funcionário e Tarefas
        new GerenciadorTarefas().setVisible(true);
    }

    // Grava informações de exemplo no arquivo de tarefas
    private static void gravarArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write("Isso é uma nova linha!\n");
            bw.write("Senai Jandira\n");
            bw.write("Turma DS1TB\n");
        } catch (IOException erro) {
            System.out.println("Erro ao gravar arquivo: " + erro.getMessage());
        }
    }

    // Lê e imprime os registros do arquivo de tarefas
    private static void lerArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] registro = linha.split(";");
                System.out.println(" Nome:    " + registro[0]);
                System.out.println(" Tarefa:  " + registro[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro geral: " + e.getMessage());
        }
    }
}
