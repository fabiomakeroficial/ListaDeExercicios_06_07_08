package Exercicio_01.model;

public abstract class Usuario {
    private String nome;
    private int quantidadeEmprestada;

    public Usuario(String nome) {
        this.nome = nome;
        this.quantidadeEmprestada = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    // Metodo abstrato que irá trazer o limite especifico na subclasses
    public abstract int getLimiteItens() ;

    public void incrementaEmprestimo(){ this.quantidadeEmprestada++; }
    public void decrementaEmprestimo(){ this.quantidadeEmprestada--; }

    public boolean podeEmpresta(){
        return quantidadeEmprestada < getLimiteItens();
    }

}
