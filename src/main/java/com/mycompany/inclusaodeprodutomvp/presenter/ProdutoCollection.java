/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inclusaodeprodutomvp.presenter;

import com.mycompany.inclusaodeprodutomvp.model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author USER
 */
public class ProdutoCollection {
    private List<IProdutoObservador> observadores;
    private List<Produto> produtos;

    public ProdutoCollection() {
        observadores = new ArrayList<>();
        produtos = new ArrayList<>();
    }
    
    public void incluir(Produto produto){
        if(produtos == null){
            throw new IllegalArgumentException("Informe um produto válido");
        }
        produtos.add(produto);
        notificarObservadores(this);
    }
    
    public void removeProduto(int index) { 

        if (index >= 0 && index < produtos.size()) { 
            produtos.remove(index); 
        } 
        
        notificarObservadores(this);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    
    public int getTamanho(){
        return produtos.size();
    }
    
    public Optional<Produto> findProdutoByNome(String nome) {
        Optional<Produto> optProduto = null;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return optProduto.of(produto);
            }
        }
        return optProduto.empty();
    }
    
    public void registrarObservador(IProdutoObservador observador){
        observadores.add(observador);
    }
    
    public void removerObservador(IProdutoObservador observador){
        observadores.remove(observador);
    }

    
    private void notificarObservadores(ProdutoCollection produtos) {
        for(IProdutoObservador observador: observadores){
            observador.atualizar(produtos);
        }
    }

}
