package app;

import java.sql.Connection;

import comandosDeparment.AtualizarDepartment;
import conexao.Conexao;

public class App {

	public static void main(String[] args) {
		
		Connection conexao = Conexao.iniciarConexao();
		
			AtualizarDepartment.atualizar(conexao);
		
		Conexao.fecharConexao();

	}

}
