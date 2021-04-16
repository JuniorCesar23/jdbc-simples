package banco;

public class ExcessaoBanco extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcessaoBanco(String msg) {
		super(msg);
	}
	
}
