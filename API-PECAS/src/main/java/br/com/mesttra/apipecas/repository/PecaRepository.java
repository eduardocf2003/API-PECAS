package br.com.mesttra.apipecas.repository;

import br.com.mesttra.apipecas.entity.Pecas;
import jdk.jfr.Registered;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PecaRepository extends CrudRepository<Pecas, Long> {

    Optional<Pecas> findByNome(String nome);
    Optional<Pecas> findById(Long id);

}

