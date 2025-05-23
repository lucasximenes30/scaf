package br.com.scaf.controller;

import br.com.scaf.dto.ResumoVendaDTO;
import br.com.scaf.dto.VendaDTO;
import br.com.scaf.dto.VendaRequest;
import br.com.scaf.model.Cliente;
import br.com.scaf.model.Venda;
import br.com.scaf.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Venda> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Venda> salvar(
            @RequestBody @Valid VendaRequest request) {

        // Monta a entidade
        Venda venda = new Venda();
        venda.setData(request.getData());
        venda.setPesoVendido(request.getPesoVendido());

        // Apenas setamos o ID do cliente; ensure que exista no banco
        Cliente cliente = new Cliente();
        cliente.setId(request.getClienteId());
        venda.setCliente(cliente);

        Venda salvo = service.salvar(venda);
        return ResponseEntity.ok(salvo);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/filtro")
    public List<Venda> filtrar(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
            @RequestParam(required = false) Long clienteId) {
        return service.filtrar(data, clienteId);
    }
    private VendaDTO toDTO(Venda venda) {
        VendaDTO dto = new VendaDTO();
        dto.setId(venda.getId());
        dto.setData(venda.getData());
        dto.setPesoVendido(venda.getPesoVendido());
        dto.setClienteNome(venda.getCliente().getNome());
        return dto;
    }


    @GetMapping("/filtro-dto")
    public List<VendaDTO> filtrarComDTO(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
            @RequestParam(required = false) Long clienteId) {
        return service.filtrar(data, clienteId)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @GetMapping("/resumo")
    public ResumoVendaDTO resumo(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
            @RequestParam(required = false) Long clienteId) {
        return service.gerarResumo(data, clienteId);
    }



}
