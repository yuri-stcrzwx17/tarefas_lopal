package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.dev.yuri.tarefas.ui.GerenciadorTarefas;

public class Main {

	private static String path1 = "C:\\Users\\25132703\\ProjetoTarefasDS1TB\\funcionario.csv";
	private static String path2 = "C:\\Users\\25132703\\ProjetoTarefasDS1TB\\tarefas.csv";

	public static void main(String[] args) {
		new GerenciadorTarefas();

	}

	private static void gravarArquivo() {

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(path1, true);
			bw = new BufferedWriter(fw);

			String novaLinha = "Isso é uma nova linha!!\n";
			bw.write(novaLinha);
			bw.flush();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

	}

	private static void lerArquivo() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(path1);
			br = new BufferedReader(fr);

			String linha = br.readLine();

			while (linha != null) {
				String registro[] = linha.split(";");
				System.out.println("Nome: " + registro[0]);
				System.out.println("Tarefa " + registro[1]);
				System.out.println("---------------------");
				linha = br.readLine();
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