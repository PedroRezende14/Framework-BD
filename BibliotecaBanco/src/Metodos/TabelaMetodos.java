package Metodos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Conexao.Conexao;
import DTO.*;
import Interface.TabelaInterface;

public class TabelaMetodos implements TabelaInterface {

	 public void insertTabela(Tabela tabela) {
	        String sql = tabela.criarTabelaSQL();
	        System.out.println("Executando SQL: " + sql);
	        Conexao.execute(sql);
	    }
	 
	 public void inserirColuna(String nomeTabela ,Coluna coluna){
		 
		try{
		 Connection conexao = Conexao.conectar();
         Statement stmt = conexao.createStatement();
         
         String sql = "ALTER TABLE " + nomeTabela + " ADD " + coluna.toSQL();
         
         stmt.executeUpdate(sql);
         System.out.println("Coluna adicionada na tabela " + nomeTabela);
         stmt.close();
         conexao.close();
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
}

    public void dropTabela(String nomeTabela) {
        try {
            Connection conexao = Conexao.conectar();
            Statement stmt = conexao.createStatement();

            String sql = "DROP TABLE " + nomeTabela;

            stmt.executeUpdate(sql);
            System.out.println("Tabela " + nomeTabela + " excluída com sucesso!");
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropColuna(String nomeTabela, String nomeColuna) {
        try {
            Connection conexao = Conexao.conectar();
            Statement stmt = conexao.createStatement();

            String sql = "ALTER TABLE " + nomeTabela +
                         " DROP COLUMN " + nomeColuna;

            stmt.executeUpdate(sql);
            System.out.println("Coluna " + nomeColuna + " excluída da tabela " + nomeTabela);
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPK(String nomeTabela, String nomeColuna) {
        try {
            Connection conexao = Conexao.conectar();
            Statement stmt = conexao.createStatement();

            String sql = "ALTER TABLE " + nomeTabela +
                         " ADD PRIMARY KEY (" + nomeColuna + ")";

            stmt.executeUpdate(sql);
            System.out.println("Chave primária adicionada à coluna " + nomeColuna + " na tabela " + nomeTabela);
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  
    public void dropPK(String nomeTabela) {
        try {
            Connection conexao = Conexao.conectar();
            Statement stmt = conexao.createStatement();

            String sql = "ALTER TABLE " + nomeTabela +
                         " DROP PRIMARY KEY";

            stmt.executeUpdate(sql);
            System.out.println("Chave primária removida da tabela " + nomeTabela);
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void adicionarRelacionamento(String nomeTabela, Relacionamento relacionamento) {
        try {
            Connection conexao = Conexao.conectar();
            Statement stmt = conexao.createStatement();
            
            String sql = "ALTER TABLE " + nomeTabela + " ADD " + relacionamento.toSQL();
            
            stmt.executeUpdate(sql);
            System.out.println("Relacionamento adicionado à tabela " + nomeTabela);
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerChaveEstrangeira(String tabelaOrigem, String nomeFK) {
        try {
            Connection conexao = Conexao.conectar();
            Statement stmt = conexao.createStatement();

            String sql = "ALTER TABLE " + tabelaOrigem +
                         " DROP FOREIGN KEY " + nomeFK;

            stmt.executeUpdate(sql);
            System.out.println("Chave estrangeira removida da tabela " + tabelaOrigem);
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
