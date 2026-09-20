-- ==========================================
-- TABELA ITEM
-- ==========================================
CREATE TABLE IF NOT EXISTS ITEM ( ID BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                  CODIGO VARCHAR(30) NOT NULL UNIQUE,
                                  TITULO VARCHAR(200) NOT NULL,
                                  TIPO VARCHAR(20) NOT NULL,
                                  AUTOR VARCHAR(150) NOT NULL,
                                  EDICAO INTEGER NOT NULL,
                                  DISPONIVEL BOOLEAN NOT NULL DEFAULT TRUE,
                                  CONSTRAINT unique_codigo_item UNIQUE (CODIGO),
                                  CONSTRAINT chk_item_tipo CHECK (TIPO IN ('LIVRO', 'REVISTA')) );
-- ==========================================
-- TABELA USUARIO
-- ==========================================
CREATE TABLE IF NOT EXISTS USUARIO ( ID BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                     NOME VARCHAR(150) NOT NULL UNIQUE,
                                     TIPO VARCHAR(20) NOT NULL,
                                     LIMITE_ITENS INTEGER NOT NULL DEFAULT 0,
                                     CONSTRAINT chk_usuario_tipo CHECK (TIPO IN ('ALUNO', 'PROFESSOR')));
-- ==========================================
-- TABELA EMPRESTIMO
-- ==========================================
CREATE TABLE IF NOT EXISTS EMPRESTIMO ( ID BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                        ITEM_ID BIGINT NOT NULL,
                                        USUARIO_ID BIGINT NOT NULL,
                                        DATA_RETIRADA DATE NOT NULL,
                                        DATA_DEVOLUCAO_PREVISTA DATE NOT NULL,
                                        DATA_DEVOLUCAO DATE,
                                        VALOR_MULTA NUMERIC(15,2) NOT NULL DEFAULT 0.00,
                                        CONSTRAINT uq_item_usuario UNIQUE (ITEM_ID, USUARIO_ID, DATA_RETIRADA),
                                        CONSTRAINT fk_emprestimo_item FOREIGN KEY (ITEM_ID) REFERENCES ITEM(ID),
                                        CONSTRAINT fk_emprestimo_usuario FOREIGN KEY (USUARIO_ID) REFERENCES USUARIO(ID));
-- ==========================================
-- DADOS DA PRIMEIRA CARGA
-- ==========================================

-- ITENS (4 registros)
INSERT INTO ITEM (codigo, titulo, tipo, autor, edicao, disponivel)
VALUES ('L001', 'Dom Casmurro', 'LIVRO', 'Machado de Assis', 1, FALSE)
     , ('L002', 'O Pequeno Príncipe', 'LIVRO', 'Antoine de Saint-Exupéry', 2, TRUE)
     , ('R001', 'Ciência Hoje', 'REVISTA', 'SBPC', 120, FALSE)
     , ('R002', 'Superinteressante', 'REVISTA', 'Editora Abril', 450, TRUE)
    ON CONFLICT (CODIGO) DO NOTHING;

-- USUARIOS (2 registros)
INSERT INTO USUARIO (nome, tipo, limite_itens)
VALUES ('João Silva', 'ALUNO', 3)
     , ('Jaques', 'PROFESSOR', 5)
    ON CONFLICT (NOME) DO NOTHING;

-- EMPRESTIMOS (1 registros) - Em aberto
INSERT INTO EMPRESTIMO (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa)
VALUES (1, 1, '2026-09-10','2026-09-17', NULL, 0.00)
    ON CONFLICT (ITEM_ID, USUARIO_ID, DATA_RETIRADA) DO NOTHING;

-- EMPRESTIMOS (1 registros) - Ja Devolvido
INSERT INTO EMPRESTIMO (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa)
VALUES (3, 2, '2026-08-01','2026-08-08', '2026-08-10', 5.00)
    ON CONFLICT (ITEM_ID, USUARIO_ID, DATA_RETIRADA) DO NOTHING;