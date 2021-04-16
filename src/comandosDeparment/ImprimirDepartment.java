package comandosDeparment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexao.Conexao;
import conexao.FecharResultSet;
import conexao.FecharStatement;

public class ImprimirDepartment {

	private static Statement state = null;
	private static ResultSet rs = null;
	
	public static void imprimir(Connection conexao) {
		try {
			conexao = Conexao.iniciarConexao();
			state = conexao.createStatement();
			rs = state.executeQuery("select * from department ");
			
			while (rs.next()) {
				System.out.println("Id: " + rs.getInt("Id"));
				System.out.println("Nome: " + rs.getString("Name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			FecharStatement.fechar(state);
			FecharResultSet.fechar(rs);
		}
	}
	
}
