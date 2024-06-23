package Testes;

import java.sql.SQLException;

import Metodos.TratamentoDeErros;

public class teste {

	public static void main(String[] args) throws SQLException {
		
		TratamentoDeErros e = new TratamentoDeErros();
		
//		e.verificarExistenciaDoBanco("teste");
		
		e.verificarConexao();
	}

}
