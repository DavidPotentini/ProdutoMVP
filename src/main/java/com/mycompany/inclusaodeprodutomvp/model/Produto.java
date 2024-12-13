/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inclusaodeprodutomvp.model;

/**
 *
 * @author USER
 */
public class Produto {
    private String nome;
    private double precoCusto;
    private double percentualLucro;
    private double precoVenda;

    public Produto(String nome, double precoCusto, double percentualLucro) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.percentualLucro = percentualLucro;
        this.precoVenda = calcularPrecoVenda();
    }
    public double calcularPrecoVenda() {
        return precoCusto + (precoCusto * percentualLucro / 100);
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public double getPercentualLucro() {
        return percentualLucro;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", precoCusto=" + precoCusto + ", percentualLucro=" + percentualLucro + ", precoVenda=" + precoVenda + '}';
    }
    
    

}
