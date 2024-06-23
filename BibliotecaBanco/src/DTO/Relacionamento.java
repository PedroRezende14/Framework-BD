package DTO;

public class Relacionamento {
    private String colunaOrigem;
    private String tabelaDestino;
    private String colunaDestino;
    private String onDelete; 
    private String onUpdate; 

    public Relacionamento(String colunaOrigem, String tabelaDestino, String colunaDestino, String onDelete, String onUpdate) {
        this.colunaOrigem = colunaOrigem;
        this.tabelaDestino = tabelaDestino;
        this.colunaDestino = colunaDestino;
        this.onDelete = onDelete;
        this.onUpdate = onUpdate;
    }

    public String getColunaOrigem() {
        return colunaOrigem;
    }

    public void setColunaOrigem(String colunaOrigem) {
        this.colunaOrigem = colunaOrigem;
    }

    public String getTabelaDestino() {
        return tabelaDestino;
    }

    public void setTabelaDestino(String tabelaDestino) {
        this.tabelaDestino = tabelaDestino;
    }

    public String getColunaDestino() {
        return colunaDestino;
    }

    public void setColunaDestino(String colunaDestino) {
        this.colunaDestino = colunaDestino;
    }

    public String getOnDelete() {
        return onDelete;
    }

    public void setOnDelete(String onDelete) {
        this.onDelete = onDelete;
    }

    public String getOnUpdate() {
        return onUpdate;
    }

    public void setOnUpdate(String onUpdate) {
        this.onUpdate = onUpdate;
    }

    public String toSQL() {
        return "FOREIGN KEY (" + colunaOrigem + ") REFERENCES " + tabelaDestino + "(" + colunaDestino + ")" +
                (onDelete != null ? " ON DELETE " + onDelete : "") +
                (onUpdate != null ? " ON UPDATE " + onUpdate : "");
    }

    @Override
    public String toString() {
        return "Relacionamento [colunaOrigem=" + colunaOrigem + ", tabelaDestino=" + tabelaDestino +
                ", colunaDestino=" + colunaDestino + ", onDelete=" + onDelete + ", onUpdate=" + onUpdate + "]";
    }
}
