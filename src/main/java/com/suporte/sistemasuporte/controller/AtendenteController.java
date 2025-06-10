package com.suporte.sistemasuporte.controller;

import com.suporte.sistemasuporte.dto.AtendenteDTO;
import com.suporte.sistemasuporte.dto.AtendenteRespostaDTO;
import com.suporte.sistemasuporte.model.AtendenteModel;
import com.suporte.sistemasuporte.service.AtendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/atendentes")
public class AtendenteController {

    @Autowired
    private AtendenteService atendenteService;

    @PostMapping
public ResponseEntity<AtendenteModel> create(@RequestBody AtendenteDTO atendenteDTO) {
    AtendenteModel atendente = atendenteService.create(atendenteDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(atendente);
    }

    @GetMapping
    public ResponseEntity<Page<AtendenteRespostaDTO>> findAll(Pageable pageable) {
        Page<AtendenteModel> atendentes = atendenteService.findAll(pageable);
        Page<AtendenteRespostaDTO> dtoPage = atendentes.map(AtendenteRespostaDTO :: new);
        return ResponseEntity.ok(dtoPage);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        atendenteService.delete(id);
            return ResponseEntity.noContent().build();

        }
    }

