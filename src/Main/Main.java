package Main;

import Conexao.*;
import DTO.*;
import Metodos.*;

public class Main {

    public static void main(String[] args) {
    	TabelaMetodos metodosTabela = new TabelaMetodos();
        BancoMetodos cb = new BancoMetodos();
        
//        cb.listarCharsets();
//        cb.listarCollations("utf8");
//        
//        cb.criarBanco("Teste", Charsets.UTF8, Collations.UTF8_GENERAL_CI);
        
//        cb.dropBanco("abc123");

        Conexao.setNameBanco("Teste");
        
//        Tabela Pai = new Tabela("Paicu"); 
//        Tabela filho = new Tabela("Filhocu");
//        
//        Coluna coluna1 = new Coluna("Nome", Tipo.VARCHAR, 50, false, false, false, false, false, false);
//        Coluna coluna2 = new Coluna("CPF", Tipo.INT, 50, false, false, false, false, false, false);
//        Coluna coluna3 = new Coluna("N", Tipo.VARCHAR, 50, true, false, false, false, false, false);
//
//        
//        Pai.add(coluna1);
//        Pai.add(coluna2);
//        Pai.add(coluna3);
//        filho.add(coluna2);
//        filho.add(coluna3);
//        
//        metodosTabela.insertTabela(Pai);
//        metodosTabela.insertTabela(filho);  
        metodosTabela.dropTabela("Pai");
        metodosTabela.dropTabela("Filhocu");
//        Coluna coluna = new Coluna("Sobrenome", "VARCHAR", 255, false, true, false, false, false, false);
//        metodosTabela.inserirColuna("", coluna);
//        metodosTabela.dropTabela("");
        
//        Relacionamento relacionamento = new Relacionamento("cpf", "Pai", "id", "CASCADE", "CASCADE");
//        metodosTabela.adicionarRelacionamento("Filho", relacionamento);
        
    }
}


