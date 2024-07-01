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
		
		public void listarCharsets() {
			for (Charsets charset : Charsets.values()) {
	            System.out.println(charset.name() + ": " + charset.getCharsetName());
	        }
	    }
		
		 public void listarCollations() {
			  for (Collations collation : Collations.values()) {
		            System.out.println(collation.name() + ": " + collation.getCollationName());
		        }
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

