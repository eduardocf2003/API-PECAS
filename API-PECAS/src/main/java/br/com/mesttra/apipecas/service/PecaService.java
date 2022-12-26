package br.com.mesttra.apipecas.service;

import br.com.mesttra.apipecas.dto.CriarPecaDTO;
import br.com.mesttra.apipecas.dto.ExibirPecaDTO;
import br.com.mesttra.apipecas.entity.Pecas;
import br.com.mesttra.apipecas.enums.Categoria;
import br.com.mesttra.apipecas.exception.ErroDeNegocioException;
import br.com.mesttra.apipecas.repository.PecaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PecaService {

    @Autowired
    PecaRepository pecaRepository;

    public void criarPeca(CriarPecaDTO criarPecaDTO) throws ErroDeNegocioException {

        Pecas pecasEntity = new Pecas();
        BeanUtils.copyProperties(criarPecaDTO, pecasEntity);

        pecaRepository.save(pecasEntity);

    }

    public ExibirPecaDTO buscaPeca (Long id) throws ErroDeNegocioException {
        Optional<Pecas> pecaBanco = pecaRepository.findById(id);
        if (pecaBanco.isPresent()) {
            return ExibirPecaDTO.toDTO(pecaBanco.get());
        }

        throw new ErroDeNegocioException("Peça não encontrada");
    }

    public List<Pecas> listaTodasPecas() {
        return (List<Pecas>) pecaRepository.findAll();
    }

    public boolean alterarPeca (Pecas peca) {
        if (!pecaRepository.existsById(peca.getBarcode())) {
            return false;
        }

        pecaRepository.save(peca);
        return true;

    }

    public boolean deletarPeca (Long id) {
        if (!pecaRepository.existsById(id)) {
            return false;
        }

        pecaRepository.deleteById(id);
        return true;
    }

    public List<ExibirPecaDTO> buscaPecaComNomeComecandoCom(String texto) {

        List<Pecas> pecas = pecaRepository.findByNomeStartsWith(texto);

        return listarPcs(pecas);

    }

    public List<ExibirPecaDTO> buscaPecaPorCategoria(String categoria) {

        List<Pecas> pecas = pecaRepository.findByCategoria(Enum.valueOf(Categoria.class, categoria));

        return listarPcs(pecas);

    }

    public List<ExibirPecaDTO> buscaPecaPorModelo(String modelo) {

        List<Pecas> pecas = pecaRepository.findByModeloCarro(modelo);

        return listarPcs(pecas);

    }

    private List<ExibirPecaDTO> listarPcs(List<Pecas> pecas) {
        List<ExibirPecaDTO> pecasDTO = new ArrayList<>();

        for (Pecas peca : pecas) {

            pecasDTO.add(ExibirPecaDTO.toDTO(peca));

        }

        return pecasDTO;
    }











}
