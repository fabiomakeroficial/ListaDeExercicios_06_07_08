package Exercicio_01.model;

import Exercicio_01.config.ConfigBiblioteca;

public class Aluno extends Usuario{

    public Aluno(String nome){
        super( nome);
    }

    @Override
    public int getLimiteItens() {
        return ConfigBiblioteca.LIMITE_ALUNO;
    }
}
