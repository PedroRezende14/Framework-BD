package Main;

import DTO.*;
import Metodos.*;

public class CriaBanco {
    public static void main(String[] args) {

//        Conexao.setNameBanco("Teste");
//        Conexao.setHost("localhost");
//        Conexao.setPorta(3306);
//        Conexao.setUser("root");
//        Conexao.setPassword("");

        TabelaMetodos metodosTabela = new TabelaMetodos();
        BancoMetodos bancoMetodos = new BancoMetodos();

        bancoMetodos.criarBanco("escola", Charsets.UTF8, Collations.UTF8_GENERAL_CI);

      
        Tabela pai = new Tabela("pai");
        Tabela filho = new Tabela("filho");

        Coluna Nome = new Coluna("nome", Tipo.VARCHAR, 100, false, true, false, false, false, false);
        Coluna Idade = new Coluna("idade", Tipo.INT, 11, false, true, false, false, false, false);

        pai.add(new Coluna("id", Tipo.INT, 11, true, true, false, false, true, false));
        pai.add(Nome);
        pai.add(Idade);

        filho.add(new Coluna("idFilho", Tipo.INT, 11, true, true, false, false, true, false));
        filho.add(Nome);
        filho.add(Idade);

        metodosTabela.insertTabela(filho);
        metodosTabela.insertTabela(pai);

        Relacionamento relacionamento = new Relacionamento("idFilho", "pai", "id", "CASCADE", "CASCADE");
        metodosTabela.adicionarRelacionamento("filho", relacionamento);

//   	Outras operaçoes possiveis
        
//      metodosTabela.inserirColuna("pai", new Coluna("sobrenome", Tipo.VARCHAR, 50, false, true, false, false, false, false));
//      metodosTabela.dropTabela("pai");
//      metodosTabela.addPK("NomeTabela", "NomeColuna");
//      metodosTabela.dropPK("nomeTabela");
//      metodosTabela.removerChaveEstrangeira("NomeTabela", "NomeDaChave");
//      metodosTabela.dropColuna("NomeTabela", "NomeColuna");
    }
}
