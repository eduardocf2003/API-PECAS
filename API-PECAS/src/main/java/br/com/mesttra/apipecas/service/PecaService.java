package br.com.mesttra.apipecas.service;

import br.com.mesttra.apipecas.dto.CriarPecaDTO;
import br.com.mesttra.apipecas.entity.Pecas;
import br.com.mesttra.apipecas.exception.ErroDeNegocioException;
import br.com.mesttra.apipecas.repository.PecaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PecaService {

    @Autowired
    PecaRepository pecaRepository;

    public boolean criarPeca(CriarPecaDTO criarPecaDTO) throws ErroDeNegocioException {

        Pecas pecasEntity = new Pecas();
        BeanUtils.copyProperties(criarPecaDTO, pecasEntity);

        pecaRepository.save(pecasEntity);
        return true;

    }

    public Pecas buscaPeca (Long id) {
        Optional<Pecas> pecaBanco = pecaRepository.findById(id);
        if (pecaBanco.isPresent()) {
            return pecaBanco.get();
        }

        return null;
    }







}
