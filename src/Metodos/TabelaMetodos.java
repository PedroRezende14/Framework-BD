package Metodos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Conexao.Conexao;
import DTO.*;
import Interface.TabelaInterface;

public class TabelaMetodos implements TabelaInterface {
	 TratamentoDeErros e = new TratamentoDeErros();
	
	 public void insertTabela(Tabela tabela) {
		 if(e.verificarConexao()) {
	        String sql = tabela.criarTabelaSQL();
	        System.out.println("Executando SQL: " + sql);
	        Conexao.execute(sql);
		 }
	   }
	 
	 public void inserirColuna(String nomeTabela ,Coluna coluna){
		try{
			 if(e.verificarConexao()) {
				 Connection conexao = Conexao.conectar();
		         Statement stmt = conexao.createStatement();
		         
		         String sql = "ALTER TABLE " + nomeTabela + " ADD " + coluna.toSQL();
		         
		         stmt.executeUpdate(sql);
		         System.out.println(sql);
		         stmt.close();
		         conexao.close();
	         	}
		     } catch (SQLException e) {
		         e.printStackTrace();
	     }
}

    public void dropTabela(String nomeTabela) {
        try {
        	if(e.verificarConexao()) {
	            Connection conexao = Conexao.conectar();
	            Statement stmt = conexao.createStatement();
	
	            String sql = "DROP TABLE " + nomeTabela;
	
	            stmt.executeUpdate(sql);
	            System.out.println(sql);
	            stmt.close();
	            conexao.close();
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropColuna(String nomeTabela, String nomeColuna) {
        try {
        	if(e.verificarConexao()) {
	            Connection conexao = Conexao.conectar();
	            Statement stmt = conexao.createStatement();
	
	            String sql = "ALTER TABLE " + nomeTabela +
	                         " DROP COLUMN " + nomeColuna;
	
	            stmt.executeUpdate(sql);
	            System.out.println(sql);
	            stmt.close();
	            conexao.close();
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPK(String nomeTabela, String nomeColuna) {
        try {
        	if(e.verificarConexao()) {
	            Connection conexao = Conexao.conectar();
	            Statement stmt = conexao.createStatement();
	
	            String sql = "ALTER TABLE " + nomeTabela +
	                         " ADD PRIMARY KEY (" + nomeColuna + ")";
	
	            stmt.executeUpdate(sql);
	            System.out.println(sql);
	            stmt.close();
	            conexao.close();
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropPK(String nomeTabela) {
        try {
        	if(e.verificarConexao()) {
	            Connection conexao = Conexao.conectar();
	            Statement stmt = conexao.createStatement();
	
	            String sql = "ALTER TABLE " + nomeTabela +
	                         " DROP PRIMARY KEY";
	
	            stmt.executeUpdate(sql);
	            System.out.println(sql);
	            stmt.close();
	            conexao.close();
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void adicionarRelacionamento(String nomeTabela, Relacionamento relacionamento) {
        try {
        	if(e.verificarConexao()) {
	            Connection conexao = Conexao.conectar();
	            Statement stmt = conexao.createStatement();
	            
	            String sql = "ALTER TABLE " + nomeTabela + " ADD " + relacionamento.toSQL();
	            
	            stmt.executeUpdate(sql);
	            System.out.println(sql);
	            stmt.close();
	            conexao.close();
        	}
	    } catch (SQLException e) {
	      e.printStackTrace();  
        }
    }

    public void removerChaveEstrangeira(String nomeTabela, String nomeFK) {
        try {
        	if(e.verificarConexao()) {
	            Connection conexao = Conexao.conectar();
	            Statement stmt = conexao.createStatement();
	
	            String sql = "ALTER TABLE " + nomeTabela +
	                         " DROP FOREIGN KEY " + nomeFK;
	
	            stmt.executeUpdate(sql);
	            System.out.println(sql);
	            stmt.close();
	            conexao.close();
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
