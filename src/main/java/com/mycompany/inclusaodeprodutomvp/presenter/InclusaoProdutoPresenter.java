/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inclusaodeprodutomvp.presenter;

import com.mycompany.inclusaodeprodutomvp.model.Produto;
import com.mycompany.inclusaodeprodutomvp.view.InclusaoProdutoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class InclusaoProdutoPresenter {
    private Produto produto;
    private InclusaoProdutoView view;
    private ProdutoCollection produtos;

    public InclusaoProdutoPresenter(ProdutoCollection produtos) {
        this.produtos = produtos;
        this.view = new InclusaoProdutoView();
        view.setVisible(false);
        
        configuraView();
        
        //view.setLocationRelativeTo(null);
        //view.setVisible(true);
    }
    
    private void configuraView() {

    this.view.getBtnIncluir().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                salvar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    });
    
    this.view.getBtnCancelar().addActionListener(new ActionListener(){
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


    private void salvar() throws Exception {
        String nome = view.getTxtNome().getText();
        if (nome    == null || nome.isEmpty()) {
            throw new Exception("Nome do produto é obrigatório");
        }
        double precoCusto = Double.parseDouble(view.getTxtPrecoCusto().getText());
        if (precoCusto  <= 0) {
            throw new Exception("Preço de custo deve ser maior que zero");
        }
        double percentualLucro = Double.parseDouble(view.getTxtPercentualLucro().getText());
        if (percentualLucro <= 0) {
            throw new Exception("Percentual de lucro deve ser maior que zero");
        }
        double precoVenda = Double.parseDouble(view.getTxtPrecoVenda().getText());
        if (precoVenda <= 0) {
            throw new Exception("Preço de venda deve ser maior que zero");
        }
        
        produto = new Produto(nome, precoCusto, percentualLucro);
        
        produtos.incluir(produto);//CHAMA ATUALIZAR
        JOptionPane.showMessageDialog(view, "Produto incluído com sucesso!");
        
    }
    
    private void cancelar(){
        view.dispose();
    }  
        
    public void exibeTela(){
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    
}
