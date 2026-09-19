package Exercicio_01.model;

import Exercicio_01.config.ConfigBiblioteca;

public class Revista extends ItemBiblioteca{

    public Revista(int codigo, String titulo){
        super(codigo, titulo);
    }

    @Override
    public int getPrazoEmprestimo() {
        return ConfigBiblioteca.PRAZO_REVISTA;
    }

    @Override
    public double getValorMultaDiaria() {
        return ConfigBiblioteca.MULTA_REVISTA;
    }

}
