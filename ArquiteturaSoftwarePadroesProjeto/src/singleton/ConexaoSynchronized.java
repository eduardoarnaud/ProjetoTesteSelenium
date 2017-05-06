package singleton;

public class ConexaoSynchronized {

	private static ConexaoSynchronized conexao = new ConexaoSynchronized();
	private static String host;
	
	private ConexaoSynchronized() {
		host = "192.179.33.22";
	}
	
	// synchronized - SÓ PODE SER FEITA UMA CHAMADA POR VEZ
	public static synchronized ConexaoSynchronized getConexao(){
		if(conexao == null){
			conexao = new ConexaoSynchronized();
		}
		return conexao;
	}
	
	public static String getHost(){
		return host;
	}
}
