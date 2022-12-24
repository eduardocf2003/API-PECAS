package br.com.mesttra.apipecas.dto;

import br.com.mesttra.apipecas.entity.Pecas;
import org.springframework.beans.BeanUtils;

public class ExibirPecaDTO {

    private long id;

    private String nome;

    private String modeloCarro;

    private String fabricante;

    private Double precoVenda;

    private Integer quantidadeEstoque;

    private String categoria;

    public static ExibirPecaDTO toDTO(Pecas peca) {
        ExibirPecaDTO dto = new ExibirPecaDTO();
        BeanUtils.copyProperties(peca, dto);

        return dto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
