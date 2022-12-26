package br.com.mesttra.apipecas.dto;

import br.com.mesttra.apipecas.entity.Pecas;
import br.com.mesttra.apipecas.enums.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

public class CriarPecaDTO {

    @NotBlank(message = "O nome da peça é obrigatório")
    private String nome;

    @NotBlank(message = "O modelo do carro é obrigatório")
    private String modeloCarro;

    @NotBlank(message = "O fabricante não pode ser nulo")
    private String fabricante;

    @NotNull(message = "O preço de custo não pode ser nulo")
    private Double precoCusto;

    @NotNull(message = "O preço de venda é obrigatório")
    private Double precoVenda;

    @NotNull(message = "Quantidade em estoque é obrigatória")
    private Integer quantidadeEstoque;

    private Categoria categoria;

    public Pecas toEntity() {
        Pecas peca = new Pecas();
        BeanUtils.copyProperties(this, peca);
        return peca;
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
