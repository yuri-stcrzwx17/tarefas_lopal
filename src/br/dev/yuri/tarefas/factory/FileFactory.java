package br.dev.yuri.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {

    private String arquivo = "C:\\Users\\25132703\\ProjetoTarefasDS1TB\\funcionarios.csv";
    
    private FileWriter fw;
    private BufferedWriter bw;
    
    private FileReader fr;
    private BufferedReader br;
    
    
    public FileFactory() throws IOException {
    	
    	
    	fw = new FileWriter(arquivo, true);
    	bw = new BufferedWriter(fw);
    	
    	
    	fr = new FileReader(arquivo);
    	br = new BufferedReader(fr);
    }
	
    public BufferedWriter getBufferedWriter() {
    	return bw;
    }
    
    public BufferedReader getBufferedReader() {
		return br;
	}
}