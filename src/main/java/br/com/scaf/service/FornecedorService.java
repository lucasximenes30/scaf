package br.com.scaf.service;

import br.com.scaf.model.Fornecedor;
import br.com.scaf.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    private final FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }

    public List<Fornecedor> listarTodos() {
        return repository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public void deletar(Long id) {
        Fornecedor fornecedor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        if (!fornecedor.getAbates().isEmpty()) {
            throw new RuntimeException("Fornecedor possui abates e não pode ser excluído.");
        }

        repository.delete(fornecedor);
    }

}
