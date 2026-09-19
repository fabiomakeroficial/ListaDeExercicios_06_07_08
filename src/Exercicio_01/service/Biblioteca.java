package Exercicio_01.service;

import Exercicio_01.model.ItemBiblioteca;
import Exercicio_01.model.Usuario;

public class Biblioteca {

    private ItemBiblioteca[] acervo;
    private int totalItens;

    public Biblioteca( int capacidade){
        this.acervo = new ItemBiblioteca[capacidade];
        this.totalItens = 0;
    }

    // Emprestar
    public void emprestar(Usuario usuario, ItemBiblioteca item){

        // Regra de Negócio: Item não pode ser emprestado se já estiver emprestado
        if (!item.isDisponivel()) {
            System.out.println("Empréstimo Recusado: \"" + item.getTitulo() + "\" já está alugado.");
            return;
        }

        // Regra de Negócio: Usuário não pode passar do limite abstrato dele
        if (!usuario.podeEmpresta()) {
            System.out.println("Empréstimo Recusado: " + usuario.getNome() + " atingiu o limite de " + usuario.getLimiteItens() + " itens.");
            return;
        }

        // Alterações de estado controladas
        item.inverterDisponibilidade();
        usuario.incrementaEmprestimo();

        System.out.println("Sucesso: \"" + item.getTitulo() + "\" emprestado para " + usuario.getNome() + ".");
    }

    // Devolver
    public void devolver(Usuario usuario, ItemBiblioteca item){
        if(item.isDisponivel()){
            System.out.println("O item \"" + item.getTitulo() + "\" já consta no acervo local.");
        }

        item.inverterDisponibilidade();
        usuario.decrementaEmprestimo();
        System.out.println("Sucesso: \"" + item.getTitulo() + "\" devolvido por " + usuario.getNome() + ".");
    }

    // Cadastrar
    public void cadastrar(ItemBiblioteca item){
        if(totalItens < acervo.length){
            acervo[totalItens] = item;
            totalItens++;
        }else{
            System.out.println("O acervo esta cheio!");
        }
    }

    // Listar
    public void listarAcervo(){
        // Um unico laco for, nenhum IF verificando o tipo do item.
        System.out.println("\n========== ACERVO DA BIBLIOTECA ==========");
        for (int i = 0; i < totalItens; i++) {
            ItemBiblioteca item = acervo[i];
            System.out.printf("Cód: %-3d | %-30s | Status: %-10s | Prazo: %2d dias | Multa/Dia: R$ %.2f\n",
                    item.getCodigo(),
                    item.getTitulo(),
                    item.isDisponivel() ? "Disponível" : "Emprestado",
                    item.getPrazoEmprestimo(),
                    item.getValorMultaDiaria()
            );
        }
        System.out.println("==========================================");
    }
}
