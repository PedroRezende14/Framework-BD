package Interface;

import DTO.*;

public interface BancoInterface {
	 void criarBanco(String nome, Charsets charset, Collations collation);
	 void listarCharsets();
	 void listarCollations();
	 void dropBanco(String nome);
}
