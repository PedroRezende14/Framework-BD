package Main;

import Conexao.*;
import DTO.*;
import Metodos.*;

public class Main {

    public static void main(String[] args) {

        BancoMetodos cb = new BancoMetodos();
        cb.criarBanco("abc123", "utf8", "utf8_roman_ci");
//        cb.listarCharsets();
//        cb.listarCollations("utf8");

        Conexao.setNameBanco("mybanco");
        TabelaMetodos metodosTabela = new TabelaMetodos();
        
        Tabela tabela = new Tabela("a"); 
        Coluna coluna1 = new Coluna("id", "INT", 11, true, true, false, false, true, false);
        Coluna coluna2 = new Coluna("nome", "VARCHAR", 255, false, true, false, false, false, false);
        Coluna coluna3 = new Coluna("cpf", "VARCHAR", 14, false, true, true, false, false, false);

        tabela.add(coluna1);
        tabela.add(coluna2);
        tabela.add(coluna3);
   
        metodosTabela.insertTabela(tabela);
        metodosTabela.dropTabela("cu2");
        metodosTabela.inserirColuna("c", coluna1);
        
        Relacionamento relacionamento = new Relacionamento("id", "cu1", "id", "CASCADE", "CASCADE");
        metodosTabela.adicionarRelacionamento("a", relacionamento);
        
    }
}


