package Metodos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Conexao.Conexao;
import Interface.BancoInterface;

public class BancoMetodos implements BancoInterface{
	
		public void criarBanco(String nome, String charset, String collation) {
			
			 try {
				  Conexao.setNameBanco(nome);
				 Connection conexao = Conexao.genericConnection();
				 Statement stmt = null;
		            stmt = conexao.createStatement();
		            String sql = "CREATE DATABASE "+ nome + " DEFAULT CHARACTER SET "+charset+" COLLATE " + collation ;
		            stmt.executeUpdate(sql);
		            System.out.println("Banco de dados criado com sucesso!");
		        } catch (SQLException e) {
		            e.printStackTrace();
		     }
		}
		
		public void listarCharsets() {
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
	    }
		
		 public void listarCollations(String charset) {
			 
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
		    }


		
}
