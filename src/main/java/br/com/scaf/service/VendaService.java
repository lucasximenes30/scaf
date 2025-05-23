package br.com.scaf.service;

import br.com.scaf.dto.ResumoVendaDTO;
import br.com.scaf.dto.VendaDTO;
import br.com.scaf.model.Venda;
import br.com.scaf.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    private final VendaRepository repository;

    public VendaService(VendaRepository repository) {
        this.repository = repository;
    }

    public List<Venda> listarTodas() {
        return repository.findAll();
    }

    public Optional<Venda> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Venda salvar(Venda venda) {
        return repository.save(venda);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
    public List<Venda> filtrar(LocalDate data, Long clienteId) {
        if (data != null && clienteId != null) {
            return repository.findByDataAndClienteId(data, clienteId);
        } else if (data != null) {
            return repository.findByData(data);
        } else if (clienteId != null) {
            return repository.findByClienteId(clienteId);
        } else {
            return repository.findAll();
        }
    }

    public ResumoVendaDTO gerarResumo(LocalDate data, Long clienteId) {
        List<Venda> vendasFiltradas = filtrar(data, clienteId);

        long quantidade = vendasFiltradas.size();
        double totalPeso = vendasFiltradas.stream()
                .mapToDouble(Venda::getPesoVendido)
                .sum();

        return new ResumoVendaDTO(quantidade, totalPeso);
    }



}
