package DTO;

import java.util.ArrayList;
import java.util.List;

public class Tabela {
    private String nome;
    private List<Coluna> colunas;
    private List<Relacionamento> relacionamentos;

    public Tabela(String nome) {
        this.nome = nome;
        this.colunas = new ArrayList<>();
        this.relacionamentos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Coluna> getColunas() {
        return colunas;
    }

    public void add(Coluna coluna) {
        this.colunas.add(coluna);
    }

    public void addRelacionamento(Relacionamento relacionamento) {
        this.relacionamentos.add(relacionamento);
    }

    public String criarTabelaSQL() {
        StringBuilder sql = new StringBuilder("CREATE TABLE " + nome + " (");
        for (int i = 0; i < colunas.size(); i++) {
            sql.append(colunas.get(i).toSQL());
            if (i < colunas.size() - 1 || !relacionamentos.isEmpty()) {
                sql.append(", ");
            }
        }
        for (int i = 0; i < relacionamentos.size(); i++) {
            sql.append(relacionamentos.get(i).toSQL());
            if (i < relacionamentos.size() - 1) {
                sql.append(", ");
            }
        }
        sql.append(");");
        return sql.toString();
    }

    @Override
    public String toString() {
        return "Tabela [nome=" + nome + ", colunas=" + colunas + ", relacionamentos=" + relacionamentos + "]";
    }
}
