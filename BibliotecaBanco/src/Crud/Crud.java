package Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Conexao.Conexao;

public class Crud {
	
    public static String substituirPorInterrogacoes(String entrada) {
        if (entrada == null || entrada.isEmpty()) {
            return "";
        }
        String[] componentes = entrada.split(",\\s*");
        String[] componentesSubstituidos = new String[componentes.length];
        for (int i = 0; i < componentes.length; i++) {
            componentesSubstituidos[i] = "?";
        }
        return String.join(", ", componentesSubstituidos);
    }

    public static String[] salvarEmArray(String entrada) {
        if (entrada == null || entrada.isEmpty()) {
            return new String[0];
        }
        return entrada.split(",\\s*");
    }

    public void inserir(String nomeTabela, String nomeColunas, String valor) {
        String resultado = substituirPorInterrogacoes(nomeColunas);
        String[] valoresArray = salvarEmArray(valor);

        String sql = "INSERT INTO " + nomeTabela + " (" + nomeColunas + ") VALUES (" + resultado + ")";
        
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            for (int i = 0; i < valoresArray.length; i++) {
                stmt.setString(i + 1, valoresArray[i]);
            }
            stmt.executeUpdate();
            System.out.println("Dados adicionados com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Map<String, String>> verTodos (String nomeTabela) {
        List<Map<String, String>> resultado = new ArrayList<>();
        String sql = "SELECT * FROM " + nomeTabela;

        try (Connection conexao = Conexao.conectar();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Map<String, String> linha = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    linha.put(columnName, rs.getString(i));
                }
                resultado.add(linha);
            }
            printt(resultado); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public void printt(List<Map<String, String>> lista) {
        for (Map<String, String> registro : lista) {
            System.out.println(registro);
        }
    }
    
   
    
    public void excluir(String nomeTabela, String nomeColuna, String id) {
        String sql = "DELETE FROM " + nomeTabela + " WHERE "+nomeColuna+" = ?";
        
        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, id); 
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Dados excluídos com sucesso.");
            } else {
                System.out.println("ID nao encotrado.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void alterar(String nomeTabela, String nomeColunas, String novosValores, String nomeColunaCondicao, String valorCondicao) {
        String[] colunasArray = salvarEmArray(nomeColunas);
        String[] valoresArray = salvarEmArray(novosValores);

        if (colunasArray.length != valoresArray.length) {
            throw new IllegalArgumentException("O número de colunas deve corresponder ao número de valores.");
        }

        StringBuilder sql = new StringBuilder("UPDATE " + nomeTabela + " SET ");
        for (int i = 0; i < colunasArray.length; i++) {
            sql.append(colunasArray[i]).append(" = ?");
            if (i < colunasArray.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(" WHERE ").append(nomeColunaCondicao).append(" = ?");

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql.toString())) {

            for (int i = 0; i < valoresArray.length; i++) {
                stmt.setString(i + 1, valoresArray[i]);
            }
            stmt.setString(colunasArray.length + 1, valorCondicao);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Dados atualizados com sucesso.");
            } else {
                System.out.println("Nenhuma linha encontrada para atualização.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Map<String, String> procurarPorId(String nomeTabela, String nomeColunaId, String valorId) {
        Map<String, String> resultado = new HashMap<>();
        String sql = "SELECT * FROM " + nomeTabela + " WHERE " + nomeColunaId + " = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, valorId);

            try (ResultSet rs = stmt.executeQuery()) {
                int columnCount = rs.getMetaData().getColumnCount();
                
                if (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = rs.getMetaData().getColumnName(i);
                        resultado.put(columnName, rs.getString(i));
                    }
                    System.out.println(resultado);
                } else {
                    System.out.println("Nenhum registro encontrado com o ID fornecido.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
}