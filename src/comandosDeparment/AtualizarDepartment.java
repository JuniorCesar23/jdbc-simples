package comandosDeparment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import conexao.FecharStatement;

public class AtualizarDepartment {
	
	private static PreparedStatement state = null;
	
	public static void atualizar(Connection conexao) {
		
		try {
			
			conexao = Conexao.iniciarConexao();
			
			state = conexao.prepareStatement("update department "
					+ "set Name = ? "
					+ "where Id = ? ");
			
			state.setString(1, "School");
			state.setInt(2, 6);
			
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
