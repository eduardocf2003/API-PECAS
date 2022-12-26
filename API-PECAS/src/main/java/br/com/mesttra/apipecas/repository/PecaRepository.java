package br.com.mesttra.apipecas.repository;

import br.com.mesttra.apipecas.entity.Pecas;
import jdk.jfr.Registered;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.mesttra.apipecas.enums.Categoria;

import java.util.List;
import java.util.Optional;

@Repository
public interface PecaRepository extends CrudRepository<Pecas, Long> {

    List<Pecas> findByNomeStartsWith(String texto);

    List<Pecas> findByCategoria(Categoria categoria);

    List<Pecas> findByModeloCarro(String modelo);

}

