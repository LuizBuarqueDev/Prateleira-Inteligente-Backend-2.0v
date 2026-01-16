package br.com.lgbv.prateleira_inteligente_v2.controllers;

import br.com.lgbv.prateleira_inteligente_v2.services.IGenericService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api")
public abstract class GenericController<DTO> {

    protected final IGenericService<DTO> service;

    protected GenericController(IGenericService<DTO> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DTO> create(@Valid @RequestBody DTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> update(
            @PathVariable UUID id,
            @Valid @RequestBody DTO dto
    ) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<DTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/ids")
    public ResponseEntity<List<DTO>> getByIds(@RequestParam List<UUID> ids) {
        return ResponseEntity.ok(service.getAllByIds(ids));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        return service.deleteById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
