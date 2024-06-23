package DTO;

public class Banco {
	protected String nome;
	protected String collation;
	protected String charset;
	protected static String nameBanco;
	protected static String user = "root";
	protected static String password="";
	protected static String host="localhost";
	protected static int porta=3306;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCollation() {
		return collation;
	}
	public void setCollation(String collation) {
		this.collation = collation;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	
	
}
