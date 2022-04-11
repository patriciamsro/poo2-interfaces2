package atividadeInterface2;

import interfaces.BancoDados;

public class BancoMySQL implements BancoDados {
	
	String nomeBanco;
	boolean conexaoAberta = false;
	
	public BancoMySQL(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	

	@Override
	public void abrirConexao() {
		if(!conexaoAberta) {
			System.out.println("Conexão com o banco " + nomeBanco + " aberta.");
			conexaoAberta = true;
		} else
			throw new RuntimeException("A conexão com o banco de dados " + nomeBanco+ " já está aberta.");
	}
	
	@Override
	public void fecharConexao() {		
		if(conexaoAberta) {
			System.out.println("Conexão com o banco " + nomeBanco + " fechada.");
			conexaoAberta = false;
		} else 
			throw new RuntimeException("Não há conexão com o banco de dados " + nomeBanco+ ".");		
	}
	
	@Override
	public void grant(String usuario) {
		if(validaConexao())
			System.out.println("Privilégios de acesso de usuário " + usuario + " atribuídos.");
	}
	
	@Override
	public void revoke(String usuario) {
		if(validaConexao())
			System.out.println("Privilégios de acesso de usuário " + usuario + " retirados.");
	}	
	
	@Override
	public void create(String nomeTabela) {
		if(validaConexao())
			System.out.println("Tabela " + nomeTabela +" criada.");
	}
	
	@Override
	public void drop(String nomeTabela) {
		if(validaConexao())
			System.out.println("Tabela " + nomeTabela + " excluída.");
	}
	
	@Override
	public void alter(String dado) {
		if(validaConexao())
			System.out.println("Tabela modificada.");
	}
	
	@Override
	public void insert(String dado) {
		if(validaConexao())
			System.out.println("Dados inseridos na tabela.");
	}
	
	@Override
	public void update(String dado) {
		if(validaConexao())
			System.out.println("Dados atualizados na tabela.");
	}
	
	@Override
	public void delete(String dado) {
		if(validaConexao())
			System.out.println("Dados excluídos da tabela.");
	}
	
	@Override
	public String select(String consultaSQL) {
		if(validaConexao())
			return "Consulta " + consultaSQL + " efetuada na tabela.";
		return null;
	}
	
	
	private boolean validaConexao() {
		if(!conexaoAberta) throw new RuntimeException("Não há conexão com o banco de dados " + nomeBanco+ ".");
		return conexaoAberta;
	}
}
