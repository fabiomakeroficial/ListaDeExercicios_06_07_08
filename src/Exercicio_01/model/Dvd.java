package Exercicio_01.model;

import Exercicio_01.config.ConfigBiblioteca;

public class Dvd extends ItemBiblioteca{

    public Dvd(int codigo, String titulo){
        super(codigo, titulo);
    }

    @Override
    public int getPrazoEmprestimo() {
        return ConfigBiblioteca.PRAZO_DVD;
    }

    @Override
    public double getValorMultaDiaria() {
        return ConfigBiblioteca.MULTA_DVD;
    }
}
