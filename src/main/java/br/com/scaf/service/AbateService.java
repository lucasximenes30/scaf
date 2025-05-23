package br.com.scaf.service;

import br.com.scaf.dto.ResumoAbateDTO;
import br.com.scaf.model.Abate;
import br.com.scaf.repository.AbateRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AbateService {

    private final AbateRepository repository;

    public AbateService(AbateRepository repository) {
        this.repository = repository;
    }

    public List<Abate> listarTodos() {
        return repository.findAll();
    }

    public Optional<Abate> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Abate salvar(Abate abate) {
        return repository.save(abate);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Abate> filtrar(LocalDate data, Long fornecedorId) {
        if (data != null && fornecedorId != null) {
            return repository.findByDataAndFornecedorId(data, fornecedorId);
        } else if (data != null) {
            return repository.findByData(data);
        } else if (fornecedorId != null) {
            return repository.findByFornecedorId(fornecedorId);
        } else {
            return repository.findAll();
        }
    }

    public ResumoAbateDTO gerarResumo(LocalDate data, Long fornecedorId) {
        List<Abate> abates = filtrar(data, fornecedorId);

        long quantidade = abates.size();
        double pesoTotal = abates.stream()
                .mapToDouble(a -> a.getPesoInicial() != null ? a.getPesoInicial() : 0.0)
                .sum();

        double quebraTotal = abates.stream()
                .mapToDouble(a -> a.getQuebra() != null ? a.getQuebra() : 0.0)
                .sum();

        return new ResumoAbateDTO(quantidade, pesoTotal, quebraTotal);
    }


}
