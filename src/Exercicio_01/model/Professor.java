package Exercicio_01.model;

import Exercicio_01.config.ConfigBiblioteca;

public class Professor extends Usuario {

    public Professor(String nome){
        super(nome);
    }

    @Override
    public int getLimiteItens() {
        return ConfigBiblioteca.LIMITE_PROFESSOR;
    }
}
