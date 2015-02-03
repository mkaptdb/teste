package br.com.dotbuild;

public class TesteStringBuffer {

	public static void main(String[] args) {
		
		String a = "Michel ";
		String b = "Kahan ";
		String c = "Apt ";
				
		StringBuilder sb = new StringBuilder();
		sb.append(a).append(b).append(c);
		
		String teste = sb.toString();
		
		System.out.println(sb.length());
		System.out.println(teste.length());

	}
}
