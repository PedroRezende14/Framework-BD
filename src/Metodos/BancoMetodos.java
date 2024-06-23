	package Metodos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Conexao.Conexao;
import DTO.*;
import Interface.BancoInterface;


public class BancoMetodos implements BancoInterface{
	TratamentoDeErros e = new TratamentoDeErros();
	
		public void criarBanco(String nome, Charsets charset, Collations collation){
			if(e.verificarExistenciaDoBanco(nome)) {
				 try {
					  Conexao.setNameBanco(nome);
					 Connection conexao = Conexao.genericConnection();
					 Statement stmt = null;
			            stmt = conexao.createStatement();
			            String sql = "CREATE DATABASE "+ nome + " DEFAULT CHARACTER SET " + charset.getCharsetName()+" COLLATE " + collation.getCollationName(); ;
			            stmt.executeUpdate(sql);
			            System.out.println("Banco de dados criado com sucesso!");
			        } catch (SQLException e) {
			            e.printStackTrace();
			     }
			}
		}
		
		public String listarCharsets() {
	        try {
	        	Connection conexao = Conexao.genericConnection();
	            Statement stmt = conexao.createStatement();
	            String sql = "SHOW CHARACTER SET";
	            ResultSet rs = stmt.executeQuery(sql);

	            System.out.println("Lista de charsets disponíveis:");
	            while (rs.next()) {
	                String charset = rs.getString("Charset");
	                String description = rs.getString("Description");
	                System.out.println(charset + ": " + description);
	            }
	            rs.close();
	            stmt.close();
	            conexao.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return null;
	    }
		
		 public String listarCollations(String charset) {
			 
		        try { Connection conexao = Conexao.genericConnection();
		            Statement stmt = conexao.createStatement();
		            String sql = "SHOW COLLATION WHERE Charset = '" + charset + "'";
		            ResultSet rs = stmt.executeQuery(sql);

		            System.out.println("Lista de collations para o charset " + charset + ":");
		            while (rs.next()) {
		                String collation = rs.getString("Collation");
		                String isDefault = rs.getString("Default");
		                System.out.println(collation + (isDefault.equals("Yes") ? " (default)" : ""));
		            }                                                                                    

		            rs.close();
		            stmt.close();
		            conexao.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
				return charset;
		    }	
		 
		 public void dropBanco(String nomeBanco) {
			 try {
				 Connection conexao = Conexao.genericConnection();
				 Statement stmt = conexao.createStatement();
				 String sql = "DROP DATABASE "+ nomeBanco;
				 stmt.executeUpdate(sql);
				 System.out.println(sql);
				 }
			 catch (SQLException e) {
			            e.printStackTrace();
			        }
			 }
}

