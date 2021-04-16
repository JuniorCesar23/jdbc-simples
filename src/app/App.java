package app;

import java.sql.Connection;

import comandosDeparment.inserirDepartment;
import conexao.Conexao;

public class App {

	public static void main(String[] args) {
		
		Connection conexao = Conexao.iniciarConexao();
		
			inserirDepartment.inserir(conexao);
		
		Conexao.fecharConexao();

	}

}
