package banco;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
	
	// INICIAR CONEXÃO
	private static Connection conexao = null;
	
	public static Connection iniciarConexao() {
		if (conexao == null) {
			try {
				Properties props = coletarDados();
				String url = props.getProperty("dburl");
				conexao = DriverManager.getConnection(url, props);
				System.out.println("Conexão iniciada!");
			} catch (SQLException e) {
				throw new ExcessaoBanco(e.getMessage());
			}
		}
		return conexao;
	}

	// COLETAR OS DADOS
	public static Properties coletarDados() {
		try (FileInputStream arquivo = new FileInputStream("banco.properties")){
			Properties props = new Properties();
			props.load(arquivo);
			return props;
		} catch (IOException e) {
			throw new ExcessaoBanco(e.getMessage());
		}
	}
	
	// FECHAR CONEXÃO
	public static void fecharConexao() {
		if (conexao != null) {
			try {
				conexao.close();
				System.out.println("Conexão fechada!");
			} catch (SQLException e) {
				throw new ExcessaoBanco(e.getMessage());
			}
		}
	}
	
}
