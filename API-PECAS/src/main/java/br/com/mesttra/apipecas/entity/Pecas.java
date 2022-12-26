package br.com.mesttra.apipecas.entity;

import br.com.mesttra.apipecas.enums.Categoria;
import jakarta.persistence.*;

@Entity
public class Pecas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_barras")
    private Long barcode;

    @Column(name = "nome_peca", nullable = false)
    private String nome;

    @Column(name = "modelo_carro", nullable = false)
    private String modeloCarro;

    @Column(nullable = false)
    private String fabricante;

    @Column(name = "preco_custo", nullable = false)
    private Double precoCusto;

    @Column(name = "preco_venda", nullable = false)
    private Double precoVenda;

    @Column(name = "quantidade_estoque", nullable = false)
    private Integer quantidadeEstoque;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Pecas() {

    }


    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}


