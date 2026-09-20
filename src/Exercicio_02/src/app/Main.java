package Exercicio_02.src.app;

import Exercicio_02.src.database.DataBaseUtil;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Iniciando Aplicação Biblioteca ---");

        // 1. Executa o script de criação e população do banco
        DataBaseUtil.inicializarBancoDeDados();

    }

}
