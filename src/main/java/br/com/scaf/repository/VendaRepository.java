package br.com.scaf.repository;

import br.com.scaf.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByData(LocalDate data);

    List<Venda> findByClienteId(Long clienteId);

    List<Venda> findByDataAndClienteId(LocalDate data, Long clienteId);
}
