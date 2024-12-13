/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inclusaodeprodutomvp.presenter;
import com.mycompany.inclusaodeprodutomvp.model.Produto;
import com.mycompany.inclusaodeprodutomvp.view.ExibicaoProdutoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author USER
 */
public class ExibicaoProdutoPresenter extends AbstractTableModel implements IProdutoObservador{
    private ExibicaoProdutoView view;
    private ProdutoCollection produtos;
    private String[] colunas = { "Nome", "Preço Custo", "Percentual Lucro", "Preço Venda"};
    //private int selectedRow ;
    AbstractTableModel tableModel;
    
    public ExibicaoProdutoPresenter(ProdutoCollection produtos){
        this.produtos = produtos;
        this.view = new ExibicaoProdutoView();
        view.getTblProdutos().setModel(this);
        view.setVisible(false);

        
        configuraView();
        view.setLocationRelativeTo(null);
        
        //view.setVisible(true);
    }
    
    public void configuraView(){
        
    this.view.getBtnRemover().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                remover();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    });
    
    this.view.getBtnCancelar().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cancelar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    });    
        
    }
    
    public void remover(){
        int selectedRow = view.getTblProdutos().getSelectedRow();
        
        if(selectedRow != -1){
            produtos.removeProduto(selectedRow);//CHAMA ATUALIZAR
        }else { 
            JOptionPane.showMessageDialog(null, "Selecione uma linha para remover"); 
        }
    }
    
    public void cancelar(){
        view.dispose();
    }

    @Override
    public int getRowCount() {
        return produtos.getTamanho();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = produtos.getProdutos().get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return produto.getNome();
            case 1:
                return produto.getPrecoCusto();
            case 2:
                return produto.getPercentualLucro();
            case 3:
                return produto.getPrecoVenda();
            default:
                return null;
        }
    }

    @Override
    public void atualizar(ProdutoCollection produtos) {
        view.exibirTabela();
    }
        
    public void exibeTela(){
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }


}
