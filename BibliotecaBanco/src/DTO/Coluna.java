package DTO;

public class Coluna {
	private String nome;
	private String tipo;
	private int tamanho;
	private boolean pk;
    private boolean nn;
    private boolean uq;
    private boolean zf;
    private boolean ai;
    private boolean g;

    public Coluna(String nome, String tipo, int tamanho, boolean pk, boolean nn, boolean uq, boolean zf, boolean ai, boolean g) {
        this.nome = nome;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.pk = pk;
        this.nn = nn;
        this.uq = uq;
        this.zf = zf;
        this.ai = ai;
        this.g = g;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public boolean isPk() {
		return pk;
	}

	public void setPk(boolean pk) {
		this.pk = pk;
	}

	public boolean isNn() {
		return nn;
	}

	public void setNn(boolean nn) {
		this.nn = nn;
	}

	public boolean isUq() {
		return uq;
	}

	public void setUq(boolean uq) {
		this.uq = uq;
	}

	public boolean isZf() {
		return zf;
	}

	public void setZf(boolean zf) {
		this.zf = zf;
	}

	public boolean isAi() {
		return ai;
	}

	public void setAi(boolean ai) {
		this.ai = ai;
	}

	public boolean isG() {
		return g;
	}

	public void setG(boolean g) {
		this.g = g;
	}
    
	
	 public String toString() {
	        return "Coluna [nome=" + nome + ", tipo=" + tipo + ", tamanho=" + tamanho + ", pk=" + pk + ", nn=" + nn
	                + ", uq=" + uq + ", zf=" + zf + ", ai=" + ai + ", g=" + g + "]";
	    }

	    public String toSQL() {
	        String sql = nome + " " + tipo;
	        if (tipo.equalsIgnoreCase("VARCHAR") || tipo.equalsIgnoreCase("CHAR")) {
	            sql += "(" + tamanho + ")";
	        }
	        if (pk) sql += " PRIMARY KEY";
	        if (nn) sql += " NOT NULL";
	        if (uq) sql += " UNIQUE";
	        if (zf) sql += " ZEROFILL";
	        if (ai) sql += " AUTO_INCREMENT";
	        if (g) sql += " GENERATED ALWAYS AS (...)"; 
	        return sql;
	    }
	}