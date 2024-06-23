package Interface;

import DTO.*;

public interface TabelaInterface {
	void insertTabela(Tabela tabela);
	void inserirColuna(String nomeTabela ,Coluna coluna);
	void dropTabela(String nomeTabela);
	void dropColuna(String nomeTabela, String nomeColuna);
	void addPK(String nomeTabela, String nomeColuna);
	void dropPK(String nomeTabela);
	void removerChaveEstrangeira(String tabelaOrigem, String nomeFK);
}
