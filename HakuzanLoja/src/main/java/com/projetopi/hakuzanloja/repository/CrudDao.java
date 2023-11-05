package com.projetopi.hakuzanloja.repository;

import java.util.List;

public interface CrudDao<T> {

    public void criarTabela();
    public List<T> listarTodos();
    public void cadastrar(T objeto);
    public void editar(T objeto);
    public void excluir(T objeto);


}
