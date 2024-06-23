package Interface;

public interface BancoInterface {
	 void criarBanco(String nome, String charset, String collation);
	 void listarCharsets();
	 void listarCollations(String charset);
}
