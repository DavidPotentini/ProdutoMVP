/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inclusaodeprodutomvp;

import com.mycompany.inclusaodeprodutomvp.presenter.ExibicaoProdutoPresenter;
import com.mycompany.inclusaodeprodutomvp.presenter.IProdutoObservador;
import com.mycompany.inclusaodeprodutomvp.presenter.ProdutoCollection;
import com.mycompany.inclusaodeprodutomvp.presenter.TelaPrincipalPresenter;


/**
 *
 * @author USER
 */
public class InclusaoDeProdutoMVP {

    public static void main(String[] args) {
        
        ProdutoCollection produtos = new ProdutoCollection();
        IProdutoObservador exibicaoProduto = new ExibicaoProdutoPresenter(produtos); 
        IProdutoObservador telaPrincipal = new TelaPrincipalPresenter(produtos); 
        
        produtos.registrarObservador(telaPrincipal);
        produtos.registrarObservador(exibicaoProduto);
        
        //A TABELA ESTA SENDO ATUALIZADA MAS AO CLICAR EM REMOVER TEM QUE FECHAR(BOTAO CANCELAR) E ABRIR NOVAMENTE PARA ATUALIZAR 
        
        }
    }

