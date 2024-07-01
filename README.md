# Framework--BD

Configuração do Ambiente e Execução do Projeto
Para executar este projeto, siga as instruções abaixo para configurar seu ambiente de desenvolvimento.

# Pré-requisitos
faça download  libBD2.0.jar:
https://drive.google.com/drive/folders/1rGwn8w93PcQ2z6XnLbiW75pz4J8uDTBC?usp=sharing

Certifique-se de ter instalado os seguintes softwares:

XAMPP: Para configurar o servidor MySQL local.
https://www.apachefriends.org/pt_br/download.html


MySQL Workbench: Para gerenciamento e administração do banco de dados MySQL. 
https://dev.mysql.com/downloads/workbench/


Eclipse: Ambiente de desenvolvimento integrado (IDE) para Java.
https://www.eclipse.org/downloads/



# Configuração do Ambiente
Criar um Projeto no Eclipse:

Abra o Eclipse.
Vá para File -> New -> Java Project.
Dê um nome ao projeto e clique em Finish.

Criar um Package:
Botão direito na pasta do projeto -> New -> Package.
Dê um nome ao pacote e clique em Finish.

Adicionar Biblioteca Externa:
Botão direito na pasta do projeto -> Build Path -> Configure Build Path.
Em "Java Build Path", vá para a aba Libraries ou Modulepath (dependendo da versão do Eclipse).
Clique em Add External JARs e selecione o arquivo libBD2.0.jar.
Clique em Apply and Close.


Configurar o arquivo module-info.java:
Vá para SRC -> module-info.java.
Adicione as seguintes linhas para importar as dependências necessárias:

```java
module NomeProjeto {
	requires BibliotecaBanco;
	requires java.sql;
}
```

Converter para Projeto Maven:

Na pasta principal do seu projeto, clique com o botão direito -> Configure -> Convert to Maven Project.

Será gerado um arquivo pom.xml.

Editar o arquivo pom.xml:

Abra o arquivo pom.xml e adicione a seguinte dependência para o MySQL Connector/J:

```java
<dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.27</version> 
        </dependency>
</dependencies>
```


## Antes
![image](https://github.com/PedroRezende14/Framework-BD/assets/128604858/bcae02b1-6150-4798-b549-9703f2bb0120)

    
## Depois
![image](https://github.com/PedroRezende14/Framework-BD/assets/128604858/1a52a01a-1aff-425c-8aa0-06df3a27f4cb)


Executando o Projeto
Com o ambiente configurado e as dependências adicionadas, você está pronto para executar o projeto no Eclipse. Certifique-se de que o servidor MySQL local (XAMPP) esteja iniciado e o MySQL Workbench esteja configurado corretamente com as bases de dados necessárias.

## Configurando Xamp e o MySQL:

Abra o Xamp: 
Execulte Apache e o MySql

## Antes
![image](https://github.com/PedroRezende14/Framework-BD/assets/128604858/b4e426b7-5bce-4e9f-9ffb-7e7b4bfd6762)


## Depois


![image](https://github.com/PedroRezende14/Framework-BD/assets/128604858/bdc5da82-0105-4543-b3a4-1bf0cf990883)


Abra o MySql
Crie uma nova Connections

![image](https://github.com/PedroRezende14/Framework-BD/assets/128604858/d3289fb3-6b64-4009-a9e3-a84bea87650d)

![image](https://github.com/PedroRezende14/Framework-BD/assets/128604858/d538efe5-5490-4a97-a6d6-c61f5dc8590d)

# Como criar meu primeiro banco de dados:

Dentro do Package criado anteriomente crie uma class 
new -> class -> de um nome e finish

fala os seguintes import 





### Criando Banco

```java

import DTO.*;
import Metodos.*;

public class Main {
	public static void main(String[] args) {

//		CONFIGURAÇÕES PRE SETADAS, NA CONEXAO, MAS PARA MUDAR APENAS USER O COMANDO ABAIXO
	//        Conexao.setNameBanco("");  // NOME DO BANCO É SETADO APARTIR DO MOMENTO QUE VC CRIA UM BANCO DE DADOS
	//        Conexao.setHost("localhost"); 
	//        Conexao.setPorta(3306);
	//        Conexao.setUser("root");
	//        Conexao.setPassword("");


	       BancoMetodos bancoMetodos = new BancoMetodos(); // -> Chamando o metodo do banco
               bancoMetodos.criarBanco("escola", Charsets.UTF8, Collations.UTF8_GENERAL_CI); //-> para criar um banco chame o ".criarBanco("NOME_DO_BANCO", Charsets.DESEJADO, Collations.DESEJADO );"
```

### Criando Tabela
```java
		Tabela pai = new Tabela("pai");  // -> criando uma tabela
  		Coluna Nome = new Coluna("nome", Tipo.VARCHAR, 100, false, true, false, false, false, false); // -> criando uma coluna

		pai.add(new Coluna("id", Tipo.INT, 11, true, true, false, false, true, false)); // outra maneira de adcionar uma coluna
 		pai.add(Nome); -> adicionando a coluna "nome" na tabela "pai"
	
```

### Inserindo Tabela no banco de dados  

```java

		TabelaMetodos metodosTabela = new TabelaMetodos(); Chamando o metodo de Tabela
		metodosTabela.insertTabela(pai);
		
	}
}

```

# exemplo de codigo disponivel:

https://github.com/PedroRezende14/Framework-BD/blob/main/src/Main/CriaBanco.java

# como usar o crud da biblioteca:
https://github.com/PedroRezende14/Framework-BD/blob/main/src/Main/MainCrud.java






