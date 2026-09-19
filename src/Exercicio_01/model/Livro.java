package Exercicio_01.model;

import Exercicio_01.config.ConfigBiblioteca;

public class Livro extends ItemBiblioteca{

    public Livro(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoEmprestimo() {
        return ConfigBiblioteca.PRAZO_LIVRO;
    }

    @Override
    public double getValorMultaDiaria() {
        return ConfigBiblioteca.MULTA_LIVRO;
    }
}
