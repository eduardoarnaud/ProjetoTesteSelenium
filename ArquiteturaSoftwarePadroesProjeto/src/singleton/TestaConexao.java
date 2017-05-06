package singleton;

public class TestaConexao {
	
	public static void main(String[] args) {
		Conexao con = null;
		
		long tempoInicio = System.currentTimeMillis();
		System.out.println(tempoInicio);
		
		for (int i = 0; i < 10000000; i++) {
			con = Conexao.getConexao();
		}
		
		long tempoFim = System.currentTimeMillis();
		System.out.println(tempoFim);
		
		System.out.println(tempoFim - tempoInicio);
	}
}
