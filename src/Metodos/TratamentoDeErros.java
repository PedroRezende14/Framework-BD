package Metodos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Conexao.Conexao;

public class TratamentoDeErros {

    public boolean verificarExistenciaDoBanco(String nomeBanco) {
        try (Connection conexao = Conexao.genericConnection();
             Statement stmt = conexao.createStatement()) {

            String sql = "SHOW DATABASES LIKE '" + nomeBanco + "'";
            try (ResultSet resultSet = stmt.executeQuery(sql)) {
                if (resultSet.next()) {
                    System.out.println("Banco de dados ja existe");
                    return false;
                } else {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean verificarConexao() {
        try (Connection conexao = Conexao.conectar()) {
            if (conexao != null && !conexao.isClosed()) {
                return true;
            } else {
            	System.out.println("Conexao falhou, e necessario setar um banco de dados, p fazer isso Conexao.setNameBanco(\"Nome Do Banco\"); ");
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
    
    
}
