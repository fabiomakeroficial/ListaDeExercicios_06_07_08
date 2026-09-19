package Exercicio_01.model;

public abstract class ItemBiblioteca {
    private int codigo;
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(int codigo, String titulo){
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // A alteracao ocorre aqui, sem a necessidade de public setDisponivel()
    public void inverterDisponibilidade() {
        this.disponivel = !this.disponivel;
    }

    // Metodo abstrato, sem atributos comuns para prazos e multas
    public abstract int getPrazoEmprestimo();
    public abstract double getValorMultaDiaria();

}
