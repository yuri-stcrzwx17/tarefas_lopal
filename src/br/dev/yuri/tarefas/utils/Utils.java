package br.dev.yuri.tarefas.utils;

import java.util.UUID;

public class Utils {

	public static char[] gerarUUID8;

	public String gerarUUID() {
		UUID uuid = UUID.randomUUID();
		String uuidStr = uuid.toString();
		String uuid8 = uuidStr.substring(0, 8);
		return uuid8;
	}

	public static String gerarUUID8() {
		// TODO Auto-generated method stub
		return null;
	}
}
