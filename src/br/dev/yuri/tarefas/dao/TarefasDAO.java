package br.dev.yuri.tarefas.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.yuri.tarefas.factory.FileFactory;
import br.dev.yuri.tarefas.model.Funcionario; 
import br.dev.yuri.tarefas.model.Tarefas;

public class TarefasDAO {

	private Tarefas tarefas;

	public TarefasDAO() {
	}

	public TarefasDAO(Tarefas tarefas) {
		this.tarefas = tarefas;
	}
	
	public void gravar() {
		
		try (java.io.BufferedWriter bw = new FileFactory().getBufferedWriter()) {
			bw.write(tarefas.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public List<Tarefas> listar() {
		List<Tarefas> listaDeTarefas = new ArrayList<>(); 
		
		try (BufferedReader br = new FileFactory().getBufferedReader()) {
			String linha;
			
		

			while ((linha = br.readLine()) != null) { // Lê a linha e verifica se não é nula

                System.out.println("Lendo linha: " + linha); // Para debug, mostra a linha lida

			}
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return listaDeTarefas; // Retorna a lista de tarefas
	}
}
