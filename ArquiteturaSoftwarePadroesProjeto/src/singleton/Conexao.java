package singleton;

public class Conexao {

	private static Conexao conexao = new Conexao();
	private static String host;
	
	private Conexao() {
		host = "192.179.33.22";
	}
	
	public static Conexao getConexao(){
		if(conexao == null){
			conexao = new Conexao();
		}
		return conexao;
	}
	
	public static String getHost(){
		return host;
	}
}
