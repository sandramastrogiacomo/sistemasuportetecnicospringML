package com.suporte.sistemasuporte.controller;

import com.suporte.sistemasuporte.dto.AtendenteDTO;
import com.suporte.sistemasuporte.dto.AtendenteRespostaDTO;
import com.suporte.sistemasuporte.model.Atendente;
import com.suporte.sistemasuporte.service.AtendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/atendentes")
public class AtendenteController {

    @Autowired
    private AtendenteService atendenteService;

    @PostMapping
public ResponseEntity<Atendente> create(@RequestBody AtendenteDTO atendenteDTO) {
    Atendente atendente = atendenteService.create(atendenteDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(atendente);
    }
    @GetMapping
    public ResponseEntity<List<AtendenteRespostaDTO>> findAll() {
        List<Atendente> atendentes =atendenteService.findAll();
        List<AtendenteRespostaDTO> atendenteRespostaDTOs = atendentes.stream().map(AtendenteRespostaDTO :: new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(atendenteRespostaDTOs);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean deleted = atendenteService.delete(id);
        if(deleted){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
