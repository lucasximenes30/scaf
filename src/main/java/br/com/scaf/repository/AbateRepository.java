package br.com.scaf.repository;

import br.com.scaf.model.Abate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AbateRepository extends JpaRepository<Abate, Long> {

    List<Abate> findByData(LocalDate data);

    List<Abate> findByFornecedorId(Long fornecedorId);

    List<Abate> findByDataAndFornecedorId(LocalDate data, Long fornecedorId);
}
