package br.com.scaf.controller;

import br.com.scaf.dto.AbateDTO;
import br.com.scaf.dto.AbateRequest;
import br.com.scaf.dto.ResumoAbateDTO;
import br.com.scaf.model.Abate;
import br.com.scaf.model.Fornecedor;
import br.com.scaf.service.AbateService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/abates")
public class AbateController {

    private final AbateService service;

    public AbateController(AbateService service) {
        this.service = service;
    }

    @GetMapping
    public List<Abate> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abate> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Abate> salvar(@RequestBody @Valid AbateRequest request) {
        Abate abate = new Abate();

        abate.setData(request.getData());
        abate.setPesoInicial(request.getPesoInicial());

        // Busca o fornecedor por ID
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(request.getFornecedorId());
        abate.setFornecedor(fornecedor);

        // Peso final e quebra são calculados automaticamente na entidade
        Abate salvo = service.salvar(abate);

        return ResponseEntity.ok(salvo);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/filtro")
    public List<Abate> filtrar(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
            @RequestParam(required = false) Long fornecedorId) {
        return service.filtrar(data, fornecedorId);
    }

    @GetMapping("/resumo")
    public ResumoAbateDTO resumo(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
            @RequestParam(required = false) Long fornecedorId) {
        return service.gerarResumo(data, fornecedorId);
    }

    @GetMapping("/filtro-dto")
    public List<AbateDTO> filtrarComDTO(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
            @RequestParam(required = false) Long fornecedorId) {

        return service.filtrar(data, fornecedorId).stream()
                .map(this::toDTO)
                .toList();
    }

    private AbateDTO toDTO(Abate abate) {
        Double quebra = abate.getPesoInicial() != null ? abate.getPesoInicial() * 0.15 : 0.0;
        Double pesoFinal = abate.getPesoInicial() != null ? abate.getPesoInicial() - quebra : 0.0;

        return new AbateDTO(
                abate.getId(),
                abate.getData(),
                abate.getPesoInicial(),
                pesoFinal,
                quebra,
                abate.getFornecedor() != null ? abate.getFornecedor().getNome() : null
        );
    }



}
