package app;

import java.sql.Connection;

import comandosDeparment.DeletarDepartment;
import conexao.Conexao;


public class App {

	public static void main(String[] args) {
		
		Connection conexao = Conexao.iniciarConexao();
		
			DeletarDepartment.deletar(conexao);
		
		Conexao.fecharConexao();

	}

}
