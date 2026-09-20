package Exercicio_02.src.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/db_biblioteca";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "123456";
    // Caminho para a pasta dos scripts de banco
    private static final String CAMINHO_SQL = "src/Exercicio_02/resource/biblioteca.sql";

    // Busca uma nova conexão ativa com o PostgreSQL.
    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    // Lê o script SQL (ignora linhas de comentarios).
    public static String lerScript(String caminho) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().startsWith("--")) {
                    conteudo.append(linha).append("\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o script : " + e.getMessage());
        }
        return conteudo.toString();
    }

    //
    public static void inicializarBancoDeDados() {
        System.out.println("\nCarregando script SQL...");
        String scriptSql = DataBaseUtil.lerScript(CAMINHO_SQL);

        if (scriptSql.isEmpty()) {
            System.err.println("Erro: Arquivo SQL vazio ou não encontrado.");
            return;
        }

        try (Connection conexao = DataBaseUtil.obterConexao();
             Statement stmt = conexao.createStatement()) {

            System.out.println("Executando comandos do script...");
            String[] comandos = scriptSql.split(";");

            for (String comando : comandos) {
                String comandoLimpo = comando.trim();
                if (!comandoLimpo.isEmpty()) {
                    stmt.execute(comandoLimpo);
                }
            }
            System.out.println("Sucesso: Tabelas criadas e dados inseridos!");

        } catch (SQLException e) {
            System.err.println("Erro ao inicializar o banco de dados:");
            e.printStackTrace();
        }
    }
}
