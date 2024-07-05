package Main;

import DTO.*;
import Metodos.*;

public class CriaBanco {
    public static void main(String[] args) {
        BancoMetodos bancoMetodos = new BancoMetodos(); 
        TabelaMetodos metodosTabela = new TabelaMetodos();
        
        bancoMetodos.dropBanco("fml");
        bancoMetodos.criarBanco("fml", Charsets.UTF8, Collations.UTF8_GENERAL_CI);

        Tabela pai = new Tabela("pai");
        Tabela mae = new Tabela("mae");
        Tabela filho = new Tabela("filho");

        Coluna Nome = new Coluna("nome", Tipo.VARCHAR, 100, false, true, false, false, false, false);
        Coluna Idade = new Coluna("idade", Tipo.INT, 11, false, true, false, false, false, false);

        pai.add(new Coluna("id", Tipo.INT, 11, true, true, false, false, true, false));
        pai.add(Nome);
        pai.add(Idade);
        
        mae.add(new Coluna("id", Tipo.INT, 11, true, true, false, false, true, false));
        mae.add(Nome);

        filho.add(new Coluna("id", Tipo.INT, 11, true, true, false, false, true, false));
        filho.add(new Coluna("idPai", Tipo.INT, 11, false, true, false, false, false, false));
        filho.add(Nome);
        filho.add(Idade);

        metodosTabela.insertTabela(pai);
        metodosTabela.insertTabela(mae);
        metodosTabela.insertTabela(filho);

        Relacionamento relacionamentoPai = new Relacionamento("idPai", "pai", "id", "CASCADE", "CASCADE");
        metodosTabela.adicionarRelacionamento("filho", relacionamentoPai);
                
        Tabela associa = new Tabela("Associa");
        associa.add(new Coluna("idPai", Tipo.INT, 11, false, true, false, false, false, false));
        associa.add(new Coluna("idMae", Tipo.INT, 11, false, true, false, false, false, false));
        associa.add(new Coluna("idAssocia", Tipo.INT, 11, true, true, false, false, true, false));
        metodosTabela.insertTabela(associa);
        metodosTabela.adicionarRelacionamento("Associa", new Relacionamento("idPai", "pai", "id", "CASCADE", "CASCADE"));
        metodosTabela.adicionarRelacionamento("Associa", new Relacionamento("idMae", "mae", "id", "CASCADE", "CASCADE"));

    }
}
