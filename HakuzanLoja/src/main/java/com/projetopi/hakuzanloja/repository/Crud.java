package com.projetopi.hakuzanloja.repository;

import com.projetopi.hakuzanloja.model.FormaPagamento;

public interface Crud<T> {

    public void criarTabela();
    //public List<T> listarTodos();
    public void cadastrar(T objeto);
    public void editar(T objeto);
    public void excluir(T objeto);


}
