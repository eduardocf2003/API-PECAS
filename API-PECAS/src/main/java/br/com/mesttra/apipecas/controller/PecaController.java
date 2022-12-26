package br.com.mesttra.apipecas.controller;


import br.com.mesttra.apipecas.dto.CriarPecaDTO;
import br.com.mesttra.apipecas.dto.ExibirPecaDTO;
import br.com.mesttra.apipecas.entity.Pecas;
import br.com.mesttra.apipecas.exception.ErroDeNegocioException;
import br.com.mesttra.apipecas.service.PecaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pecas")
public class PecaController {

    @Autowired
    PecaService pecaService;


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public boolean criarPeca(@RequestBody @Valid CriarPecaDTO criarPecaDTO) throws ErroDeNegocioException {
        this.pecaService.criarPeca(criarPecaDTO);
        return true;
    }


    @GetMapping
    public List<Pecas> buscaTodasPecas() {
        return this.pecaService.listaTodasPecas();
    }

    @DeleteMapping(path = "/{barcode}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public boolean deletarPeca(@PathVariable Long barcode) throws ErroDeNegocioException {
        return this.pecaService.deletarPeca(barcode);
    }

    @GetMapping(path = "/{texto}/comeco")
    public List<ExibirPecaDTO> mostrarPeloComeco(@PathVariable String texto) {
        return this.pecaService.buscaPecaComNomeComecandoCom(texto);
    }

    @GetMapping(path = "/{modelo}/modelo")
    public List<ExibirPecaDTO> mostrarPeloModelo(@PathVariable String modelo) {
        return this.pecaService.buscaPecaPorModelo(modelo);
    }

    @GetMapping(path = "/{categoria}/categoria")
    public List<ExibirPecaDTO> mostrarPelaCategoria(@PathVariable String categoria) {
        return this.pecaService.buscaPecaPorCategoria(categoria);
    }

    @PutMapping(path = "/{barcode}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public boolean alterarPeca(@PathVariable Long barcode, @RequestBody Pecas peca) throws ErroDeNegocioException {
        return this.pecaService.alterarPeca(peca);
    }



}
