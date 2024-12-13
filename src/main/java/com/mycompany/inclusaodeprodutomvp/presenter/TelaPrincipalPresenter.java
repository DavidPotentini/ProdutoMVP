/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inclusaodeprodutomvp.presenter;

import com.mycompany.inclusaodeprodutomvp.model.Produto;
import com.mycompany.inclusaodeprodutomvp.view.ExibicaoProdutoView;
import com.mycompany.inclusaodeprodutomvp.view.InclusaoProdutoView;
import com.mycompany.inclusaodeprodutomvp.view.TelaPrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author USER
 */
public class TelaPrincipalPresenter implements IProdutoObservador{
    private Produto produto;
    private TelaPrincipalView viewPrincipal;
    //private InclusaoProdutoView viewInclusaoProduto;
    //private ExibicaoProdutoView viewExibicaoProduto;
    private InclusaoProdutoPresenter presenterInclusaoProduto;
    private ExibicaoProdutoPresenter presenterExibicaoProduto;
    private ProdutoCollection produtos;

    public TelaPrincipalPresenter(ProdutoCollection produtos) {
        this.produtos = produtos;
        this.viewPrincipal = new TelaPrincipalView();
        //viewInclusaoProduto = new InclusaoProdutoView();
        //viewExibicaoProduto = new ExibicaoProdutoView();
        
        presenterInclusaoProduto = new InclusaoProdutoPresenter(produtos);
        presenterExibicaoProduto = new ExibicaoProdutoPresenter(produtos);
        
        viewPrincipal.setVisible(false);
        
        configuraView();
        viewPrincipal.setLocationRelativeTo(null);
        viewPrincipal.setVisible(true);
    }

    private void configuraView() {
        
    this.viewPrincipal.getBtnIncluirProdutos().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                exibirTelaInclusaoProdutos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    });
    
    this.viewPrincipal.getBtnExibirProdutos().addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                exibirTelaExibicaoProdutos();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    });
    
    this.viewPrincipal.getBtnCancelar().addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                cancelar();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    });
    
    }
    
    private void exibirTelaInclusaoProdutos() {
        //viewInclusaoProduto.setLocationRelativeTo(null);
        //viewInclusaoProduto.setVisible(true);
        presenterInclusaoProduto.exibeTela();

    }

    private void exibirTelaExibicaoProdutos() {
        //viewExibicaoProduto.setLocationRelativeTo(null);
        //viewExibicaoProduto.setVisible(true);
        presenterExibicaoProduto.exibeTela();
    }   
    
    private void cancelar() {
        viewPrincipal.dispose();
    }     
    
    
    @Override
    public void atualizar(ProdutoCollection produtos) {
        int qtdProdutos = produtos.getTamanho();
        viewPrincipal.exibirQtdProdutos(qtdProdutos);
    }
}
