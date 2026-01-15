package br.com.lgbv.prateleira_inteligente_v2.controllers;

import br.com.lgbv.prateleira_inteligente_v2.entities.BaseEntity;
import br.com.lgbv.prateleira_inteligente_v2.mappers.BaseMapper;
import br.com.lgbv.prateleira_inteligente_v2.services.IGenericService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/")
@RequiredArgsConstructor

public abstract class GenericController<E extends
        BaseEntity,
        DTO,
        S extends IGenericService<E>,
        M extends BaseMapper<E, DTO>>   {

    protected final S service;
    protected final M mapper;

    protected GenericController() {
        this.service = null;
        this.mapper = null;
    }

    @PostMapping
    public ResponseEntity<DTO> create (@Valid @RequestBody DTO dto) {
        E entity = mapper.toEntity(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toDto(service.save(entity)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> update (@PathVariable UUID id, @Valid @RequestBody DTO dto) {
        E entity = mapper.toEntity(dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapper.toDto(service.update(id, entity)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(mapper.toDto(service.getById(id)));
    }

    @GetMapping
    public ResponseEntity<List<DTO>> getAll() {
        return ResponseEntity.ok(service
                .getAll()
                .stream()
                .map(mapper::toDto)
                .toList());
    }

    @GetMapping("/ids")
    public ResponseEntity<List<DTO>> getByIds(@RequestParam List<UUID> ids) {
        return ResponseEntity.ok(service
                .getAllByIds(ids)
                .stream()
                .map(mapper::toDto)
                .toList()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DTO> delete(@PathVariable UUID id) {
        return service.deleteById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
