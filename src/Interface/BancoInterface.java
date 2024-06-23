package Interface;

import DTO.*;

public interface BancoInterface {
	 void criarBanco(String nome, Charsets charset, Collations collation);
	 String listarCharsets();
	 String listarCollations(String charset);
	 void dropBanco(String nome);
}
