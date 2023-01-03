package br.com.mesttra.apipecas.controller;


import br.com.mesttra.apipecas.dto.CriarPecaDTO;
import br.com.mesttra.apipecas.dto.ExibirPecaDTO;
import br.com.mesttra.apipecas.entity.Pecas;
import br.com.mesttra.apipecas.exception.ErroDeNegocioException;
import br.com.mesttra.apipecas.service.PecaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pecas")
@Tag(name = "Pecas", description = "API de Peças")
public class PecaController {

    @Autowired
    PecaService pecaService;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cria uma nova peça")
    public boolean criarPeca(@RequestBody @Valid CriarPecaDTO criarPecaDTO) throws ErroDeNegocioException {
        this.pecaService.criarPeca(criarPecaDTO);
        return true;
    }


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Lista todas as peças")
    public List<Pecas> buscaTodasPecas() {
        return this.pecaService.listaTodasPecas();
    }

    @DeleteMapping(path = "/{barcode}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @Operation(summary = "Deleta uma peça")
    public boolean deletarPeca(@PathVariable Long barcode) throws ErroDeNegocioException {
        return this.pecaService.deletarPeca(barcode);
    }

    @GetMapping(path = "/{texto}/comeco",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Busca peças pelo começo do nome")
    public List<ExibirPecaDTO> mostrarPeloComeco(@PathVariable String texto) {
        return this.pecaService.buscaPecaComNomeComecandoCom(texto);
    }

    @GetMapping(path = "/{modelo}/modelo",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Busca peças pelo modelo do carro")
    public List<ExibirPecaDTO> mostrarPeloModelo(@PathVariable String modelo) {
        return this.pecaService.buscaPecaPorModelo(modelo);
    }

    @GetMapping(path = "/{categoria}/categoria",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Busca peças pela categoria")
    public List<ExibirPecaDTO> mostrarPelaCategoria(@PathVariable String categoria) {
        return this.pecaService.buscaPecaPorCategoria(categoria);
    }

    @PutMapping(path = "/{barcode}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @Operation(summary = "Atualiza uma peça")
    public boolean alterarPeca(@PathVariable Long barcode, @RequestBody @Valid Pecas peca) throws ErroDeNegocioException {
        return pecaService.alterarPeca(peca, barcode);
    }



}
