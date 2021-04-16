package comandosDeparment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import conexao.FecharStatement;

public class InserirDepartment {

	private static PreparedStatement state = null;
	
	public static void inserir(Connection conexao) {
		
		try {
			
			conexao = Conexao.iniciarConexao();
			
			state = conexao.prepareStatement("insert into "
					+ "department "
					+ "(Id, Name) "
					+ "values "
					+ "(?, ?)");
			
			state.setInt(1, 6);
			state.setString(2, "Curso");
			
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
