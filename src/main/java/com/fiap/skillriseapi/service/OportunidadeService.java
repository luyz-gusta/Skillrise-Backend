package com.fiap.skillriseapi.service;

import com.fiap.skillriseapi.domain.entities.Oportunidade;
import com.fiap.skillriseapi.repositories.OportunidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OportunidadeService {

    private final OportunidadeRepository oportunidadeRepository;

    @Transactional(readOnly = true)
    public List<Oportunidade> findAll() {
        return oportunidadeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Oportunidade> findById(Long id) {
        return oportunidadeRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Oportunidade> findByEmpresaId(Long empresaId) {
        return oportunidadeRepository.findByEmpresa_EmpresaId(empresaId);
    }

    @Transactional(readOnly = true)
    public List<Oportunidade> findByTrilhaId(Long trilhaId) {
        return oportunidadeRepository.findByTrilhaId(trilhaId);
    }

    @Transactional(readOnly = true)
    public List<Oportunidade> findByStatus(String status) {
        return oportunidadeRepository.findByStatus(status);
    }
    
    @Transactional(readOnly = true)
    public List<Oportunidade> findAtivas() {
        return oportunidadeRepository.findByStatus("ATIVA");
    }

    @Transactional
    public Oportunidade save(Oportunidade oportunidade) {
        return oportunidadeRepository.save(oportunidade);
    }

    @Transactional
    public void deleteById(Long id) {
        oportunidadeRepository.deleteById(id);
    }
}
