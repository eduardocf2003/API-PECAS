package br.com.mesttra.apipecas.entity;

import br.com.mesttra.apipecas.enums.Categoria;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Pecas {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "cod_barras")
    private Long id;

    @Column (name = "nome_peca", nullable = false)
    private String nome;

    @Column (name = "modelo_carro", nullable = false)
    private String modeloCarro;

    @Column (nullable = false)
    private String fabricante;

    @Column (name = "preco_custo", nullable = false)
    private Double preco;

    @Column (name = "preco_venda", nullable = false)
    private Double precoVenda;

    @Column (name = "quantidade_estoque", nullable = false)
    private Integer quantidadeEstoque;

    @Column (nullable = false)
    private Categoria Cat;

    public Pecas () {

    }

    public Pecas(Long id, String nome, String modeloCarro, String fabricante, Double preco, Double precoVenda, Integer quantidadeEstoque, Categoria cat) {
        this.id = id;
        this.nome = nome;
        this.modeloCarro = modeloCarro;
        this.fabricante = fabricante;
        this.preco = preco;
        this.precoVenda = precoVenda;
        this.quantidadeEstoque = quantidadeEstoque;
        Cat = cat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
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

    public Categoria getCat() {
        return Cat;
    }

    public void setCat(Categoria cat) {
        Cat = cat;
    }

    @Override
    public String toString() {
        return "Pecas{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", modeloCarro='" + modeloCarro + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", preco=" + preco +
                ", precoVenda=" + precoVenda +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", Cat=" + Cat +
                '}';
    }
}
