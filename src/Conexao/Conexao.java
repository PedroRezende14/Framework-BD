package Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.*;

public class Conexao extends Banco {

    public static Connection conectar() {
        Connection conexao = null;
        try {
            String url = "jdbc:mysql://" + getHost() + ":" + getPorta() + "/" + getNameBanco() + "?useSSL=false&serverTimezone=UTC";
            conexao = DriverManager.getConnection(url, getUser(), getPassword());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
//            e.printStackTrace();
        }
        return conexao;
    }
    
    public static Connection genericConnection() {
        Connection conexao = null;
        try {
            String url = "jdbc:mysql://" + getHost() + ":" + getPorta() + "/?useSSL=false&serverTimezone=UTC";
            conexao = DriverManager.getConnection(url, getUser(), getPassword());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao servidor de banco de dados.");
            e.printStackTrace();
        }
        return conexao;
    }
    
    public static void execute(String sql) {
        try (Connection conexao = conectar();
             Statement stmt = conexao.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao executar a instrução SQL.");
            e.printStackTrace();
        }
    }

    public static String getNameBanco() {
        return nameBanco;
    }

    public static void setNameBanco(String nameBanco) {
        Conexao.nameBanco = nameBanco;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Conexao.user = user;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Conexao.password = password;
    }

    public static int getPorta() {
        return porta;
    }

    public static void setPorta(int porta) {
        Conexao.porta = porta;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        Conexao.host = host;
    } 
}
