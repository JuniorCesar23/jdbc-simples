package app;

import java.sql.Connection;

import comandosDeparment.ImprimirDepartment;
import conexao.Conexao;

public class App {

	public static void main(String[] args) {
		
		Connection conexao = Conexao.iniciarConexao();
		
			ImprimirDepartment.imprimir(conexao);
		
		Conexao.fecharConexao();

	}

}
