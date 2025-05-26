package br.dev.yuri.tarefas.factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {
	
	private String arquivo = "C:\\Users\\25132703\\Projeto Tarefas DS1TD\\funcionario.csv";
	
	private FileWriter fw;
	private BufferedWriter bw;
	
	public FileFactory() throws IOException {
		fw = new FileWriter(arquivo, true);
		bw = new BufferedWriter(fw);
	}
	
	public BufferedWriter getBufferedWriter() {
		return bw;
	}

}
