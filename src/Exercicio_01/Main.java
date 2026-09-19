package Exercicio_01;

import Exercicio_01.model.*;
import Exercicio_01.service.Biblioteca;

public class Main {
    public static void main(String[] args) {

        // Criando a biblioteca com espaço fixo para 10 itens
        Biblioteca biblioteca = new Biblioteca(10);

        // 1. Cadastro de itens variados
        Livro livro1 = new Livro(101, "Ensino do Java");
        Livro livro2 = new Livro(102, "Clean Code");
        Revista revista1 = new Revista(201, "Fantastico Mundo de Bob");
        Revista revista2 = new Revista(202, "As aventuras não aventuradas");
        Dvd dvd1 = new Dvd(301, "Matrix");
        Dvd dvd2 = new Dvd(302, "Home Aranha");

        biblioteca.cadastrar(livro1);
        biblioteca.cadastrar(livro2);
        biblioteca.cadastrar(revista1);
        biblioteca.cadastrar(revista2);
        biblioteca.cadastrar(dvd1);
        biblioteca.cadastrar(dvd2);

        // Criando os perfis de usuários para teste
        Usuario aluno = new Aluno("Ambrósio Silva");
        Usuario professor = new Professor("Professor Jaques");

        System.out.println("------- INICIANDO CENARIO DE TESTE -------");

        // 2. Empréstimos bem-sucedidos (Até o limite do Aluno que é 3)
        biblioteca.emprestar(aluno, livro1);
        biblioteca.emprestar(aluno, livro2);
        biblioteca.emprestar(aluno, revista1);
        biblioteca.emprestar(professor, dvd1);
        biblioteca.emprestar(professor, dvd2);
        biblioteca.emprestar(professor, livro1);
        biblioteca.emprestar(professor, livro2);
        biblioteca.emprestar(professor, revista2);

        // 3. Empréstimo recusado (O limite do aluno é 3, tentando pegar o 4º item)
        biblioteca.emprestar(aluno, revista2);
        biblioteca.emprestar(professor, revista1);

        // Listagem final para conferência do acervo e regras via polimorfismo
        biblioteca.listarAcervo();
    }
}