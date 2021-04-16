package comandosDeparment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import conexao.FecharStatement;

public class DeletarDepartment {

	private static PreparedStatement state = null;
	
	public static void deletar(Connection conexao) {
		
		try {
			
			conexao = Conexao.iniciarConexao();
			
			state = conexao.prepareStatement("delete from "
					+ "department "
					+ "where "
					+ "Id = ? ");
			
			state.setInt(1, 6);
			
			int linhasAfetadas = state.executeUpdate();
			
			System.out.println("Linhas afetadas: " + linhasAfetadas);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			FecharStatement.fechar(state);
		}
		
	}
	
}
