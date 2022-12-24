package br.com.mesttra.apipecas.dto;

import br.com.mesttra.apipecas.entity.Pecas;
import br.com.mesttra.apipecas.enums.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

public class CriarPecaDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String modeloCarro;

    @NotBlank
    private String fabricante;

    @NotNull
    private Double precoCusto;

    @NotNull
    private Double precoVenda;

    @NotNull
    private Integer quantidadeEstoque;

    private Categoria cat;

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

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }
}
