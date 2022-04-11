package atividadeInterface2;

import interfaces.BancoDados;

public class Main {

	public static void main(String[] args) {
		
		BancoDados bancoTeste = new BancoMySQL("bancoTeste"); 

		String usuario = "teste";
		String dado = "nome";
		String nomeTabela = "tabelaTeste";
		String consultaSQL = "SELECT * FROM teste";

		bancoTeste.abrirConexao();
		bancoTeste.grant(usuario);
		bancoTeste.revoke(usuario);
		bancoTeste.create(nomeTabela);
		bancoTeste.insert(dado);
		bancoTeste.alter(dado);
		bancoTeste.update(dado);
		bancoTeste.delete(dado);
		
		String resultado = bancoTeste.select(consultaSQL);
		System.out.println(resultado);
		
		bancoTeste.drop(nomeTabela);	
		bancoTeste.fecharConexao();

	}
}
