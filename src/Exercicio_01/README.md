meu-projeto-biblioteca/
│
├── src/
│   └── br/
│       └── com/
│           └── biblioteca/
│               │
│               ├── Exercicio_01.Main.java                        <-- Classe com o método de testes (main)
│               │
│               ├── Exercicio_01.config/
│               │   └── ConfigBiblioteca.java        <-- Onde ficam as constantes globais
│               │
│               ├── Exercicio_01.model/
│               │   ├── ItemBiblioteca.java          <-- Classe abstrata mãe dos itens
│               │   ├── Livro.java                   <-- Subclasse concreta
│               │   ├── Revista.java                 <-- Subclasse concreta
│               │   │
│               │   ├── Usuario.java                 <-- Classe abstrata mãe dos usuários
│               │   ├── Aluno.java                   <-- Subclasse concreta
│               │   └── Professor.java               <-- Subclasse concreta
│               │
│               └── Exercicio_01.service/
│                   └── Biblioteca.java              <-- Gerencia o acervo, empréstimos e devoluções
│
└── README.md