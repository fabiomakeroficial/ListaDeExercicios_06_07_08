package Exercicio_01.config;

public class ConfigBiblioteca {
    private ConfigBiblioteca(){
        throw new UnsupportedOperationException("Essa classe não pode ser instanciada");
    }

    // Regra dos prazos
    public static final int PRAZO_LIVRO = 14;
    public static final int PRAZO_REVISTA = 7;
    public static final int PRAZO_DVD = 3;

    // Regras das multas
    public static final double MULTA_LIVRO = 0.5;
    public static final double MULTA_REVISTA = 1.0;
    public static final double MULTA_DVD = 2.50;

    // Regras dos limites de emprestimos
    public static final int LIMITE_ALUNO = 3;
    public static final int LIMITE_PROFESSOR = 5;
}
