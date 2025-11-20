package com.fiap.skillriseapi.controllers;

import com.fiap.skillriseapi.domain.entities.Oportunidade;
import com.fiap.skillriseapi.service.OportunidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vagas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VagaController {

    private final OportunidadeService oportunidadeService;

    @GetMapping
    public ResponseEntity<List<Oportunidade>> findAll() {
        List<Oportunidade> oportunidades = oportunidadeService.findAll();
        return ResponseEntity.ok(oportunidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oportunidade> findById(@PathVariable Long id) {
        return oportunidadeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/trilha/{trilhaId}")
    public ResponseEntity<List<Oportunidade>> findByTrilhaId(@PathVariable Long trilhaId) {
        List<Oportunidade> oportunidades = oportunidadeService.findByTrilhaId(trilhaId);
        return ResponseEntity.ok(oportunidades);
    }

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<List<Oportunidade>> findByEmpresaId(@PathVariable Long empresaId) {
        List<Oportunidade> oportunidades = oportunidadeService.findByEmpresaId(empresaId);
        return ResponseEntity.ok(oportunidades);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Oportunidade>> findByStatus(@PathVariable String status) {
        List<Oportunidade> oportunidades = oportunidadeService.findByStatus(status.toUpperCase());
        return ResponseEntity.ok(oportunidades);
    }

    @PostMapping
    public ResponseEntity<Oportunidade> create(@RequestBody Oportunidade oportunidade) {
        Oportunidade saved = oportunidadeService.save(oportunidade);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Oportunidade> update(@PathVariable Long id, @RequestBody Oportunidade oportunidade) {
        return oportunidadeService.findById(id)
                .map(existing -> {
                    oportunidade.setOportunidadeId(id);
                    Oportunidade updated = oportunidadeService.save(oportunidade);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (oportunidadeService.findById(id).isPresent()) {
            oportunidadeService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
